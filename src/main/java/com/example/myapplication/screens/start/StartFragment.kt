package com.example.myapplication.screens.start

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
import com.example.myapplication.adapter.TaskListAdapter
import com.example.myapplication.databinding.FragmentStartBinding
import com.example.myapplication.model.TaskListModel
import com.example.myapplication.model.TaskModel


class StartFragment : Fragment() {

    lateinit var binding: FragmentStartBinding
    lateinit var recyclerView: RecyclerView
    lateinit var recyclerViewList: RecyclerView
    lateinit var adapterTask: TaskAdapter
    lateinit var adapterList: TaskListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(StartViewModel::class.java)
        viewModel.initDatabase()
        recyclerView = binding.rvTasks
        recyclerViewList = binding.lists
        adapterList = TaskListAdapter()
        adapterTask = TaskAdapter()
        recyclerViewList.adapter = adapterList
        recyclerView.adapter = adapterTask
        viewModel.getAllTasks().observe(viewLifecycleOwner,{listTasks ->
            adapterTask.setListTasks(listTasks.asReversed())
        })

        viewModel.getAllLists().observe(viewLifecycleOwner,{list ->
            adapterList.setList(list.asReversed())
        })

        binding.btnAdd.setOnClickListener{
            val _bundle = Bundle()
            val list_nun = TaskListModel(title = "")
            _bundle.putSerializable("list", list_nun)
            APP.navController.navigate(R.id.action_startFragment_to_addTaskFragment, _bundle)
        }
        binding.btnSaveList.setOnClickListener{
            APP.navController.navigate(R.id.action_startFragment_to_addTaskListFragment)
        }

        binding.favoritesTv.setOnClickListener{
            APP.navController.navigate(R.id.action_startFragment_to_listFragment)
        }

    }

    companion object{
        fun clickedTask(taskModel: TaskModel){
            val bundle = Bundle()
            bundle.putSerializable("task", taskModel)
            APP.navController.navigate(R.id.action_startFragment_to_detailTaskFragment, bundle)
        }

        fun clickedList(taskListModel: TaskListModel){
            val bundle = Bundle()
            bundle.putSerializable("list", taskListModel)
            APP.navController.navigate(R.id.action_startFragment_to_sortListFragment, bundle)
        }

    }


}