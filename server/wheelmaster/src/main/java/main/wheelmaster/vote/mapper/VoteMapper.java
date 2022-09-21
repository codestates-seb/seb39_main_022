package main.wheelmaster.vote.mapper;

import main.wheelmaster.vote.dto.VoteGetDto;
import main.wheelmaster.vote.dto.VotePostDto;
import main.wheelmaster.vote.dto.VoteResponseDto;
import main.wheelmaster.vote.entity.Vote;
import main.wheelmaster.wheelcenter.entity.WheelCenter;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VoteMapper {

    public default Vote VotePostDtoToVote(VotePostDto votePostDto) {
        WheelCenter wheelCenter = new WheelCenter();
        wheelCenter.setWheelCenterId(votePostDto.getWheelCenterId());

        Vote vote = new Vote();
        vote.setUpDown(votePostDto.getUpDown());
        vote.setMember(votePostDto.getMember());
        vote.setWheelCenter(wheelCenter);

        return vote;
    }

    public default Vote VoteGetResponseDtoToVote(VoteGetDto voteGetDto) {
        WheelCenter wheelCenter = new WheelCenter();
        wheelCenter.setWheelCenterId(voteGetDto.getWheelCenterId());

        Vote vote = new Vote();
        vote.setMember(voteGetDto.getMember());
        vote.setWheelCenter(wheelCenter);
        return vote;
    }

    public default VoteResponseDto VoteToVoteResponseDto(Vote vote) {
        return VoteResponseDto.builder()
                .voteId(vote.getVoteId())
                .wheelCenterId(vote.getWheelCenter().getWheelCenterId())
                .upDown(vote.getUpDown())
                .build();
    }
}