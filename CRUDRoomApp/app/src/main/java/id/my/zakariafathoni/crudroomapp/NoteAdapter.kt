package id.my.zakariafathoni.crudroomapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.my.zakariafathoni.crudroomapp.room.Note
import kotlinx.android.synthetic.main.adapter_main.view.*

class NoteAdapter (private var notes: ArrayList<Note>, private val listener: OnAdapterListener) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.adapter_main,
                    parent,
                    false
                )
        )
    }

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.view.text_title.text = note.title
        holder.view.text_title.setOnClickListener {
            listener.onRead(note)
        }
        holder.view.icon_edit.setOnClickListener {
            listener.onUpdate(note)
        }
        holder.view.icon_delete.setOnClickListener {
            listener.onDelete(note)
        }

    }

    inner class NoteViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    fun setData(newList: List<Note>) {
        notes.clear()
        notes.addAll(newList)
        notifyDataSetChanged()
    }

    interface OnAdapterListener {
        fun onRead(note: Note)
        fun onUpdate(note: Note)
        fun onDelete(note: Note)
    }
}