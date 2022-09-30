package main.wheelmaster.favoritePlace.controller;

import io.swagger.annotations.ApiOperation;
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


@RestController
@RequiredArgsConstructor
public class FavoritePlaceController {
    private final FavoritePlaceService service;

    @ApiOperation(value = "즐겨찾기")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("wheel-center/{wheelCenterId}/favorite-places")
    public FavoritePlaceResponseDto createFavoritePlace(@Login Member member,
                                                        @PathVariable  Long wheelCenterId,
                                                        @RequestBody @Validated FavoritePlacePostDto dto) {

        return service.createFavoritePlace(
                FavoritePlacePostDto.of(dto.getFacultyName(), member, dto.getLongitude(), dto.getLatitude(), wheelCenterId));
    }

    @ApiOperation(value = "즐겨찾기 취소")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/favorite-places/{favoritePlaceId}")
    public void deleteFavoritePlace(@Login Member member,
                                    @PathVariable Long favoritePlaceId)
    {
        service.deleteFavoritePlace(favoritePlaceId);
    }

    @ApiOperation(value = "개인 즐겨찾기 조회")
    @GetMapping("/favorite-places")
    public List<FavoritePlaceResponseDto> getFavoritePlaces(@Login Long memberId)
    {
        return service.getFavoritePlaces(memberId);
    }

}