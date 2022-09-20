package main.wheelmaster.wheelcenter.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import main.wheelmaster.wheelcenter.dto.WheelCenterResponseDto;
import main.wheelmaster.wheelcenter.entity.WheelCenter;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-20T23:36:59+0900",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.13 (Oracle Corporation)"
)
@Component
public class WheelCenterMapperImpl implements WheelCenterMapper {

    @Override
    public List<WheelCenterResponseDto.wheelCenterInfo> wheelCenterListToInfoList(List<WheelCenter> wheelCenterList) {
        if ( wheelCenterList == null ) {
            return null;
        }

        List<WheelCenterResponseDto.wheelCenterInfo> list = new ArrayList<WheelCenterResponseDto.wheelCenterInfo>( wheelCenterList.size() );
        for ( WheelCenter wheelCenter : wheelCenterList ) {
            list.add( wheelCenterTowheelCenterInfo( wheelCenter ) );
        }

        return list;
    }

    protected WheelCenterResponseDto.wheelCenterInfo wheelCenterTowheelCenterInfo(WheelCenter wheelCenter) {
        if ( wheelCenter == null ) {
            return null;
        }

        WheelCenterResponseDto.wheelCenterInfo.wheelCenterInfoBuilder wheelCenterInfo = WheelCenterResponseDto.wheelCenterInfo.builder();

        wheelCenterInfo.cityName( wheelCenter.getCityName() );
        wheelCenterInfo.facultyName( wheelCenter.getFacultyName() );
        wheelCenterInfo.sigunguName( wheelCenter.getSigunguName() );
        wheelCenterInfo.address( wheelCenter.getAddress() );
        wheelCenterInfo.installLocation( wheelCenter.getInstallLocation() );

        return wheelCenterInfo.build();
    }
}
