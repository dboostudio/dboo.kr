package kr.dboo.api.service;

import kr.dboo.api.entity.Comment;
import kr.dboo.api.payload.CommentRequest;
import kr.dboo.api.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public Page<Comment> getComments(Pageable pageable) {
        return commentRepository.findAll(pageable);
    }

    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }

    @Transactional
    public void createComment(CommentRequest saveCommentRequest) {
        Comment comment = Comment.builder()
                .name(saveCommentRequest.getName())
                .comment(saveCommentRequest.getComment())
                .build();
        commentRepository.save(comment);
    }
}
