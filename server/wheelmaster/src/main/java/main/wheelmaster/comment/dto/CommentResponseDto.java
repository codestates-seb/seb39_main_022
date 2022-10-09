package main.wheelmaster.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.wheelmaster.member.dto.MemberResponseDto.MemberComments;

public class CommentResponseDto {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class CommentInfo{
        private String comment;
        private MemberComments member;
    }
}
