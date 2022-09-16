package main.wheelmaster.JWTmember.mapper;

import javax.annotation.processing.Generated;
import main.wheelmaster.JWTmember.dto.MemberRequestDto;
import main.wheelmaster.JWTmember.dto.MemberResponseDto;
import main.wheelmaster.JWTmember.entity.Member;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-15T19:59:58+0900",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.13 (Oracle Corporation)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public Member signUpDtoToMember(MemberRequestDto.singUpDto singUpDto) {
        if ( singUpDto == null ) {
            return null;
        }

        Member member = new Member();

        member.setEmail( singUpDto.getEmail() );
        member.setPassword( singUpDto.getPassword() );
        member.setNickName( singUpDto.getNickName() );
        member.setTel( singUpDto.getTel() );

        return member;
    }

    @Override
    public Member loginDtoToMember(MemberRequestDto.loginDto loginDto) {
        if ( loginDto == null ) {
            return null;
        }

        Member member = new Member();

        member.setEmail( loginDto.getEmail() );
        member.setPassword( loginDto.getPassword() );

        return member;
    }

    @Override
    public MemberResponseDto.MemberInfo memberToMemberInfo(Member member) {
        if ( member == null ) {
            return null;
        }

        MemberResponseDto.MemberInfo.MemberInfoBuilder memberInfo = MemberResponseDto.MemberInfo.builder();

        memberInfo.email( member.getEmail() );
        memberInfo.nickName( member.getNickName() );
        memberInfo.tel( member.getTel() );

        return memberInfo.build();
    }

    @Override
    public Member updateDtoToMember(MemberRequestDto.updateDto updateDto) {
        if ( updateDto == null ) {
            return null;
        }

        Member member = new Member();

        member.setMemberId( updateDto.getMemberId() );
        member.setPassword( updateDto.getPassword() );
        member.setNickName( updateDto.getNickName() );
        member.setTel( updateDto.getTel() );

        return member;
    }

    @Override
    public MemberResponseDto.UpdateDto memberToUpdateDto(Member member) {
        if ( member == null ) {
            return null;
        }

        MemberResponseDto.UpdateDto.UpdateDtoBuilder updateDto = MemberResponseDto.UpdateDto.builder();

        updateDto.nickName( member.getNickName() );
        updateDto.tel( member.getTel() );
        updateDto.memberId( member.getMemberId() );

        return updateDto.build();
    }
}