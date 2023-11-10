package ar.edu.unlam.demokt.post.infrastructure.storage.entity

import ar.edu.unlam.demokt.post.domain.model.Post
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "posts")
data class PostEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val title: String,
    val body: String,
)

fun PostEntity.AsDomain() = Post(
    body = body,
    title = title,
    id = id!!.toInt(),
)

fun Post.ToEntity() = PostEntity(
    body = body,
    title = title,
)