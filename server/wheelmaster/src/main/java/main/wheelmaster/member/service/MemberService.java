package main.wheelmaster.member.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import main.wheelmaster.exception.BusinessLogicException;
import main.wheelmaster.exception.ExceptionCode;
import main.wheelmaster.member.dto.MemberRequestDto;
import main.wheelmaster.member.dto.MemberRequestDto.loginDto;
import main.wheelmaster.member.dto.MemberRequestDto.singUpDto;
import main.wheelmaster.member.dto.MemberResponseDto;
import main.wheelmaster.member.entity.Member;
import main.wheelmaster.member.mapper.MemberMapper;
import main.wheelmaster.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static main.wheelmaster.member.dto.MemberResponseDto.*;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final MemberMapper mapper;

    @Transactional(rollbackFor = BusinessLogicException.class)
    public Member createMember(singUpDto dto) {

        verifyEmail(mapper.signUpDtoToMember(dto).getEmail());
        return memberRepository.save(mapper.signUpDtoToMember(dto));
    }

    public Member login(loginDto loginDto){
        return findVerifiedMemberByEmail(mapper.loginDtoToMember(loginDto).getEmail());
    }

    public UpdateDto updateMember(MemberRequestDto.updateDto member) {

        Member findMember = findVerifiedMember(member.getMemberId());

        Optional.ofNullable(member.getNickName()).ifPresent(findMember::setNickName);
        Optional.ofNullable(member.getPassword()).ifPresent(findMember::setPassword);
        Optional.ofNullable(member.getPhoneNumber()).ifPresent(findMember::setPhoneNumber);
        return mapper.memberToUpdateDto(memberRepository.save(findMember));
    }

    public void deleteMember(long memberId) {
        Member member = findVerifiedMember(memberId);
        memberRepository.delete(member);
    }

    public void verifyEmail(String email) {
        memberRepository.findByEmail(email)
                .ifPresent((member) -> new BusinessLogicException(ExceptionCode.MEMBER_ALREADY_EXISTS));
    }

    @Transactional(readOnly = true)
    public Member findVerifiedMemberByEmail(String email) {
        return memberRepository.findByEmail(email)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
    }

    @Transactional(readOnly = true)
    public Member findMember(long memberId) {
        return findVerifiedMember(memberId);
    }

    @Transactional(readOnly = true)
    public Member findVerifiedMember(long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
    }
}