package com.posart.githubinfo.views.details

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.posart.githubinfo.R
import com.posart.githubinfo.databinding.DetailsFragmentBinding
import com.posart.githubinfo.network.RepoNetwork
import com.posart.githubinfo.viewmodels.DetailsViewModel

class DetailsFragment : Fragment() {

    private lateinit var viewModel: DetailsViewModel

    private fun adapterOnClick(repository: RepoNetwork) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(repository.html_url)
        startActivity(intent)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DetailsFragmentBinding.inflate(inflater)

        val arguments =
            DetailsFragmentArgs.fromBundle(
                requireArguments()
            )

        viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        viewModel.getUserAndRepos(arguments.username)

        viewModel.user.observe(viewLifecycleOwner, Observer {
            it?.let {
                binding.followersAndFollowing.text = getString(
                    R.string.followers_and_following,
                    it.followers, it.following
                )
            }
        })

        viewModel.reposUser.observe(viewLifecycleOwner, Observer {
            it?.let {
                binding.recyclerViewList.adapter = ReposAdapter(it) { repository ->
                    adapterOnClick(repository)
                }
            }
        })

        return binding.root
    }
}

