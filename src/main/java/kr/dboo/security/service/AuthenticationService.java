package kr.dboo.security.service;


import kr.dboo.security.payload.SignUp;
import kr.dboo.security.payload.SignIn;

public interface AuthenticationService {
    /**
     * 회원가입 서비스
     * @param request
     * @return JWT Token을 리턴한다.
     */
    String signUp(SignUp request);

    String signIn(SignIn request);
}
