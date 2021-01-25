package com.posart.githubinfo.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.posart.githubinfo.databinding.DetailsFragmentBinding
import com.posart.githubinfo.details.DetailsFragmentArgs

class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding =  DetailsFragmentBinding.inflate(inflater)

        val arguments =
            DetailsFragmentArgs.fromBundle(
                requireArguments()
            )

        return binding.root
    }

}