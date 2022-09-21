package main.wheelmaster.vote.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import main.wheelmaster.member.entity.Member;
import main.wheelmaster.wheelcenter.entity.WheelCenter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;



@Getter
@Setter
@Entity
@NoArgsConstructor
public class Vote{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long voteId;

    @ManyToOne
    @JoinColumn(name="MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "WHEEL_CENTER_ID")
    private WheelCenter wheelCenter;

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