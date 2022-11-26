package ru.netology.nmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.dto.Post

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val post = Post(
            1,
            "Нетология. Университет интернет-профессий",
            "24 ноября в 19:21",
            "Привет, это новая Нетология! Когда-то Нетология\n" +
                    "        начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке,\n" +
                    "        аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных\n" +
                    "        профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила,\n" +
                    "        которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия —\n" +
                    "        помочь встать на путь роста и начать цепочку перемен — http://netolo.gy.gy/fyb",
            false,
            1099,
            99999999
        )

        with(binding) {
            author.text = post.author
            date.text = post.published
            postBody.text = post.content
            likesCount.text = CountConverter().convert(post.likes)
            shareCount.text = CountConverter().convert(post.shares)
            if (post.likedByMe) {
                binding.likeButton.setImageResource(R.drawable.ic_liked)
            }
            likeButton.setOnClickListener {
                if (post.likedByMe) post.likes-- else post.likes++
                post.likedByMe = !post.likedByMe
                likeButton.setImageResource(if (post.likedByMe) R.drawable.ic_liked else R.drawable.ic_likes)
                likesCount.text = CountConverter().convert(post.likes)
            }
            shareButton.setOnClickListener {
                shareButton.setImageResource(R.drawable.ic_shared)
                post.shares++
                shareCount.text = CountConverter().convert(post.shares)
            }
        }
    }
}
