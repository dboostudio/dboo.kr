package kr.dboo.api.controller;

import jakarta.validation.Valid;
import kr.dboo.api.payload.SavePostRequest;
import kr.dboo.api.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/post")
public class PostController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity getPostList(){
        return ResponseEntity.ok(postService.getAllPostList());
    }



    @PostMapping
    public ResponseEntity savePost(
            @RequestBody @Valid SavePostRequest savePostRequest
    ){
        postService.savePost(savePostRequest);
        return ResponseEntity.ok().build();
    }
}
