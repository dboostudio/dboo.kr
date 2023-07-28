package kr.dboo.api.v1.service;

import kr.dboo.api.v1.entity.Comment;
import kr.dboo.api.v1.payload.SaveCommentRequest;
import kr.dboo.api.v1.repository.CommentRepository;
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
    public void saveComment(SaveCommentRequest saveCommentRequest) {
        Comment comment = Comment.builder()
                .name(saveCommentRequest.getName())
                .comment(saveCommentRequest.getComment())
                .build();
        commentRepository.save(comment);
    }
}
