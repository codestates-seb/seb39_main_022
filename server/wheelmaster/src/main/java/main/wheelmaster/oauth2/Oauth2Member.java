package main.wheelmaster.oauth2;

import javax.persistence.*;

import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
public class Oauth2Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String oauthId;

    private String name;

    private String email;


    public Oauth2Member() {}

    @Builder
    public Oauth2Member(Long id, String oauthId, String name, String email) {
        this.id = id;
        this.oauthId = oauthId;
        this.name = name;
        this.email = email;
    }

    public Oauth2Member update(String name, String email) {
        this.name = name;
        this.email = email;
        return this;
    }
}
