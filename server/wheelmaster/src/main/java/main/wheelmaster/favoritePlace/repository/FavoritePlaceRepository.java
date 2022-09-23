package main.wheelmaster.favoritePlace.repository;

import main.wheelmaster.favoritePlace.entity.FavoritePlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavoritePlaceRepository extends JpaRepository<FavoritePlace, Long> {

    Optional<FavoritePlace> findById(Long id);

    @Query(value="Select * from favorite_place where member_id = :memberId", nativeQuery = true)
    Optional<List<FavoritePlace>> findByMemberId(@Param("memberId") Long memberId);

    @Query(value = "Select * from favorite_place where wheel_center_id = :wheelCenterId AND member_id = :memberId", nativeQuery = true)
    Optional<FavoritePlace> findByWheelCenterIdAndMemberId(@Param("wheelCenterId")Long wheelCenterId,@Param("memberId") Long MemberId);
}
