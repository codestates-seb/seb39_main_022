package main.wheelmaster.favoritePlace.service;

import lombok.RequiredArgsConstructor;
import main.wheelmaster.exception.BusinessLogicException;
import main.wheelmaster.favoritePlace.dto.request.FavoritePlacePostDto;
import main.wheelmaster.favoritePlace.dto.response.FavoritePlaceResponseDto;
import main.wheelmaster.favoritePlace.entity.FavoritePlace;
import main.wheelmaster.favoritePlace.mapper.FavoritePlaceMapper;
import main.wheelmaster.favoritePlace.repository.FavoritePlaceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static main.wheelmaster.exception.ExceptionCode.*;

@Service
@RequiredArgsConstructor
public class FavoritePlaceService {

    private final FavoritePlaceRepository repository;
    private final FavoritePlaceMapper mapper;

    /**
     * 미등록된 favoritePlace 저장
     * @param favoritePlacePostDto 즐겨찾기 post 요청 객체 <br>
     * 즐겨찾기 등록을 위한 post 요청 객체
     */
    @Transactional(rollbackFor = BusinessLogicException.class)
    public FavoritePlaceResponseDto createFavoritePlace(FavoritePlacePostDto favoritePlacePostDto){

        FavoritePlace favoritePlace = mapper.FavoritePlacePostDtoToFavoritePlace(favoritePlacePostDto);

        verifyDuplicate(favoritePlace);

        return mapper.FavoriteToFavoritePlaceResponseDto(repository.save(favoritePlace));
    }


    /**
     * 중복 데이터 확인 참조
     * @param favoritePlace 즐겨찾기 엔티티 <br>
     * 중복검증의 대상
     */
    public void verifyDuplicate(FavoritePlace favoritePlace) {

        Optional<FavoritePlace> optionalFavoritePlace =
                repository.findByWheelCenterIdAndMemberId(favoritePlace.getWheelCenter().getWheelCenterId(), favoritePlace.getMember().getMemberId());

        optionalFavoritePlace.ifPresent((favor) -> {
            throw new BusinessLogicException(FAVORITE_PLACE_ALREADY_EXISTS);
        });
    }


    public List<FavoritePlaceResponseDto> getFavoritePlaces(Long memberId) {

        List<FavoritePlace> optionalFavoritePlaces = repository.findByMemberId(memberId)
                .orElseThrow(() -> new BusinessLogicException(FAVORITE_PLACE_NOT_FOUND));

        return optionalFavoritePlaces.stream()
                .map(mapper::FavoriteToFavoritePlaceResponseDto)
                .collect(Collectors.toList());
    }


    public void deleteFavoritePlace(Long favoritePlaceId){

        repository.findById(favoritePlaceId).
        ifPresentOrElse(repository::delete, () -> {
            throw new BusinessLogicException(FAVORITE_PLACE_NOT_FOUND);
        });
    }
}
