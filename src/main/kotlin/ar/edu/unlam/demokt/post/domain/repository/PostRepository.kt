package ar.edu.unlam.demokt.post.domain.repository

import ar.edu.unlam.demokt.post.domain.model.Post

interface PostRepository {
    fun GetByID(id: Int): Post
    fun Create(post: Post)
}