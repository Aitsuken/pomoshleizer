package jp.dorakura.myapplication.ui.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import jp.dorakura.myapplication.R
import jp.dorakura.myapplication.databinding.FragmentTodoBinding

class ToDoFragment : Fragment() {

    private lateinit var todoAdapter: ToDoBE
    private var _binding: FragmentTodoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        todoAdapter = ToDoBE(mutableListOf())
        binding.viewTodoList.adapter = todoAdapter

        val layoutManager = LinearLayoutManager(activity)
        (binding.viewTodoList).layoutManager = layoutManager

        binding.addTodo.setOnClickListener {
            val todoTitle = binding.etTodoTitle.text.toString()
            if (todoTitle.isNotEmpty()) {
                val todo = ToDoList(todoTitle)
                todoAdapter.addTask(todo)
                binding.etTodoTitle.text.clear()
            }
        }
        binding.deleteTodo.setOnClickListener {
            todoAdapter.deleteDone()
        }

        _binding = FragmentTodoBinding.inflate(inflater, container, false)
        val root: View = inflater.inflate(R.layout.fragment_todo, container, false)
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}