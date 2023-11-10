package ar.edu.unlam.demokt.post.domain.service

import ar.edu.unlam.demokt.post.domain.model.Post
import ar.edu.unlam.demokt.post.domain.repository.PostRepository
import org.springframework.stereotype.Service

@Service
class PostCRUDService(private val postRepo: PostRepository) : GetPostUseCase, CreatePostUseCase {
    override fun Get(id: Int): Post {
        return this.postRepo.GetByID(id)
    }

    override fun Create(post: Post) {
        return this.postRepo.Create(post)
    }
}
