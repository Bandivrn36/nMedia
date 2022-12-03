package ru.netology.nmedia.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelLazy
import ru.netology.nmedia.repository.PostRepository
import ru.netology.nmedia.repository.PostRepositoryInMemoryImpl

class PostViewModel : ViewModel() {
    private val repository: PostRepository = PostRepositoryInMemoryImpl()
    val data = repository.getAll()
    fun likeById(id: Long) = repository.likeById(id)
    fun share(id: Long) = repository.share(id)

}
