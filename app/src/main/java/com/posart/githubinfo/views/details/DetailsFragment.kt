package com.posart.githubinfo.views.details

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.posart.githubinfo.R
import com.posart.githubinfo.databinding.DetailsFragmentBinding
import com.posart.githubinfo.network.RepoNetwork
import com.posart.githubinfo.utils.updateScreen
import com.posart.githubinfo.viewmodels.DetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private val viewModel: DetailsViewModel by viewModels()

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

        val listViews = listOf(
            binding.userPhoto,
            binding.username,
            binding.bio,
            binding.personLogo,
            binding.locationLogo,
            binding.followersAndFollowing,
            binding.location,
            binding.repositoriesText,
            binding.recyclerViewList,
            binding.progressBar
        )

        viewModel.status.observe(viewLifecycleOwner, Observer {
            binding.root.updateScreen(listViews, it)
        })

        return binding.root
    }
}

