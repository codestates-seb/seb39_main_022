package main.wheelmaster.comment.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import main.wheelmaster.member.entity.Member;
import main.wheelmaster.wheelmaster.entity.WheelCenter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @ManyToOne
    @JoinColumn(name="MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "CENTER_ID")
    private WheelCenter center;

    @Column(nullable = false, length = 100)
    private String comment;

    public void addMember(Member member) {
        if(this.member == null && member != null){
            this.member = member;
        }
    }

    public void addCenter(WheelCenter center){
        if(this.center == null && center != null){
            this.center = center;
        }
    }
}