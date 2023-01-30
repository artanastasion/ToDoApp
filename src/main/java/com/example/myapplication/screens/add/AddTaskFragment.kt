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
import com.example.myapplication.model.TaskListModel
import com.example.myapplication.model.TaskModel

class AddTaskFragment : Fragment(){

    lateinit var binding: FragmentAddTaskBinding
    lateinit var current: TaskListModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        binding = FragmentAddTaskBinding.inflate(layoutInflater, container, false)
        current = arguments?.getSerializable("list") as TaskListModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(AddTaskViewModel::class.java)
        binding.btnAddTask.setOnClickListener {
            val title = binding.titleDetail.text.toString()
            val discribtion = binding.discribtionDetail.text.toString()
            val favourite = binding.favorites.isChecked
            val list = current.id

            viewModel.insert(
                TaskModel(
                    title = title,
                    discription = discribtion,
                    date = 12,
                    completed = false,
                    favorite = favourite,
                    list = list
                )
            ) {}
            APP.navController.navigate(R.id.action_addTaskFragment_to_startFragment)

        }
        binding.btnBack.setOnClickListener {
            APP.navController.navigate(R.id.action_addTaskFragment_to_startFragment)
        }
    }
}