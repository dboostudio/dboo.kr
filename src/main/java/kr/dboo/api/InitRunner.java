package kr.dboo.api;

import kr.dboo.api.v1.entity.Comment;
import kr.dboo.api.v1.repository.CommentRepository;
import kr.dboo.api.v1.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InitRunner implements ApplicationRunner {
    private final CommentRepository commentRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        commentRepository.deleteAll();
    }
}
