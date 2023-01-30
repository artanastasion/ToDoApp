package com.example.myapplication.screens.detail

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.APP
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentDetailBinding
import com.example.myapplication.model.TaskModel


class DetailTaskFragment : Fragment() {

    lateinit var binding: FragmentDetailBinding

    lateinit var currentTask: TaskModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        currentTask = arguments?.getSerializable("task") as TaskModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(DetailTaskViewModel::class.java)
        binding.favorites.isChecked = currentTask.favorite
        binding.titleDetail.setText(currentTask.title)
        binding.discribtionDetail.setText(currentTask.discription)

        binding.btnDelete.setOnClickListener{
            viewModel.delete(currentTask){}
            APP.navController.navigate(R.id.action_detailTaskFragment_to_startFragment)

        }
        binding.btnSaveTask.setOnClickListener{
            //viewModel.update(currentTask){}
            val id = currentTask.id
            val title = binding.titleDetail.getText().toString()
            val discribtion = binding.discribtionDetail.getText().toString()
            val favourite = binding.favorites.isChecked
            viewModel.update(TaskModel(id = id, title = title, discription = discribtion, date = 12, completed = false, favorite = favourite, list = 0)){}

            APP.navController.navigate(R.id.action_detailTaskFragment_to_startFragment)
        }



        binding.btnBack.setOnClickListener{
            APP.navController.navigate(R.id.action_detailTaskFragment_to_startFragment)
        }

    }

}