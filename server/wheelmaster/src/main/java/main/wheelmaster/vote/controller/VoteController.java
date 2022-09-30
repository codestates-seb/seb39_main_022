package main.wheelmaster.vote.controller;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import main.wheelmaster.global.argumentresolver.Login;
import main.wheelmaster.member.entity.Member;
import main.wheelmaster.vote.dto.VoteGetDto;
import main.wheelmaster.vote.dto.VotePostDto;
import main.wheelmaster.vote.dto.VoteResponseDto;
import main.wheelmaster.vote.entity.Vote;
import main.wheelmaster.vote.mapper.VoteMapper;
import main.wheelmaster.vote.service.VoteService;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/wheel-center/{wheelCenterId}/vote")
public class VoteController {

    private final VoteService voteService;
    private final VoteMapper mapper;

    @ApiOperation(value = "추천&비추천")
    @PostMapping
    public VoteResponseDto vote(@Login Member member,
                                @Positive @PathVariable("wheelCenterId") Long wheelCenterId,
                                @RequestBody VotePostDto votePostDto) {
        votePostDto.setWheelCenterId(wheelCenterId);
        votePostDto.setMember(member);

        Vote savedVote = voteService.create(mapper.VotePostDtoToVote(votePostDto));

        return mapper.VoteToVoteResponseDto(savedVote);
    }

    @ApiOperation(value = "추천&비추천 삭제")
    @DeleteMapping("/{voteId}")
    public void cancelVote(@Login Member member,
                           @Positive @PathVariable("wheelCenterId")Long wheelCenterId,
                           @Positive @PathVariable("voteId") Long voteId) {

        Vote vote = new Vote();
        vote.setVoteId(voteId);
        vote.setMember(member);

        voteService.deleteVote(vote);
    }

    @ApiOperation(value = "추천확인")
    @GetMapping
    public VoteResponseDto getVote(@Login Member member,
                                   @Positive @PathVariable("wheelCenterId") Long wheelCenterId){

        VoteGetDto voteGetDto = new VoteGetDto(member, wheelCenterId);
        Vote vote = voteService.readVote(mapper.VoteGetResponseDtoToVote(voteGetDto));
        return (vote == null) ? null : mapper.VoteToVoteResponseDto(vote);
    }

}