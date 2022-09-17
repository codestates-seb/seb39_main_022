package main.wheelmaster.vote.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import main.wheelmaster.member.entity.Member;
import main.wheelmaster.wheelCenter.entity.Center;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long voteId;

    private int upDown;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "CENTER_ID")
    private Center center;
}
