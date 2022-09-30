package main.wheelmaster.favoritePlace.dto.response;

import lombok.Data;

@Data
public class FavoritePlaceResponseDto {
    private Long favoritePlaceId;
    private String facultyName;
    private Double longitude;
    private Double latitude;
}
