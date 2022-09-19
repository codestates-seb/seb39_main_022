package main.wheelmaster.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.wheelmaster.member.entity.Member;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CommentRequestDto {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class createCommentDto{
        @NotNull
        private long centerId;

        @NotEmpty
        private String comment;

        private Member member;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class updateCommentDto{
        @NotNull
        private long centerId;

        private long commentId;

        @NotEmpty
        private String comment;

        private Member member;
    }
}
