package main.wheelmaster.wheelcenter.repository;

import main.wheelmaster.wheelcenter.entity.WheelCenter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WheelCenterRepository extends JpaRepository<WheelCenter, Long> {
}
