package main.wheelmaster.vote.mapper;

import main.wheelmaster.vote.dto.VoteRequestDto;
import main.wheelmaster.vote.dto.VoteRequestDto.VotePostDto;
import main.wheelmaster.vote.dto.VoteRequestDto.VoteUpdateDto;
import main.wheelmaster.vote.dto.VoteResponseDto;
import main.wheelmaster.vote.entity.Vote;
import main.wheelmaster.wheelcenter.entity.WheelCenter;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VoteMapper {

    public default Vote VotePostDtoToVote(VotePostDto votePostDto){
        WheelCenter wheelCenter = new WheelCenter();
        wheelCenter.setCenterId(votePostDto.getCenterId());

        Vote vote = new Vote();
        vote.setUpDown(votePostDto.getUpDown());
        vote.setMember(votePostDto.getMember());
        vote.setWheelCenter(wheelCenter);

        return vote;
    }

    public default VoteResponseDto VoteToVoteResponseDto(Vote vote) {
        return VoteResponseDto.builder()
                .voteId(vote.getVoteId())
                .centerId(vote.getWheelCenter().getCenterId())
                .upDown(vote.getUpDown())
                .build();
    }

    public default Vote VoteUpdateDtoToVote(VoteUpdateDto voteUpdateDto){
        WheelCenter wheelCenter = new WheelCenter();
        wheelCenter.setCenterId(voteUpdateDto.getCenterId());

        Vote vote = new Vote();
        vote.setUpDown(voteUpdateDto.getUpDown());
        vote.setMember(voteUpdateDto.getMember());
        vote.setVoteId(voteUpdateDto.getVoteId());
        vote.setWheelCenter(wheelCenter);

        return vote;
    }
}