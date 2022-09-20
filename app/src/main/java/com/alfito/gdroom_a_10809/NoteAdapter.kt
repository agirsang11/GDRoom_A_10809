package com.alfito.gdroom_a_10809

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.alfito.gdroom_a_10809.room.Note
import kotlinx.android.synthetic.main.adapter_note.view.*
import java.lang.reflect.Type
import java.text.FieldPosition

class NoteAdapter (private val notes: ArrayList<Note>, private val listener: OnAdapterListener) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
            return NoteViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_note,parent, false))
        }

        override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
            val note = notes[position]
            holder.view.text_title.text = note.title
            holder.view.text_title.setOnClickListener{
                listener.onClick(note)
            }
            holder.view.icon_edit.setOnClickListener {
                listener.onUpdate(note)
            }
            holder.view.icon_delete.setOnClickListener {
                listener.onDelete(note)
            }
        }

        override fun getItemCount() = notes.size

        inner class NoteViewHolder( val view: View) : RecyclerView.ViewHolder(view)

        @SuppressLint("NotifyDataSetChanged")
        fun setData(list: List<Note>) {
            notes.clear()
            notes.addAll(list)
            notifyDataSetChanged()
        }

        interface OnAdapterListener {
            fun onClick(note: Note)
            fun onUpdate(note: Note)
            fun onDelete(note: Note)
        }

    }