package ru.netology.nmedia.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import ru.netology.nmedia.CountConverter
import ru.netology.nmedia.R
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.presentation.PostViewModel


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: PostViewModel by viewModels()
        viewModel.data.observe(this) { post ->
            with(binding) {
                author.text = post.author
                date.text = post.published
                postBody.text = post.content
                likesCount.text = CountConverter().convert(post.likes)
                shareCount.text = CountConverter().convert(post.shares)
                likeButton.setImageResource(
                    if (post.likedByMe) R.drawable.ic_liked else R.drawable.ic_likes
                )
                shareButton.setImageResource(
                    if(post.shareByMe) R.drawable.ic_shared else R.drawable.ic_share
                )
            }

        }
        binding.likeButton.setOnClickListener {
            viewModel.like()
        }
        binding.shareButton.setOnClickListener{
            viewModel.share()

        }


    }
}
