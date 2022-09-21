package main.wheelmaster.favoritePlace.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import main.wheelmaster.member.entity.Member;
import main.wheelmaster.wheelcenter.entity.WheelCenter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class FavoritePlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long favoriteId;

    @ManyToOne
    @JoinColumn(name="MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name="WHEEL_CENTER_ID")
    private WheelCenter wheelCenter;

    @Column(length = 100, nullable = false)
    private String facultyName;

    @Column(nullable = false, updatable = false)
    private Double latitude;

    @Column(nullable = false, updatable = false)
    private Double longitude;

    public void setMember(Member member) {
        if(member != null && this.member == null) {
            this.member = member;
        }
    }

    public void setWheelCenter(WheelCenter wheelCenter) {
        if(wheelCenter != null && this.wheelCenter == null){
            this.wheelCenter = wheelCenter;
        }
    }
}