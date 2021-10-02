package com.tbashish.startupstoriesmvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tbashish.startupstoriesmvvm.R
import com.tbashish.startupstoriesmvvm.model.Post
import com.tbashish.startupstoriesmvvm.databinding.PostcardBinding
import org.jsoup.Jsoup


class PostListViewHolder(val binding: PostcardBinding) : RecyclerView.ViewHolder(binding.root) {

    companion object{
        fun create(inflater: LayoutInflater,
                   viewGroup: ViewGroup
        ) : PostListViewHolder {
            val binding = DataBindingUtil.inflate<PostcardBinding>(inflater, R.layout.postcard , viewGroup ,false)
            return PostListViewHolder(binding)
        }
    }
    private val photo: ImageView = binding.postImage

    fun bind(post: Post) {
        print("Bind")


        val postTitle = post.title
        val postExcerpt = post.excerpt
        val postAuthor = post.author.toString()

        binding.postTitle.text = postTitle["rendered"]
        binding.postContent.text = Jsoup.parse(postExcerpt["rendered"]).text()
        binding.postDate.text = postAuthor
        //Glide.with(photo).load("https://image.tmdb.org/t/p/w500${post.featured_media}").into(photo)

    }

}