package jp.dorakura.myapplication.ui.todo

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import jp.dorakura.myapplication.R
import jp.dorakura.myapplication.ui.todo.ToDoList


class ToDoBE(

    private val todoitems: MutableList<ToDoList>
) : RecyclerView.Adapter<ToDoBE.todoViewHolder>() {

    class todoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): todoViewHolder {
        return todoViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.task_item, parent, false
            )
        )
    }


    fun addTask(todo: ToDoList) {
        todoitems.add(todo)
        notifyItemInserted(todoitems.size - 1)
    }

    fun deleteDone() {
        todoitems.removeAll { todo ->
            todo.isDone
        }
        notifyDataSetChanged()
    }

    private fun toggleStrikeThrough(textView: TextView, isChecked: Boolean) {
        if (isChecked) {
            textView.paintFlags = textView.paintFlags or STRIKE_THRU_TEXT_FLAG

        } else {
            textView.paintFlags = textView.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    override fun onBindViewHolder(holder: todoViewHolder, position: Int) {
        val currentTask = todoitems[position]
        holder.itemView.apply {

            val textView: TextView = findViewById(R.id.taskTitle)
            textView.text = currentTask.name
            val checkBox: CheckBox = findViewById(R.id.task_checkbox)
            checkBox.isChecked = currentTask.isDone
            toggleStrikeThrough(textView, currentTask.isDone)
            checkBox.setOnCheckedChangeListener { _, isChecked ->
                toggleStrikeThrough(textView, isChecked)
                currentTask.isDone = !currentTask.isDone
            }
        }
    }

    override fun getItemCount(): Int {
        return todoitems.size
    }

}