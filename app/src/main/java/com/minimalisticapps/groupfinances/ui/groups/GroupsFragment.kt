package com.minimalisticapps.groupfinances.ui.groups

import android.os.Bundle
import android.service.autofill.UserData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.minimalisticapps.groupfinances.R
import com.minimalisticapps.groupfinances.databinding.FragmentGroupsBinding

class GroupsFragment : Fragment() {

    private lateinit var groupsViewModel: GroupsViewModel
    private var _binding: FragmentGroupsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val groupsData = arrayListOf(
        "Yo",
        "Hi",
        "a",
        "a",
        "a",
        "a",
        "a",
        "a",
        "a",
        "a",
        "a",
        "a",
        "a",
        "a"
    )

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var groupsRecyclerAdapter: GroupsRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        groupsViewModel =
            ViewModelProvider(this).get(GroupsViewModel::class.java)

        _binding = FragmentGroupsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        initRecyclerView()
        val addsBtn = root.findViewById<FloatingActionButton>(R.id.addGroupButton)
        addsBtn.setOnClickListener { v ->
            groupsData.add("+")
            groupsRecyclerAdapter.notifyItemInserted(groupsData.size - 1)
        }

        return root
    }

    private fun initRecyclerView() {
        groupsRecyclerAdapter = GroupsRecyclerAdapter(requireContext(), groupsData)
        val recyclerView = binding.groupsRecyclerView
        linearLayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = groupsRecyclerAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}