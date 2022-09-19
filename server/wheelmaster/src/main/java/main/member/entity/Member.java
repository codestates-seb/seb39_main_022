package main.member.entity;


import lombok.*;
import main.comment.entity.Comment;
import main.favoriteplace.entity.FavoritePlace;
import main.vote.entity.Vote;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(nullable = false, updatable = false, length = 200, unique = true)
    private String email;

    @Column(nullable = false, length = 100)
    private String password;
    @Column(nullable = false)
    private String nickName;
    @Column(length = 50)
    private String phoneNumber;

    @OneToMany(mappedBy = "member",fetch = FetchType.LAZY)
    private List<Comment> comments;

    public void addComment(Comment comment){
        if(!this.comments.contains(comment) && comment != null){
            comments.add(comment);

            if(comment.getMember() == null)
                comment.setMember(this);
        }
    }

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Vote> votes;

    public void addVote(Vote vote) {
        if(!this.votes.contains(vote) && vote != null){
            votes.add(vote);

            if(vote.getMember() == null)
                vote.setMember(this);
        }
    }

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<FavoritePlace> favoritePlaces;

    public void addFavoritePlace(FavoritePlace favoritePlace){
        if(!this.favoritePlaces.contains(favoritePlace) && favoritePlace != null) {
            favoritePlaces.add(favoritePlace);

            if(favoritePlace.getMember() == null)
                favoritePlace.setMember(this);
        }
    }

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime modifiedAt = LocalDateTime.now();

}
