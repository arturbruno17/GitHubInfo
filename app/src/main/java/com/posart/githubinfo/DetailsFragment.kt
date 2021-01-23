package com.posart.githubinfo

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.posart.githubinfo.databinding.DetailsFragmentBinding

class DetailsFragment : Fragment() {

    private lateinit var viewModel: DetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding =  DetailsFragmentBinding.inflate(inflater)
        viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)

        val arguments = DetailsFragmentArgs.fromBundle(requireArguments())

        return binding.root
    }

}