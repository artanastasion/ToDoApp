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
import com.example.myapplication.databinding.FragmentSortListBinding
import com.example.myapplication.model.TaskListModel
import com.example.myapplication.model.TaskModel

class SortListFragment : Fragment() {

    lateinit var binding: FragmentSortListBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapterTask: TaskAdapter
    lateinit var currentList: TaskListModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSortListBinding.inflate(layoutInflater, container, false)
        currentList = arguments?.getSerializable("list") as TaskListModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(SortListViewModel::class.java)
        viewModel.initDatabase()
        recyclerView = binding.rvSort
        binding.startTextview.text = currentList.title
        adapterTask = TaskAdapter()
        recyclerView.adapter = adapterTask
        viewModel.getSortList(currentList.id).observe(viewLifecycleOwner,{listTasks ->
            adapterTask.setListTasks(listTasks.asReversed())
        })


        binding.btnAdd.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("list", currentList)
            APP.navController.navigate(R.id.action_sortListFragment_to_addTaskFragment, bundle)
        }

        binding.btnBack.setOnClickListener{
            APP.navController.navigate(R.id.action_sortListFragment_to_startFragment)
        }

        }

}