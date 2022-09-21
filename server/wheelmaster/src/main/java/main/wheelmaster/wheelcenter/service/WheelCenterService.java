package main.wheelmaster.wheelcenter.service;

import lombok.RequiredArgsConstructor;
import main.wheelmaster.wheelcenter.repository.WheelCenterRepository;
import main.wheelmaster.wheelcenter.entity.WheelCenter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WheelCenterService {
    private final WheelCenterRepository wheelCenterRepository;


    public WheelCenter create(WheelCenter wheelCenter) {
        return wheelCenterRepository.save(wheelCenter);
    }


    public Page<WheelCenter> findWheelCenterByCityName(String cityName, int page, int size) {
        return wheelCenterRepository.findAllByCityName(cityName, PageRequest.of(page,size, Sort.by("CENTER_ID").descending()));
    }

    public Page<WheelCenter> findWheelCenterBySigunguName(String sigunguName, int page, int size) {
        return wheelCenterRepository.findAllBySigunguName(sigunguName, PageRequest.of(page,size, Sort.by("CENTER_ID").descending()));
    }
}
