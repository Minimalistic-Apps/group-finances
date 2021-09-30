package com.minimalisticapps.groupfinances.ui.groups

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.minimalisticapps.groupfinances.databinding.FragmentGroupsBinding

class GroupsFragment : Fragment() {

    private lateinit var groupsViewModel: GroupsViewModel
    private var _binding: FragmentGroupsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

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

        return root
    }

    private fun initRecyclerView() {
        groupsRecyclerAdapter = GroupsRecyclerAdapter(
            arrayOf(
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
        )
        val recyclerView = binding.groupsRecyclerView
        val topSpacingItemDecoration = TopSpacingItemDecoration(30)
        recyclerView.addItemDecoration(topSpacingItemDecoration)
        linearLayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = groupsRecyclerAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}