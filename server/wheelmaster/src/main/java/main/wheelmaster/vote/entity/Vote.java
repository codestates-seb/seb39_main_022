package main.wheelmaster.vote.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import main.wheelmaster.member.entity.Member;
import main.wheelmaster.wheelcenter.entity.WheelCenter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import main.wheelmaster.member.entity.Member;
import main.wheelmaster.wheelcenter.entity.WheelCenter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity(name="Vote")
@Table(name="vote")
@NoArgsConstructor
public class Vote{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="vote_id")
    private Long voteId;

    @ManyToOne
    @JoinColumn(name = "member_id", unique = true)
    private Member member;

    @ManyToOne
    @JoinColumn(name="wheel_center_id", unique = true)
    private WheelCenter wheelCenter;

    @Column(columnDefinition = "TinyInt", name="up_down")
    private Boolean upDown;


    public void setMember(Member member) {
        if(member != null && this.member == null) {
            this.member = member;
        }
    }

    public void setWheelCenter(WheelCenter wheelCenter) {
        if (wheelCenter != null && this.wheelCenter == null) {
            this.wheelCenter = wheelCenter;
        }
    }
}