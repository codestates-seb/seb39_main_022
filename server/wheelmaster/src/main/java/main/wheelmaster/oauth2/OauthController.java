package main.wheelmaster.oauth2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
public class OauthController {

    private final KakaoService userService;


//    private final OauthService oauthService;
//
//    @GetMapping("/login/oauth/{provider}")
//    public ResponseEntity<LoginResponse> login(@PathVariable String provider, @RequestParam String code) {
//        LoginResponse loginResponse = oauthService.login(provider, code);
//        return ResponseEntity.ok().body(loginResponse);
//    }

    @GetMapping("/kakao")
    public void kakaoLogin(@RequestParam String code){
        System.out.println("code = " + code);
        String access_Token = userService.getKaKaoAccessToken(code);
        userService.createKakaoUser(access_Token);
        System.out.println("access_Token = " + access_Token);

    }

}
