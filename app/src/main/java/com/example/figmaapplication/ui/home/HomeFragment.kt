package com.example.figmaapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.figmaapplication.R
import com.example.figmaapplication.databinding.FragmentHomeBinding
import com.example.figmaapplication.recadapters.FeelRecycler
import com.example.figmaapplication.recadapters.MyFeel
import com.example.figmaapplication.recadapters.MyState1
import com.example.figmaapplication.recadapters.StateRecycler

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val root= inflater.inflate(R.layout.fragment_home, container, false)
        val feel_recycler : RecyclerView = root.findViewById(R.id.feel_rec)
        feel_recycler.adapter = FeelRecycler(requireContext(),MyFeel().list)
        val state_recycler : RecyclerView = root.findViewById(R.id.state_rec)
        state_recycler.adapter=StateRecycler(requireContext(),MyState1().states_list)

        return root

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}