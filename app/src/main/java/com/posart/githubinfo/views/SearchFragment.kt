package com.posart.githubinfo.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.posart.githubinfo.databinding.SearchFragmentBinding
import com.posart.githubinfo.search.SearchFragmentDirections

class SearchFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = SearchFragmentBinding.inflate(inflater)
        binding.buttonSearch.setOnClickListener {
            val username = binding.inputUsername.text.toString()
            findNavController().navigate(
                SearchFragmentDirections.actionSearchFragmentToDetailsFragment(
                    username
                )
            )
        }
        return binding.root
    }
}