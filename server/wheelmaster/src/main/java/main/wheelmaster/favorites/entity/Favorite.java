package main.wheelmaster.favorites.entity;


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
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long favoriteId;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "CENTER_ID")
    private Center center;

    private String facultyName;

    private double latitude;

    private double longitude;
}