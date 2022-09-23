package main.wheelmaster.wheelcenter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class WheelCenterResponseDto {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class wheelCenterInfo{
        private String cityName;
        private String facultyName;
        private String sigunguName;
        private String roadAddress;
        private String oldAddress;
        private String installLocation;
        private Double latitude;
        private Double longitude;
        private Boolean airInjectorFlag;
        private Boolean phoneChargerFlag;
    }
}
