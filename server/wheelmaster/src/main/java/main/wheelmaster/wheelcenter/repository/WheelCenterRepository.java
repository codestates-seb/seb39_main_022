package main.wheelmaster.wheelcenter.repository;

import main.wheelmaster.wheelcenter.entity.WheelCenter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WheelCenterRepository extends JpaRepository<WheelCenter, Long> {


    //TODO - 지금은 주소의 단위로 나눠지기 때문에 한 번에 받을 수 있도록 처리
    @Query(value = "select * from WHEEL_CENTER where CITY_NAME like %:cityName%", nativeQuery = true)
    Page<WheelCenter> findAllByCityName(@Param("cityName") String cityName, Pageable pageable);


    @Query(value = "select * from WHEEL_CENTER where SIGUNGU_NAME like %:sigunguName%", nativeQuery = true)
    Page<WheelCenter> findAllBySigunguName(@Param("sigunguName") String sigunguName, Pageable pageable);

    @Query(value = "select * from WHEEL_CENTER where ROAD_ADDRESS like %:roadAddress%", nativeQuery = true)
    Page<WheelCenter> findAllByRoadAddress(@Param("roadAddress") String roadAddress, Pageable pageable);

    @Query(value = "select * from WHEEL_CENTER where OLD_ADDRESS like %:oldAddress%", nativeQuery = true)
    Page<WheelCenter> findAllByOldAddress(@Param("oldAddress") String oldAddress,  Pageable pageable);
}
