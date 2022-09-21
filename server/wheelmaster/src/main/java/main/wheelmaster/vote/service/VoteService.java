package main.wheelmaster.vote.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import main.wheelmaster.comment.entity.Comment;
import main.wheelmaster.exception.BusinessLogicException;
import main.wheelmaster.exception.ExceptionCode;
import main.wheelmaster.vote.entity.Vote;
import main.wheelmaster.vote.repository.VoteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class VoteService {
    private final VoteRepository voteRepository;


    public Vote create(Vote vote) {
        return voteRepository.save(vote);
    }

    public Vote updateVote(Vote vote){
        Vote findVote = findVerifiedVote(vote.getWheelCenter().getCenterId(), vote.getMember().getMemberId());
        Optional.ofNullable(vote.getUpDown()).ifPresent(findVote::setUpDown);
        return voteRepository.save(findVote);
    }


//    @Transactional(readOnly = true)
//    public Vote findVerifiedVote(long voteId, long memberId){
//        Optional<Vote> optionalVote = voteRepository.findByIdAndVoteIdAndMemberId(voteId,memberId);
//        return optionalVote.orElseThrow(()->new BusinessLogicException(ExceptionCode.VOTE_ALREADY_EXISTS));
//    }

    @Transactional(readOnly = true)
    public Vote findVerifiedVote(long centerId, long memberId){
        Optional<Vote> optionalVote = voteRepository.findByIdAndVoteIdAndMemberId(centerId,memberId);
        return optionalVote.orElseThrow(()->new BusinessLogicException(ExceptionCode.VOTE_ALREADY_EXISTS));
    }

//    public void deleteVote(long voteId, long memberId) {
//        Vote findVote = findVerifiedVote(voteId,memberId);
//        voteRepository.delete(findVote);
//    }

    //    public Vote create(Vote vote) {
//        verifyDuplicateVote(vote);
//        return voteRepository.save(vote);
//    }

//    public Vote update(Vote vote) {
//        Vote findVote = verifyVoteExists(vote);
//
//        Optional.ofNullable(vote.getUpDown()).ifPresent(findVote::setUpDown);
//        return voteRepository.save(findVote);
//    }

//    @Transactional(readOnly = true)
//    public Vote verifyVoteExists(Vote vote){
//        return voteRepository.findById(vote.getVoteId())
//                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.VOTE_NOT_FOUND));
//    }
//
//    public void verifyDuplicateVote(Vote vote){
//        Optional<Vote> optionalVote = voteRepository.findByCenterIdAndMemberId(vote.getWheelCenter().getCenterId(), vote.getMember().getMemberId());
//        if (optionalVote.isPresent()) throw new BusinessLogicException(ExceptionCode.VOTE_ALREADY_EXISTS);
//    }
}
