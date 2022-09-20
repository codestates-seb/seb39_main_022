package main.wheelmaster.comment.mapper;

import main.wheelmaster.comment.dto.CommentRequestDto;
import main.wheelmaster.comment.dto.CommentResponseDto;
import main.wheelmaster.comment.entity.Comment;
import main.wheelmaster.member.dto.MemberResponseDto;
import main.wheelmaster.wheelcenter.entity.WheelCenter;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    default Comment createCommentDtoToComment(CommentRequestDto.createCommentDto createCommentDto) {
        Comment comment = new Comment();
        comment.setMember(createCommentDto.getMember());

        WheelCenter wheelCenter = new WheelCenter();
        wheelCenter.setCenterId(createCommentDto.getCenterId());

        comment.setCenter(wheelCenter);
        comment.setComment(createCommentDto.getComment());
        return comment;
    }

    default CommentResponseDto.CommentInfo commentToCommentInfo(Comment comment){
        return CommentResponseDto.CommentInfo.builder()
                .comment(comment.getComment())
                .member(MemberResponseDto.MemberComments.builder()
                        .nickName(comment.getMember().getNickName())
                        .build())
                .build();
    }

    default Comment updateCommentDtoToComment(CommentRequestDto.updateCommentDto updateCommentDto){
        Comment comment = new Comment();
        comment.setMember(updateCommentDto.getMember());

        comment.setCommentId(updateCommentDto.getCommentId());
        comment.setComment(updateCommentDto.getComment());
        return comment;
    }
}
