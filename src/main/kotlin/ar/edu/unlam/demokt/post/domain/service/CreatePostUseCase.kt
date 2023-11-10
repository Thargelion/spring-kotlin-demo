package ar.edu.unlam.demokt.post.domain.service

import ar.edu.unlam.demokt.post.domain.model.Post

interface CreatePostUseCase {
    fun Create(post: Post)
}