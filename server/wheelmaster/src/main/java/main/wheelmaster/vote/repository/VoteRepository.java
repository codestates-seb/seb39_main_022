package main.wheelmaster.vote.repository;

import main.wheelmaster.vote.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

    Optional<Vote> findById(Long voteId);


    @Query(value = "select * from Vote where wheel_center_id = :wheelCenterId and member_id = :memberId", nativeQuery = true)
    Optional<Vote> findByWheelCenterIdAndMemberId(@Param("wheelCenterId")long wheelCenterId,@Param("memberId") long memberId);
}

