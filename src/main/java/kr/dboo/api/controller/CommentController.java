package kr.dboo.api.controller;

import jakarta.validation.Valid;
import kr.dboo.api.payload.CommentRequest;
import kr.dboo.api.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comment")
public class CommentController {

    private final CommentService commentService;

    @GetMapping
    public ResponseEntity getComment(
            @RequestParam(defaultValue = "0") Integer page
    ){
//        Pageable pageable = PageRequest.of(page, 10, Sort.by("createdAt"));
//        return ResponseEntity.ok(commentService.getComments(pageable));
        return ResponseEntity.ok(commentService.getAllComments());
    }

    @PostMapping
    public ResponseEntity createComment(
            @RequestBody @Valid CommentRequest commentRequest
    ){
        commentService.createComment(commentRequest);
        return ResponseEntity.ok().build();
    }
}
