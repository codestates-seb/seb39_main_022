package main.wheelmaster.wheelcenter.mapper;

import main.wheelmaster.wheelcenter.dto.WheelCenterResponseDto;
import main.wheelmaster.wheelcenter.entity.WheelCenter;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface WheelCenterMapper {
    default List<WheelCenterResponseDto.wheelCenterInfo> wheelCenterListToInfoList(List<WheelCenter> wheelCenterList){
        return wheelCenterList.stream()
                .map(this::wheelCenterListToInfoList).collect(Collectors.toList());
    }

    default WheelCenterResponseDto.wheelCenterInfo wheelCenterListToInfoList(WheelCenter wheelCenter){
        return WheelCenterResponseDto.wheelCenterInfo.builder()
                .wheelCenterId(wheelCenter.getWheelCenterId())
                .cityName(wheelCenter.getCityName())
                .facultyName(wheelCenter.getFacultyName())
                .sigunguName(wheelCenter.getSigunguName())
                .roadAddress(wheelCenter.getRoadAddress())
                .oldAddress(wheelCenter.getOldAddress())
                .installLocation(wheelCenter.getInstallLocation())
                .latitude(wheelCenter.getLatitude())
                .longitude(wheelCenter.getLongitude())
                .airInjectorFlag(wheelCenter.getAirInjectorFlag())
                .phoneChargerFlag(wheelCenter.getPhoneChargerFlag())
                .build();
    }
}
