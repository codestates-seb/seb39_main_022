package main.wheelmaster.comment.service;

import lombok.RequiredArgsConstructor;
import main.wheelmaster.comment.entity.Comment;
import main.wheelmaster.comment.repository.CommentRepository;
import main.wheelmaster.exception.BusinessLogicException;
import main.wheelmaster.exception.ExceptionCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment updateComment(Comment comment) {
        Comment findComment = findVerifiedComment(comment.getCommentId(), comment.getMember().getMemberId());
        Optional.ofNullable(comment.getComment()).ifPresent(findComment::setComment);
        return commentRepository.save(findComment);
    }

    @Transactional(readOnly = true)
    public Comment findVerifiedComment(long commentId, long memberId){
        Optional<Comment> optionalComment = commentRepository.findByIdAndCenterIdAndMemberId(commentId,memberId);
        return optionalComment.orElseThrow(() -> new BusinessLogicException(ExceptionCode.COMMENT_NOT_FOUND));
    }

    public void deleteComment(long commentId, long memberId) {
        Comment findComment = findVerifiedComment(commentId, memberId);
        commentRepository.delete(findComment);
    }
}
