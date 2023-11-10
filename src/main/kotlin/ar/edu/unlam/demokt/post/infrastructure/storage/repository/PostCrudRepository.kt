package ar.edu.unlam.demokt.post.infrastructure.storage.repository

import ar.edu.unlam.demokt.post.infrastructure.storage.entity.PostEntity
import org.springframework.data.repository.CrudRepository

interface PostCrudRepository : CrudRepository<PostEntity, Long>