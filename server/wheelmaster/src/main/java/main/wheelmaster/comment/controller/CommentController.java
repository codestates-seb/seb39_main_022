package main.wheelmaster.comment.controller;


import lombok.RequiredArgsConstructor;
import main.wheelmaster.comment.dto.CommentRequestDto;
import main.wheelmaster.comment.entity.Comment;
import main.wheelmaster.comment.mapper.CommentMapper;
import main.wheelmaster.comment.service.CommentService;
import main.wheelmaster.member.SessionConst;
import main.wheelmaster.member.entity.Member;
import main.wheelmaster.response.MessageResponseDto;
import main.wheelmaster.response.SingleResponseWithMessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("wheel-center/{wheelCenterId}/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
    private final CommentMapper mapper;

    @PostMapping
    public ResponseEntity createComment(@SessionAttribute(name = SessionConst.LOGIN_MEMBER) Member member,
                                        @Positive @PathVariable("wheelCenterId") long wheelCenterId,
                                        @RequestBody @Valid CommentRequestDto.createCommentDto createCommentDto){

        createCommentDto.setWheelCenterId(wheelCenterId);
        createCommentDto.setMember(member);
        Comment comment = commentService.createComment(mapper.createCommentDtoToComment(createCommentDto));
        return new ResponseEntity<>(new SingleResponseWithMessageDto<>(mapper.commentToCommentInfo(comment),"SUCCESS"), HttpStatus.CREATED);
    }

    @PatchMapping("/{commentId}")
    public ResponseEntity updateComment(@SessionAttribute(name = SessionConst.LOGIN_MEMBER) Member member,
                                        @Positive @PathVariable("wheelCenterId") long wheelCenterId,
                                        @Positive @PathVariable("commentId") long commentId,
                                        @RequestBody @Valid CommentRequestDto.updateCommentDto updateCommentDto){
        updateCommentDto.setMember(member);
        updateCommentDto.setCommentId(commentId);
        updateCommentDto.setWheelCenterId(wheelCenterId);
        Comment comment = commentService.updateComment(mapper.updateCommentDtoToComment(updateCommentDto));
        return new ResponseEntity(new SingleResponseWithMessageDto<>(mapper.commentToCommentInfo(comment),"SUCCESS"),HttpStatus.OK);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity deleteComment(@SessionAttribute(name = SessionConst.LOGIN_MEMBER) Member member,
                                         @Positive @PathVariable("wheelCenterId") long wheelCenterId,
                                         @Positive @PathVariable("commentId") long commentId){
        commentService.deleteComment(commentId,member.getMemberId());
        return new ResponseEntity(new MessageResponseDto("NO_CONTENT"),HttpStatus.NO_CONTENT);
    }
}