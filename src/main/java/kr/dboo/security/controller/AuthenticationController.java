package kr.dboo.security.controller;

import kr.dboo.security.payload.SignUp;
import kr.dboo.security.payload.SignIn;
import kr.dboo.security.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @PostMapping("/sign-up")
    public ResponseEntity signup(@RequestBody SignUp request) {
        authenticationService.signUp(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/sign-in")
    public ResponseEntity singIn(@RequestBody SignIn request) {
        return ResponseEntity.ok().body(authenticationService.signIn(request));
    }
}
