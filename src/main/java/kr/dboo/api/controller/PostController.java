package kr.dboo.api.controller;

import jakarta.validation.Valid;
import kr.dboo.api.payload.CreatePostRequest;
import kr.dboo.api.payload.SavePostRequest;
import kr.dboo.api.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity getPostList(){
        return ResponseEntity.ok(postService.getAllPostList());
    }

    @GetMapping("/{id}")
    public ResponseEntity getPost(
            @PathVariable Long id
    ){
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @PostMapping
    @Secured("ADMIN")
    public ResponseEntity createPost(
            @RequestBody @Valid CreatePostRequest createPostRequest
    ){
        postService.createPost(createPostRequest);
        return ResponseEntity.ok().build();
    }

    @PatchMapping
    @Secured("ADMIN")
    public ResponseEntity savePost(
            @RequestBody @Valid SavePostRequest savePostRequest
    ){
        postService.savePost(savePostRequest);
        return ResponseEntity.ok().build();
    }

    @Secured("ADMIN")
    @DeleteMapping("/{id}")
    public ResponseEntity deletePost(
            @PathVariable Long id
    ){
        postService.deletePost(id);
        return ResponseEntity.ok().build();
    }
}
