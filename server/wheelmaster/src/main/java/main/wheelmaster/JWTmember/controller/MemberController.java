package main.wheelmaster.JWTmember.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import main.wheelmaster.JWTmember.dto.MemberRequestDto;
import main.wheelmaster.JWTmember.entity.Member;
import main.wheelmaster.JWTmember.mapper.MemberMapper;
import main.wheelmaster.JWTmember.service.MemberService;
import main.wheelmaster.response.MessageResponseDto;
import main.wheelmaster.response.SingleResponseWithMessageDto;
import main.wheelmaster.token.dto.TokenResponseDto;
import main.wheelmaster.token.entity.Token;
import main.wheelmaster.token.mapper.TokenMapper;
import main.wheelmaster.token.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Validated
@Slf4j
@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final AuthService authService;
    private final MemberMapper mapper;
    private final TokenMapper tokenMapper;

    //회원가입
    @PostMapping("/signup")
    public ResponseEntity singUp(@RequestBody @Valid MemberRequestDto.singUpDto singUpDto){
        Member member = mapper.signUpDtoToMember(singUpDto);
        memberService.createMember(member);
        MessageResponseDto message = MessageResponseDto.builder()
                .message("WELCOME")
                .build();
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

//    //로그인
//    @PostMapping("/login")
//    public ResponseEntity login(@RequestBody @Valid MemberRequestDto.loginDto loginDto) {
////        Token token = authService.login(mapper.loginDtoToMember(loginDto));
//        TokenResponseDto.Token response = authService.login(mapper.loginDtoToMember(loginDto));
//        return new ResponseEntity<>(new SingleResponseWithMessageDto<>(response,
//                "SUCCESS"),
//                HttpStatus.OK);
//    }
    //로그인
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid MemberRequestDto.loginDto loginDto) {
        Token token = authService.login(mapper.loginDtoToMember(loginDto));
//        TokenResponseDto.Token response = authService.login(mapper.loginDtoToMember(loginDto));

        return new ResponseEntity<>(new SingleResponseWithMessageDto<>(tokenMapper.tokenInfo(token),
                "SUCCESS"),
                HttpStatus.OK);
    }

    //TODO 토큰 재발급시 유효한 토큰인지 인증
//    @PostMapping("/reissue")
//    public ResponseEntity reIssue(@RequestBody @Valid TokenRequestDto.ReIssue reIssue) {
//        TokenResponseDto.ReIssueToken response =  authService.reIssue(reIssue);
//        return new ResponseEntity<>(new SingleResponseWithMessageDto<>(response,
//                "SUCCESS"),
//                HttpStatus.OK);
//    }
}
