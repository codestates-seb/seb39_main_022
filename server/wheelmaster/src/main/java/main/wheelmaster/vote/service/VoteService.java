package main.wheelmaster.vote.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    private final VoteRepository repository;


    public Vote create(Vote vote) {
        verifyDuplicateVote(vote);
        return repository.save(vote);
    }

    public Vote update(Vote vote) {
        Vote findVote = verifyVoteExists(vote);

        Optional.ofNullable(vote.getUpDown()).ifPresent(findVote::setUpDown);
        return repository.save(findVote);
    }

    @Transactional(readOnly = true)
    public Vote verifyVoteExists(Vote vote){
        return repository.findById(vote.getVoteId())
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.VOTE_NOT_FOUND));
    }

    public void verifyDuplicateVote(Vote vote){
        Optional<Vote> optionalVote = repository.findByCenterIdAndMemberId(vote.getWheelCenter().getCenterId(), vote.getMember().getMemberId());
        if (optionalVote.isPresent()) throw new BusinessLogicException(ExceptionCode.VOTE_ALREADY_EXISTS);
    }
}
