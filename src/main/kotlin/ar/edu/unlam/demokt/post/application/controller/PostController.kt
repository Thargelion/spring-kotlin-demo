package ar.edu.unlam.demokt.post.application.controller

import ar.edu.unlam.demokt.post.application.dto.PostRequestDTO
import ar.edu.unlam.demokt.post.domain.model.Post
import ar.edu.unlam.demokt.post.domain.service.CreatePostUseCase
import ar.edu.unlam.demokt.post.domain.service.GetPostUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class PostController(
    private val postGetter: GetPostUseCase,
    private val postCreator: CreatePostUseCase
) {

    @PostMapping("/post")
    fun Create(@RequestBody post: PostRequestDTO): ResponseEntity<Any> {
        this.postCreator.Create(
            post = Post(
                body = post.body,
                title = post.title,
            )
        )
        return ResponseEntity(mapOf("message" to "ok"), HttpStatus.ACCEPTED)
    }


    @GetMapping("/post/{postId}")
    fun GetById(@PathVariable postId: Int): ResponseEntity<Post> {
        return ResponseEntity(this.postGetter.Get(postId), HttpStatus.BAD_REQUEST)
    }

}