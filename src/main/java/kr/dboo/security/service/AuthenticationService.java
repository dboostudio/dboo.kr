package kr.dboo.security.service;

import kr.dboo.security.payload.SignIn;
import kr.dboo.security.payload.SignUp;

public interface AuthenticationService {
    /**
     * 회원가입 서비스
     * @param request
     * @return JWT Token을 리턴한다.
     */
    void signUp(SignUp request);

    String signIn(SignIn request);
}
