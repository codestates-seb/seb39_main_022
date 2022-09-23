package main.wheelmaster.member.mapper;

import javax.annotation.processing.Generated;
import main.wheelmaster.member.dto.MemberRequestDto;
import main.wheelmaster.member.dto.MemberResponseDto;
import main.wheelmaster.member.entity.Member;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-23T16:10:53+0900",
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
        member.setPhoneNumber( singUpDto.getPhoneNumber() );

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
        member.setPhoneNumber( updateDto.getPhoneNumber() );

        return member;
    }

    @Override
    public MemberResponseDto.UpdateDto memberToUpdateDto(Member member) {
        if ( member == null ) {
            return null;
        }

        MemberResponseDto.UpdateDto.UpdateDtoBuilder updateDto = MemberResponseDto.UpdateDto.builder();

        updateDto.nickName( member.getNickName() );
        updateDto.phoneNumber( member.getPhoneNumber() );

        return updateDto.build();
    }
}
