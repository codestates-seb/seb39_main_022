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
        private long wheelCenterId;
        private String cityName;
        private String facultyName;
        private String sigunguName;
        private String roadNameAddress;
        private String lotNumberAddress;
        private String installLocation;
        private Double latitude;
        private Double longitude;
        private Boolean airInjectorFlag;
        private Boolean phoneChargerFlag;
    }
}
