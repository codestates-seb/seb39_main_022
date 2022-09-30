package main.wheelmaster.comment.repository;


import main.wheelmaster.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {


    @Query(value = "select * from COMMENT where COMMENT_ID = :commentId and MEMBER_ID = :memberId",nativeQuery = true)
    Optional<Comment> findByIdAndCenterIdAndMemberId(@Param("commentId") long commentId,
                                                     @Param("memberId") long memberId);

}
