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

    /**
     * vote 의 upDown Boolean 값이 다른 경우 update
     * 그렇지 않은 경우 예외를 던짐
     *
     * @param vote
     * @return
     */
    @Transactional(rollbackFor = {BusinessLogicException.class, RuntimeException.class})
    public Vote create(Vote vote) {

        verifyDuplicateVote(vote);
        return repository.save(vote);

    }

    public void verifyDuplicateVote(Vote vote) {

        Optional<Vote> findVote = repository.findByWheelCenterIdAndMemberId(vote.getWheelCenter().getWheelCenterId(), vote.getMember().getMemberId());

        if (findVote.isPresent()) {

            if (findVote.get().getUpDown() == vote.getUpDown()) {

                throw new BusinessLogicException(ExceptionCode.VOTE_ALREADY_EXISTS);
            } else {
                vote.setVoteId(findVote.get().getVoteId());
                vote.setWheelCenter(findVote.get().getWheelCenter());
            }
        }
    }

    @Transactional(rollbackFor = BusinessLogicException.class)
    public void deleteVote(Vote vote) {
        Vote findVote = verifyVoteExists(vote);
        repository.delete(findVote);
    }

    public Vote verifyVoteExists(Vote vote) {
        return repository.findById(vote.getVoteId()).orElseThrow(() -> new BusinessLogicException(ExceptionCode.VOTE_NOT_FOUND));
    }

    public Vote readVote(Vote vote) throws NullPointerException {
        log.info("memberId = {}, centerId={}", vote.getMember(), vote.getWheelCenter().getWheelCenterId());
        Optional<Vote> optionalVote = repository.findByWheelCenterIdAndMemberId(vote.getWheelCenter().getWheelCenterId(), vote.getMember().getMemberId());
        return optionalVote.orElse(null);
    }

}
