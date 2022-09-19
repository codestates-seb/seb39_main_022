package main.wheelmaster.comment.entity;

import lombok.*;
import main.wheelmaster.member.entity.Member;
import main.wheelmaster.wheelcenter.entity.WheelCenter;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
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

}
