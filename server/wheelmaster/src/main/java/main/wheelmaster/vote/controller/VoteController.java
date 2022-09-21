package main.wheelmaster.vote.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import main.wheelmaster.member.entity.Member;
import main.wheelmaster.vote.dto.VoteGetDto;
import main.wheelmaster.vote.dto.VotePostDto;
import main.wheelmaster.vote.dto.VoteResponseDto;
import main.wheelmaster.vote.entity.Vote;
import main.wheelmaster.vote.mapper.VoteMapper;
import main.wheelmaster.vote.service.VoteService;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;

import static main.wheelmaster.member.SessionConst.LOGIN_MEMBER;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/wheel-center/{centerId}/vote")
public class VoteController {

    private final VoteService voteService;
    private final VoteMapper mapper;

    @PostMapping
    public VoteResponseDto vote(@SessionAttribute(LOGIN_MEMBER)Member member,
                                @Positive @PathVariable("centerId") Long centerId,
                                @RequestBody VotePostDto votePostDto)
    {
        votePostDto.setCenterId(centerId);
        votePostDto.setMember(member);

        Vote savedVote = voteService.create(mapper.VotePostDtoToVote(votePostDto));

        return mapper.VoteToVoteResponseDto(savedVote);
    }

    @DeleteMapping("/{voteId}")
    public void cancelVote(@SessionAttribute(LOGIN_MEMBER)Member member,
                           @Positive @PathVariable("centerId")Long centerId,
                           @Positive @PathVariable("voteId") Long voteId) {

        Vote vote = new Vote();
        vote.setVoteId(voteId);
        vote.setMember(member);

        voteService.deleteVote(vote);

    }


    @GetMapping
    public VoteResponseDto getVote(@SessionAttribute(LOGIN_MEMBER)Member member,
                                   @Positive @PathVariable("centerId") Long centerId){

        VoteGetDto voteGetDto = new VoteGetDto(member, centerId);
        Vote vote = voteService.readVote(mapper.VoteGetResponseDtoToVote(voteGetDto));
        return (vote == null) ? null : mapper.VoteToVoteResponseDto(vote);
    }





}