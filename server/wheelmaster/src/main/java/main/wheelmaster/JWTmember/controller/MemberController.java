package main.wheelmaster.JWTmember.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import main.wheelmaster.JWTmember.dto.MemberRequestDto;
import main.wheelmaster.JWTmember.dto.MemberResponseDto;
import main.wheelmaster.JWTmember.entity.Member;
import main.wheelmaster.JWTmember.mapper.MemberMapper;
import main.wheelmaster.JWTmember.service.MemberService;
import main.wheelmaster.exception.BusinessLogicException;
import main.wheelmaster.exception.ExceptionCode;
import main.wheelmaster.response.MessageResponseDto;
import main.wheelmaster.response.SingleResponseWithMessageDto;
import main.wheelmaster.token.dto.TokenRequestDto;
import main.wheelmaster.token.dto.TokenResponseDto;
import main.wheelmaster.token.entity.Token;
import main.wheelmaster.token.mapper.TokenMapper;
import main.wheelmaster.token.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.Positive;

import static main.wheelmaster.auth.SessionConst.LOGIN_MEMBER;

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

    //로그인
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid MemberRequestDto.loginDto loginDto) {
        Token token = authService.login(mapper.loginDtoToMember(loginDto));
        return new ResponseEntity<>(new SingleResponseWithMessageDto<>(tokenMapper.tokenInfo(token),
                "SUCCESS"),
                HttpStatus.OK);
    }

    //회원 정보 수정
    @PatchMapping
    public ResponseEntity updateMember(@RequestBody MemberRequestDto.updateDto updateDto,
                                       @SessionAttribute(name= LOGIN_MEMBER) Member loginMember)
    {
        updateDto.setMemberId(loginMember.getMemberId());
        Member member = memberService.updateMember(mapper.updateDtoToMember(updateDto));
        MemberResponseDto.UpdateDto memberInfo = mapper.memberToUpdateDto(member);

        return new ResponseEntity<>(new SingleResponseWithMessageDto(memberInfo, "SUCCESS"), HttpStatus.OK);
    }

    //회원정보 삭제
    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@Positive @PathVariable("member-id") long memberId){
        memberService.deleteMember(memberId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //로그아웃
    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null)
        {
            throw new BusinessLogicException(ExceptionCode.CONSTRAINT_VIOLATION_ERROR);
        }
        session.invalidate();
        return "redirect:/";
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
