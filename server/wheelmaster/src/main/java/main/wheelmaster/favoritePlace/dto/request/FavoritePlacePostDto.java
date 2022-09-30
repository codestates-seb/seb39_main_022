package main.wheelmaster.favoritePlace.dto.request;

import lombok.Data;
import main.wheelmaster.member.entity.Member;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
public class FavoritePlacePostDto {
    private Member member;
    @Positive
    private Long wheelCenterId;
    @NotBlank
    private String facultyName;

    @Positive
    private Double longitude;
    @Positive
    private Double latitude;

    public static FavoritePlacePostDto of(FavoritePlacePostDto favoritePlacePostDto, Member member, Long wheelCenterId)
    {
        FavoritePlacePostDto favoritePlacePostDtoResult = new FavoritePlacePostDto();

        favoritePlacePostDtoResult.member = member;
        favoritePlacePostDtoResult.wheelCenterId = wheelCenterId;
        favoritePlacePostDtoResult.facultyName = favoritePlacePostDto.getFacultyName();
        favoritePlacePostDtoResult.longitude = favoritePlacePostDto.getLongitude();
        favoritePlacePostDtoResult.latitude = favoritePlacePostDto.getLatitude();

        return favoritePlacePostDtoResult;
    }
}