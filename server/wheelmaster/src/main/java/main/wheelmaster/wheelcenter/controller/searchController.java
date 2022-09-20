package main.wheelmaster.wheelcenter.controller;


import lombok.RequiredArgsConstructor;
import main.wheelmaster.response.MultiResponseWithPageInfoDto;
import main.wheelmaster.wheelcenter.entity.WheelCenter;
import main.wheelmaster.wheelcenter.mapper.WheelCenterMapper;
import main.wheelmaster.wheelcenter.service.WheelCenterService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/wheel-center")
public class searchController {

    private final WheelCenterService wheelCenterService;
    private final WheelCenterMapper mapper;

    @GetMapping("/cityName")
    public ResponseEntity getWheelCenterByCityName(@RequestParam("cityName") String cityName,
                                                   @Positive @PathParam("page") int page,
                                                   @Positive @PathParam("size") int size){
        Page<WheelCenter> pageOfWheelCenter = wheelCenterService.findWheelCenterByCityName(cityName, page-1, size);
        List<WheelCenter> wheelCenterList = pageOfWheelCenter.getContent();
        return new ResponseEntity(new MultiResponseWithPageInfoDto<>(mapper.wheelCenterListToInfoList(wheelCenterList),pageOfWheelCenter), HttpStatus.OK);
    }
}
