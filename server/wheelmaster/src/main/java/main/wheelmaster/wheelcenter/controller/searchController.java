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
@RequestMapping("wheel-center")
public class searchController {

    private final WheelCenterService wheelCenterService;
    private final WheelCenterMapper mapper;

    //TODO 어떤 단어로 검색해도 한 번에 찾을 수 있도록 컨트롤러 합치기

    //도 이름으로 검색
    @GetMapping("/cityName")
    public ResponseEntity getWheelCenterByCityName(@RequestParam("cityName") String cityName,
                                                   @Positive @PathParam("page") int page,
                                                   @Positive @PathParam("size") int size){
        Page<WheelCenter> pageOfWheelCenter = wheelCenterService.findWheelCenterByCityName(cityName, page-1, size);
        List<WheelCenter> wheelCenterList = pageOfWheelCenter.getContent();
        return new ResponseEntity(new MultiResponseWithPageInfoDto<>(mapper.wheelCenterListToInfoList(wheelCenterList),pageOfWheelCenter), HttpStatus.OK);
    }

    //시군구로 검색
    @GetMapping("/sigunguName")
    public ResponseEntity getWheelCenterBySigunguName(@RequestParam("sigunguName") String sigunguName,
                                                      @Positive @PathParam("page") int page,
                                                      @Positive @PathParam("size") int size){
        Page<WheelCenter> pageOfWheelCenter = wheelCenterService.findWheelCenterBySigunguName(sigunguName, page-1, size);
        List<WheelCenter> wheelCenterList = pageOfWheelCenter.getContent();
        return new ResponseEntity(new MultiResponseWithPageInfoDto<>(mapper.wheelCenterListToInfoList(wheelCenterList),pageOfWheelCenter), HttpStatus.OK);
    }

    //도로명 주소로 검색(ex:석촌호수로)
    @GetMapping("/roadAddress")
    public ResponseEntity getWheelCenterByRoadAddress(@RequestParam("roadAddress") String roadAddress,
                                                  @Positive @PathParam("page") int page,
                                                  @Positive @PathParam("size") int size){
        Page<WheelCenter> pageOfWheelCenter = wheelCenterService.findWheelCenterByRoadAddress(roadAddress, page-1, size);
        List<WheelCenter> wheelCenterList = pageOfWheelCenter.getContent();
        return new ResponseEntity(new MultiResponseWithPageInfoDto<>(mapper.wheelCenterListToInfoList(wheelCenterList),pageOfWheelCenter), HttpStatus.OK);
    }

    //지번 주소로 검색(ex:석촌동)
    @GetMapping("/oldAddress")
    public ResponseEntity getWheelCenterByOldAddress(@RequestParam("oldAddress") String oldAddress,
                                                  @Positive @PathParam("page") int page,
                                                  @Positive @PathParam("size") int size){
        Page<WheelCenter> pageOfWheelCenter = wheelCenterService.findWheelCenterByOldAddress(oldAddress, page-1, size);
        List<WheelCenter> wheelCenterList = pageOfWheelCenter.getContent();
        return new ResponseEntity(new MultiResponseWithPageInfoDto<>(mapper.wheelCenterListToInfoList(wheelCenterList),pageOfWheelCenter), HttpStatus.OK);
    }
}
