package kr.dboo.api;

import kr.dboo.api.v1.entity.Comment;
import kr.dboo.api.v1.entity.Post;
import kr.dboo.api.v1.repository.CommentRepository;
import kr.dboo.api.v1.repository.PostRepository;
import kr.dboo.api.v1.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InitRunner implements ApplicationRunner {

    private final PostRepository postRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        postRepository.saveAll(
                List.of(
                        Post.builder()
                                .title("title1")
                                .content("content1").build(),
                        Post.builder()
                                .title("title2")
                                .content("content2").build()

                )
        );
    }
}
