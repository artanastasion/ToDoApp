package com.example.myapplication.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentAddTaskListBinding
import com.example.myapplication.databinding.FragmentDetailBinding
import com.example.myapplication.databinding.FragmentDetailTaskListBinding
import com.example.myapplication.model.TaskListModel
import com.example.myapplication.model.TaskModel

class DetailTaskListFragment : Fragment() {

    lateinit var binding: FragmentDetailTaskListBinding

    lateinit var currentList: TaskListModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailTaskListBinding.inflate(layoutInflater, container, false)
        currentList = arguments?.getSerializable("task") as TaskListModel
        return binding.root
    }



}