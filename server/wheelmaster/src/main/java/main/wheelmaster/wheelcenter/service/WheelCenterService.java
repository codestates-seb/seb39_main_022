package main.wheelmaster.wheelcenter.service;

import lombok.RequiredArgsConstructor;
import main.wheelmaster.wheelcenter.entity.WheelCenter;
import main.wheelmaster.wheelcenter.repository.WheelCenterRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WheelCenterService
{
    private final WheelCenterRepository repository;


    public WheelCenter create(WheelCenter wheelCenter)
    {
        return repository.save(wheelCenter);
    }


}
