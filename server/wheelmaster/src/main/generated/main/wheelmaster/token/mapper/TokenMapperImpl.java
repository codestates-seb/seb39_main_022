package main.wheelmaster.token.mapper;

import javax.annotation.processing.Generated;
import main.wheelmaster.token.dto.TokenResponseDto;
import main.wheelmaster.token.entity.Token;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-15T19:59:59+0900",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.13 (Oracle Corporation)"
)
@Component
public class TokenMapperImpl implements TokenMapper {

    @Override
    public TokenResponseDto.Token tokenInfo(Token token) {
        if ( token == null ) {
            return null;
        }

        TokenResponseDto.Token.TokenBuilder token1 = TokenResponseDto.Token.builder();

        token1.grantType( token.getGrantType() );
        token1.accessToken( token.getAccessToken() );
        token1.refreshToken( token.getRefreshToken() );
        token1.accessTokenExpiredTime( token.getAccessTokenExpiredTime() );
        token1.refreshTokenExpiredTime( token.getRefreshTokenExpiredTime() );

        return token1.build();
    }
}
