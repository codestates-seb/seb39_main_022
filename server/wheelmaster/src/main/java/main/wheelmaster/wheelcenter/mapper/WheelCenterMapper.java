package main.wheelmaster.wheelcenter.mapper;

import main.wheelmaster.wheelcenter.dto.WheelCenterResponseDto;
import main.wheelmaster.wheelcenter.entity.WheelCenter;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WheelCenterMapper {
    List<WheelCenterResponseDto.wheelCenterInfo> wheelCenterListToInfoList(List<WheelCenter> wheelCenterList);
}
