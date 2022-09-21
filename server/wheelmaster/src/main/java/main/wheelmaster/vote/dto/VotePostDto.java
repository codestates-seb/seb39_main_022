package main.wheelmaster.vote.dto;

import lombok.*;
import main.wheelmaster.member.entity.Member;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VotePostDto {
    private Long centerId;
    private Member member;
    @NonNull
    private Boolean upDown;
}
