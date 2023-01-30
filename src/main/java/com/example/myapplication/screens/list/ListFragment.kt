package com.example.myapplication.screens.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.APP
import com.example.myapplication.R
import com.example.myapplication.adapter.TaskAdapter
import com.example.myapplication.databinding.FragmentListBinding
import com.example.myapplication.model.TaskModel

class ListFragment : Fragment() {

    lateinit var binding: FragmentListBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapterTask: TaskAdapter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.initDatabase()
        recyclerView = binding.rvFavorites
        adapterTask = TaskAdapter()
        recyclerView.adapter = adapterTask
        viewModel.getFavorites().observe(viewLifecycleOwner,{listTasks ->
            adapterTask.setListTasks(listTasks.asReversed())
        })



        binding.btnBack.setOnClickListener{
            APP.navController.navigate(R.id.action_listFragment_to_startFragment)
        }

    }
    companion object{
        fun clickedTask(taskModel: TaskModel){
            val bundle = Bundle()
            bundle.putSerializable("task", taskModel)
            APP.navController.navigate(R.id.action_sortListFragment_to_detailTaskFragment, bundle)
        }
    }
}