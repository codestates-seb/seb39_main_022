package main.wheelmaster.vote.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import main.wheelmaster.member.entity.Member;
import main.wheelmaster.vote.dto.VoteRequestDto.VotePostDto;
import main.wheelmaster.vote.dto.VoteRequestDto.VoteUpdateDto;
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
                                @Positive @PathVariable("centerId") long centerId,
                                @RequestBody VotePostDto votePostDto)
    {
        log.info("member = {}", member);
        votePostDto.setCenterId(centerId);
        votePostDto.setMember(member);

        Vote savedVote = voteService.create(mapper.VotePostDtoToVote(votePostDto));

        return mapper.VoteToVoteResponseDto(savedVote);
    }

    @PatchMapping("/{voteId}")
    public VoteResponseDto updateVote(@SessionAttribute(LOGIN_MEMBER)Member member,
                                      @Positive @PathVariable("centerId") long centerId,
                                      @Positive @PathVariable("voteId") long voteId,
                                      @RequestBody VoteUpdateDto voteUpdateDto)
    {
        voteUpdateDto.setCenterId(centerId);
        voteUpdateDto.setMember(member);

        Vote savedVote = voteService.create(mapper.VoteUpdateDtoToVote(voteUpdateDto));

        return mapper.VoteToVoteResponseDto(savedVote);
    }


}