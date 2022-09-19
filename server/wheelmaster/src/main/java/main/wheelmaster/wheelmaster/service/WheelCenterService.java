package main.wheelmaster.wheelmaster.service;

import lombok.RequiredArgsConstructor;
import main.wheelmaster.wheelmaster.entity.WheelCenter;
import main.wheelmaster.wheelmaster.repository.WheelCenterRepository;
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

