package main.wheelmaster.vote.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VoteResponseDto {
    private Long voteId;
    private Long centerId;
    private Boolean upDown;
}