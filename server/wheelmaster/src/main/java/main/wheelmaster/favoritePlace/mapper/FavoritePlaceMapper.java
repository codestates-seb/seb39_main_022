package main.wheelmaster.favoritePlace.mapper;

import main.wheelmaster.favoritePlace.dto.request.FavoritePlacePostDto;
import main.wheelmaster.favoritePlace.dto.response.FavoritePlaceResponseDto;
import main.wheelmaster.favoritePlace.entity.FavoritePlace;
import main.wheelmaster.wheelcenter.entity.WheelCenter;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FavoritePlaceMapper {

    public default FavoritePlace FavoritePlacePostDtoToFavoritePlace(FavoritePlacePostDto favoritePlacePostDto){

        FavoritePlace favoritePlace = new FavoritePlace();

        favoritePlace.setWheelCenter(WheelCenter.builder()
                .wheelCenterId(favoritePlacePostDto.getWheelCenterId()).build());

        favoritePlace.setMember(favoritePlacePostDto.getMember());
        favoritePlace.setFacultyName(favoritePlacePostDto.getFacultyName());
        favoritePlace.setLatitude(favoritePlace.getLatitude());
        favoritePlace.setLongitude(favoritePlace.getLongitude());

        return favoritePlace;
    }


    public FavoritePlaceResponseDto FavoriteToFavoritePlaceResponseDto(FavoritePlace favoritePlace);

}
