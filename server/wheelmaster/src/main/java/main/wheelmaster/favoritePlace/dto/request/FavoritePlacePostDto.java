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

    public static FavoritePlacePostDto of(String facultyName, Member member, Double longitude, Double latitude, Long wheelCenterId)
    {
        FavoritePlacePostDto favoritePlacePostDtoResult = new FavoritePlacePostDto();

        favoritePlacePostDtoResult.facultyName = facultyName;
        favoritePlacePostDtoResult.member = member;
        favoritePlacePostDtoResult.longitude = longitude;
        favoritePlacePostDtoResult.latitude = latitude;
        favoritePlacePostDtoResult.wheelCenterId = wheelCenterId;
        return favoritePlacePostDtoResult;
    }
}