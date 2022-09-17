package main.wheelmaster.token.entity;


import lombok.*;
import main.wheelmaster.JWTmember.entity.Member;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tokenId;

    private String grantType;
    private String accessToken;
    private String refreshToken;
    private Long accessTokenExpiredTime;
    private Long refreshTokenExpiredTime;

    @OneToOne(mappedBy = "token")
    private Member member;
}