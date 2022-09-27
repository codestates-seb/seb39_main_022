package main.wheelmaster.favoritePlace.controller;

import lombok.RequiredArgsConstructor;
import main.wheelmaster.favoritePlace.dto.request.FavoritePlacePostDto;
import main.wheelmaster.favoritePlace.dto.response.FavoritePlaceResponseDto;
import main.wheelmaster.favoritePlace.service.FavoritePlaceService;
import main.wheelmaster.global.argumentresolver.Login;
import main.wheelmaster.member.entity.Member;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static main.wheelmaster.member.SessionConst.LOGIN_MEMBER;

@RestController
@RequiredArgsConstructor
public class FavoritePlaceController {
    private final FavoritePlaceService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("wheel-center/{wheelCenterId}/favorite-places")
    public FavoritePlaceResponseDto createFavoritePlace(@Login Member member,
                                                        @PathVariable  Long wheelCenterId,
                                                        @RequestBody @Validated FavoritePlacePostDto dto) {

        return service.createFavoritePlace(
                FavoritePlacePostDto.of(dto, member, wheelCenterId));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/favorite-places/{favoritePlaceId}")
    public void deleteFavoritePlace(@Login Member member,
                                    @PathVariable Long favoritePlaceId)
    {
        service.deleteFavoritePlace(favoritePlaceId);
    }

    @GetMapping("/favorite-places")
    public List<FavoritePlaceResponseDto> getFavoritePlaces(@Login Member member)
    {
        return service.getFavoritePlaces(member.getMemberId());
    }

}
