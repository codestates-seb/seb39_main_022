package main.wheelmaster.token.service;

import lombok.RequiredArgsConstructor;
import main.wheelmaster.exception.BusinessLogicException;
import main.wheelmaster.exception.ExceptionCode;
import main.wheelmaster.JWTmember.entity.Member;
import main.wheelmaster.JWTmember.repository.MemberRepository;
import main.wheelmaster.token.entity.Token;
import main.wheelmaster.token.provider.JwtTokenProviderLocal;
import main.wheelmaster.token.repository.TokenRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthService {
  private final MemberRepository memberRepository;
  private final TokenRepository tokenRepository;
  private final JwtTokenProviderLocal jwtTokenProvider;


//  public TokenResponseDto.Token login(Member member) {
//    Member findMember = findVerifiedMemberByEmail(member.getEmail());
////    Token token = jwtTokenProvider.createTokenDto(findMember);
//    TokenResponseDto.Token token = jwtTokenProvider.createTokenDto(findMember);
//    return token;
//  }
  public Token login(Member member) {
    Member findMember = findVerifiedMemberByEmail(member.getEmail());
    Token token = jwtTokenProvider.createTokenDto(findMember);
//    TokenResponseDto.Token token = jwtTokenProvider.createTokenDto(findMember);
    return tokenRepository.save(token);
  }

  @Transactional(readOnly = true)
  public Member findVerifiedMemberByEmail(String email) {
    Optional<Member> optionalMember = memberRepository.findByEmail(email);
    return optionalMember.orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
  }

//  public TokenResponseDto.ReIssueToken reIssue(TokenRequestDto.ReIssue reIssue) {
//    Member findMember = findVerifiedMemberByEmail()
//    Token findToken = findVerifiedToken(reIssue.getRefreshToken());
//    if(reIssue.getRefreshToken().equals(tokenRepository.findByRefreshToken(reIssue.getRefreshToken()))){
//      return jwtTokenProvider.createReIssueTokenDto()
//    }
//    return null;
//  }
//
//  @Transactional(readOnly = true)
//  public Token findVerifiedToken(String refreshToken){
//    Optional<Token> optionalToken = tokenRepository.findByRefreshToken(refreshToken);
//    return optionalToken.orElseThrow(()->new BusinessLogicException(ExceptionCode.TOKEN_IS_INVALID));
//  }
}
