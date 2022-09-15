package main.wheelmaster.token.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Token {

    @Id
    private long tokenId;
    private String grantType;
    private String accessToken;
    private String refreshToken;
    private Long accessTokenExpiredTime;
    private Long refreshTokenExpiredTime;
}
