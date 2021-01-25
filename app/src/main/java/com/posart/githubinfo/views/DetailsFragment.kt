package com.posart.githubinfo.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.posart.githubinfo.R
import com.posart.githubinfo.databinding.DetailsFragmentBinding
import com.posart.githubinfo.viewmodels.DetailsViewModel

class DetailsFragment : Fragment() {

    private lateinit var viewModel: DetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DetailsFragmentBinding.inflate(inflater)

        val arguments =
            DetailsFragmentArgs.fromBundle(
                requireArguments()
            )

        val factory = DetailsViewModel.Factory(arguments.username)
        viewModel = ViewModelProvider(this, factory).get(DetailsViewModel::class.java)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        viewModel.user.observe(viewLifecycleOwner, Observer {
            binding.followersAndFollowing.text = getString(
                R.string.followers_and_following,
                it.followers, it.following
            )
        })

        return binding.root
    }

}