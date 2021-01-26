package com.posart.githubinfo.views.details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.posart.githubinfo.databinding.RepositoryBinding
import com.posart.githubinfo.network.RepoNetwork

class ReposAdapter(
    private val data: List<RepoNetwork>,
    private val onClick: (RepoNetwork) -> Unit
) : RecyclerView.Adapter<ReposAdapter.ViewHolder>() {

    class ViewHolder private constructor(
        private val binding: RepositoryBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: RepoNetwork, onClick: (RepoNetwork) -> Unit) {
            binding.repositoryName.text = item.name
            binding.root.setOnClickListener {
                onClick(item)
            }
            binding.repositoryDescription.text = item.description
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RepositoryBinding
                    .inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position], onClick)
    }
}
