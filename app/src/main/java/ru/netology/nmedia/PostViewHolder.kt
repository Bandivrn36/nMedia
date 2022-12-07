package ru.netology.nmedia

import androidx.recyclerview.widget.RecyclerView
import ru.netology.nmedia.databinding.PostLayoutBinding
import ru.netology.nmedia.dto.Post

class PostViewHolder(
    private val binding: PostLayoutBinding,
    private val onLikeListener: OnLikeListener,
    private val onShareListener: OnShareListener
): RecyclerView.ViewHolder(binding.root) {
    fun bind(post: Post) {
        binding.apply {
            author.text = post.author
            date.text = post.published
            postBody.text = post.content
            shareCount.text = post.shares.toString()
            likeButton.setImageResource(
                if (post.likedByMe) R.drawable.ic_liked else R.drawable.ic_likes

            )
            likeButton.setOnClickListener() {

                onLikeListener(post)


            }
            likesCount.text = CountConverter().convert(post.likes)


            shareButton.setImageResource(
                if (post.shareByMe) R.drawable.ic_shared else R.drawable.ic_share
            )
            shareButton.setOnClickListener() {

                onShareListener(post)
            }
            shareCount.text = CountConverter().convert(post.shares)
        }
    }

}



