package kr.dboo.api;

import kr.dboo.api.entity.Post;
import kr.dboo.api.entity.Role;
import kr.dboo.api.entity.User;
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
    @Value("${dboo.admin.password}")
    private String password;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        var user = User.builder()
                .firstName("대환")
                .lastName("부")
                .email("dboo.studio@gmail.com")
                .password(passwordEncoder.encode(password))
                .role(Role.USER).build();
        userRepository.save(user);

    }
}
