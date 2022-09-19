package main.wheelmaster.wheelmaster.repository;

import main.wheelmaster.wheelmaster.entity.WheelCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WheelCenterRepository extends JpaRepository<WheelCenter, Long> {
}