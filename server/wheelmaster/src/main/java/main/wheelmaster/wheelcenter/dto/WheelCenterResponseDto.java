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
        private String address;
        private String installLocation;
    }
}
