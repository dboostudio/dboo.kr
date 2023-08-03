package kr.dboo.api;

import kr.dboo.api.entity.Post;
import kr.dboo.api.repository.PostRepository;
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
                                .content("# 제목\n\n" +
                                        "- 리스트리스트리스트리스트리스트리스트리스트리스트리스트리스트리스트리스트리스트리스트리스트리스트리스트리스트리스트리스트리스트리스트리스트리스트리스트리스트리스트리스트리스트리스트리스트리스트리스트리스트\n\n" +
                                        "- 리스트\n\n" +
                                        "- 리스트\n\n" +
                                        "- 리스트4\n\n" +
                                        "- 리스트\n\n" +
                                        "- 이쯤되면 안나와야하나\n\n" +
                                        "아니면 이쯤되면\n\n" +
                                        "아ㅣ니면\n\n" +
                                        "이쯤?\n\n" +
                                        "흐음\n\n" +
                                        "content1\n\n").build(),
                        Post.builder()
                                .title("title2")
                                .content("content2").build()

                )
        );
    }
}
