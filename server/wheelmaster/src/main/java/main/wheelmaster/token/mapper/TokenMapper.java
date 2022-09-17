package main.wheelmaster.token.mapper;

import main.wheelmaster.token.dto.TokenResponseDto;
import main.wheelmaster.token.entity.Token;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TokenMapper {
    TokenResponseDto.Token tokenInfo(Token token);
}