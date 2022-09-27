package main.wheelmaster.member.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import main.wheelmaster.exception.BusinessLogicException;
import main.wheelmaster.exception.ExceptionCode;
import main.wheelmaster.global.argumentresolver.Login;
import main.wheelmaster.member.dto.MemberRequestDto;
import main.wheelmaster.member.dto.MemberResponseDto;
import main.wheelmaster.member.entity.Member;
import main.wheelmaster.member.mapper.MemberMapper;
import main.wheelmaster.member.service.MemberService;
import main.wheelmaster.response.MessageResponseDto;
import main.wheelmaster.response.SingleResponseWithMessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.Positive;

import static main.wheelmaster.member.SessionConst.LOGIN_MEMBER;


@Validated
@Slf4j
@RestController
@RequestMapping("/members")
@RequiredArgsConstructor

public class MemberController {

    private final MemberService memberService;
    private final MemberMapper mapper;

    //회원가입
    @ApiOperation(value = "회원가입")
    @PostMapping("/signup")
    public ResponseEntity singUp(@RequestBody @Valid MemberRequestDto.singUpDto singUpDto){
        Member member = memberService.createMember(mapper.signUpDtoToMember(singUpDto));
        System.out.println("member = " + member);

        MessageResponseDto message = MessageResponseDto.builder()
                .message("WELCOME")
                .build();

        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    //로그인
    @ApiOperation(value = "로그인")
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid MemberRequestDto.loginDto loginDto, HttpServletRequest request, HttpServletResponse response){
        Member member = mapper.loginDtoToMember(loginDto);
        Member loginMember = memberService.login(member);
        HttpSession session = request.getSession(true);
        session.setAttribute(LOGIN_MEMBER, loginMember);
        log.info("login member = {}", request.getSession(false).getAttribute(LOGIN_MEMBER));
        return new ResponseEntity<>(new SingleResponseWithMessageDto<>(mapper.memberToMemberInfo(loginMember),"SUCCESS"),HttpStatus.OK);
    }


    //회원정보 수정
    @ApiOperation(value = "회원정보 수정")
    @PatchMapping
    public ResponseEntity updateMember(@RequestBody MemberRequestDto.updateDto updateDto,
                                       @Login Member loginMember)
    {
        log.info("loginMember = {}", loginMember);
        if(loginMember == null) return null;

        updateDto.setMemberId(loginMember.getMemberId());
        Member member = memberService.updateMember(mapper.updateDtoToMember(updateDto));
        MemberResponseDto.UpdateDto memberInfo = mapper.memberToUpdateDto(member);

        return new ResponseEntity<>(new SingleResponseWithMessageDto(memberInfo, "SUCCESS"), HttpStatus.OK);
    }

    //회원정보 삭제
    @ApiOperation(value = "회원정보 삭제")
    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@Positive @PathVariable("member-id") long memberId){
        memberService.deleteMember(memberId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //로그아웃
    @ApiOperation(value = "로그아웃")
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
}