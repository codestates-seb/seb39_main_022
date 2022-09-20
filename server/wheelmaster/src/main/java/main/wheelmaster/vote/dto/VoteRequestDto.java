package main.wheelmaster.vote.dto;

import lombok.*;
import main.wheelmaster.member.entity.Member;

public class VoteRequestDto {
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class VotePostDto {
        private long centerId;
        private Member member;
        private Boolean upDown;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class VoteUpdateDto {
        private long voteId;
        private long centerId;
        private Member member;
        private Boolean upDown;
    }
}