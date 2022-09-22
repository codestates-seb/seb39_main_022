package main.wheelmaster.favoritePlace.repository;

import main.wheelmaster.favoritePlace.entity.FavoritePlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavoritePlaceRepository extends JpaRepository<FavoritePlace, Long> {

    Optional<FavoritePlace> findById(Long id);

    Optional<List<FavoritePlace>> findByMemberId(Long memberId);

    Optional<FavoritePlace> findByWheelCenterIdAndMemberId(long wheelCenterId, long MemberId);
}
