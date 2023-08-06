package kr.dboo;

import kr.dboo.api.entity.Post;
import kr.dboo.api.entity.Role;
import kr.dboo.api.entity.User;
import kr.dboo.api.repository.CommentRepository;
import kr.dboo.api.repository.PostRepository;
import kr.dboo.security.repository.UserRepository;
import kr.dboo.security.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InitRunner implements ApplicationRunner {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Value("${dboo.admin.password}")
    private String password;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        commentRepository.deleteAll();
        postRepository.deleteAll();

        String email = "dboo.studio@gmail.com";
        if(!userRepository.findByEmail(email).isPresent()) {
            var user = User.builder()
                    .firstName("대환")
                    .lastName("부")
                    .email(email)
                    .password(passwordEncoder.encode(password))
                    .role(Role.ADMIN).build();
            userRepository.save(user);
        }

        postRepository.saveAll(List.of(
           Post.builder()
                   .title("테스트 제목1")
                   .content("테스트 컨텐트 입니다." +
                           "\n" +
                           "# This is H1" +
                           "\n" +
                           "## This is H2" +
                           "\n" +
                           "- list 1" +
                           "\n" +
                           "- list 2" +
                           "\n" +
                           "- list 3" +
                           "\n" +
                           "~~~java\n" +
                           "if( true )\n" +
                           "    System.out.println('Hello')\n" +
                           "\n" +
                           "~~~" )
                   .build(),
           Post.builder()
                   .title("테트스 타이틀2")
                   .content("테스트 컨텐츠").build()
        ));

    }
}
