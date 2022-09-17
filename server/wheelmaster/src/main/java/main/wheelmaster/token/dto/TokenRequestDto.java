package main.wheelmaster.token.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.wheelmaster.JWTmember.entity.Member;

public class TokenRequestDto {
  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @Builder
  public static class ReIssue {
    private Member member;
    private String accessToken;
    private String refreshToken;
  }
}