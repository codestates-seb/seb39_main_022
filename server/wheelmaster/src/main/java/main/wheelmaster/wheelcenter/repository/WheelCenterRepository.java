package main.wheelmaster.wheelcenter.repository;

import main.wheelmaster.wheelcenter.entity.WheelCenter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WheelCenterRepository extends JpaRepository<WheelCenter, Long> {


    @Query(value = "select * from WHEEL_CENTER where CITY_NAME like %:cityName%", nativeQuery = true)
    Page<WheelCenter> findAllByCityName(@Param("cityName") String cityName, Pageable pageable);
}
