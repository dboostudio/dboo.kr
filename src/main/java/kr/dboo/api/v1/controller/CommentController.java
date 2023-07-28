package kr.dboo.api.v1.controller;

import jakarta.validation.Valid;
import kr.dboo.api.v1.entity.Comment;
import kr.dboo.api.v1.payload.SaveCommentRequest;
import kr.dboo.api.v1.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comment")
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
    public ResponseEntity saveComment(
            @RequestBody @Valid SaveCommentRequest saveCommentRequest
    ){
        commentService.saveComment(saveCommentRequest);
        return ResponseEntity.ok().build();
    }
}
