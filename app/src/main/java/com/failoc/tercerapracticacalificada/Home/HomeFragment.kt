package com.failoc.tercerapracticacalificada.Home

import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.failoc.tercerapracticacalificada.Model.Nota
import com.failoc.tercerapracticacalificada.R
import com.google.android.material.snackbar.Snackbar

import kotlinx.android.synthetic.main.dialog_note.*
import kotlinx.android.synthetic.main.dialog_note.view.*
import kotlinx.android.synthetic.main.fragment_nota.*


class HomeFragment : Fragment(), HomeAdapter.ItemClickListener{

    private lateinit var noteViewModel: HomeViewModel

    lateinit var  List: List<Nota>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_nota, container, false)
    }

    companion object {
        fun newInstance(): HomeFragment = HomeFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        noteViewModel = run {
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        }

        fabRegisterNota.setOnClickListener {
            RegisterAndUpdateNote(null, TypeNoteOperation.REGISTER)
        }

        loadData()
        configurationTouchRecycler()
    }

    private fun loadData() {
        val adapter = HomeAdapter(this)
        recyclerNota.adapter = adapter
        recyclerNota.layoutManager = LinearLayoutManager(activity)

        noteViewModel.notes.observe(viewLifecycleOwner) { notes ->
            if (notes.isNotEmpty()){
                List = notes
                notes?.let {
                    adapter.setNotes(notes)
                }
            }
        }
    }

    private fun RegisterAndUpdateNote(nota: Nota?, type: TypeNoteOperation) {

        val mDialogView = LayoutInflater.from(context).inflate(R.layout.dialog_note, null)

        val titleAlertNota = if (type == TypeNoteOperation.REGISTER) "Registrar Reseña" else "Editar Reseña"

        val mBuilder = AlertDialog.Builder(context)
            .setView(mDialogView)
            .setTitle(titleAlertNota)

        val mAlertDialog = mBuilder.show()

        if(type == TypeNoteOperation.UPDATE){
            mDialogView.textaddtitle.setText(nota?.title)
            mDialogView.textaddautor.setText(nota?.title)
            mDialogView.textaddcategoria.setText(nota?.title)
            mDialogView.textaddeditorial.setText(nota?.title)
            mDialogView.textadddescription.setText(nota?.description)
        }

        mAlertDialog.btnRegisterNota.setOnClickListener {

            mAlertDialog.dismiss()

            val titleNote = mDialogView.textaddtitle.text.toString()
            val autorNote = mDialogView.textaddautor.text.toString()
            val categoryNote = mDialogView.textaddcategoria.text.toString()
            val editorialNote = mDialogView.textaddeditorial.text.toString()
            val descriptionNote = mDialogView.textadddescription.text.toString()


            val note = Nota(titleNote, autorNote, categoryNote, editorialNote,descriptionNote)

            if (type ==TypeNoteOperation.REGISTER){
                noteViewModel.saveNote(note)
            }else{
                if (nota != null){
                    note.noteID = nota.noteID
                }
                noteViewModel.updateNote(note)
            }
        }

    }

    override fun onItemClick(nota: Nota) {
        RegisterAndUpdateNote(nota, TypeNoteOperation.UPDATE)
    }

    private fun configurationTouchRecycler(){

        val itemTouchHelperCallback =
            object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT){
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return false
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val position = viewHolder.adapterPosition
                    noteViewModel.deleteNote(List[position])

                    view!!.snack("Reseña eliminada correctamente")

                }

                override fun getMovementFlags(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder
                ): Int {
                    return ItemTouchHelper.Callback.makeMovementFlags(ItemTouchHelper.LEFT , ItemTouchHelper.START)
                }
            }

        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(recyclerNota)
    }

    fun View.snack(mensaje: String, duration: Int = Snackbar.LENGTH_LONG){
        val snackBar = Snackbar.make(this, mensaje, duration)
        val snackBarView = snackBar.view
        snackBarView.setBackgroundColor(Color.RED)
        snackBar.show()
    }

}