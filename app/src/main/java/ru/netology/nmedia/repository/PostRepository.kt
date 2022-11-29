package ru.netology.nmedia.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.dto.Post

interface PostRepository {
    fun get(): LiveData<Post>
    fun like()
    fun share()
}
class PostRepositoryInMemoryImpl : PostRepository {
    private var post = Post(
        12,
        "Нетология. Университет интернет-профессий",
        "24 ноября в 19:21",
        "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен — http://netolo.gy.gy/fyb",
        false,
        999,
        998,
        false
    )
    private val data = MutableLiveData(post)

    override fun get(): LiveData<Post> = data

    override fun like() {
      if (post.likedByMe) post.likes -- else post.likes ++
            post = post.copy(likedByMe = !post.likedByMe)
        data.value = post
    }
    override fun share(){
        post.shares ++
        post.shareByMe = true
        data.value = post
    }
}

