package ar.edu.unlam.demokt.post.infrastructure.storage.repository

import ar.edu.unlam.demokt.post.domain.model.Post
import ar.edu.unlam.demokt.post.domain.repository.PostRepository
import ar.edu.unlam.demokt.post.infrastructure.storage.entity.AsDomain
import ar.edu.unlam.demokt.post.infrastructure.storage.entity.ToEntity
import org.springframework.stereotype.Repository

@Repository
class PostDefaultRepository(private val storageCrudRepo: PostCrudRepository) : PostRepository {
    override fun GetByID(id: Int): Post {
        return this.storageCrudRepo.findById(id.toLong()).get().AsDomain()
    }

    override fun Create(post: Post) {
        this.storageCrudRepo.save(post.ToEntity())
    }
}
