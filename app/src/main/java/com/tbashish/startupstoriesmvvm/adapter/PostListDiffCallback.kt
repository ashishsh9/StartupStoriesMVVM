package com.tbashish.startupstoriesmvvm.adapter

import androidx.recyclerview.widget.DiffUtil

class PostListDiffCallback : DiffUtil.ItemCallback<Any>() {

    override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
        return false
    }

    override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
        return false
    }
}