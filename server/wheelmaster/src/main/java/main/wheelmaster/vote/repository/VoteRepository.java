package main.wheelmaster.vote.repository;

import main.wheelmaster.vote.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

    Optional<Vote> findById(long voteId);


    @Query(value = "select * from WHEEL_CENTER where CENTER_ID = :centerId and MEMBER_ID = :memberId", nativeQuery = true)
    Optional<Vote> findByCenterIdAndMemberId(@Param("centerId") long centerId, @Param("memberId") long memberId);
}