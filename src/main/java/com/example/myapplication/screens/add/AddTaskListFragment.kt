package com.example.myapplication.screens.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.APP
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentAddTaskBinding
import com.example.myapplication.databinding.FragmentAddTaskListBinding
import com.example.myapplication.model.TaskListModel
import com.example.myapplication.model.TaskModel

class AddTaskListFragment : Fragment() {

    lateinit var binding: FragmentAddTaskListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddTaskListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(AddTaskListViewModel::class.java)
        binding.btnAddList.setOnClickListener {
            val title = binding.titleListDetail.text.toString()
            viewModel.insert(TaskListModel(title = title)) {}
            APP.navController.navigate(R.id.action_addTaskListFragment_to_startFragment)

        }
        binding.btnBack.setOnClickListener {
            APP.navController.navigate(R.id.action_addTaskListFragment_to_startFragment)
        }
    }
}