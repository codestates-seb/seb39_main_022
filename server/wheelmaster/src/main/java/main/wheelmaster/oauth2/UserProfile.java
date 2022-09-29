package main.wheelmaster.oauth2;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserProfile {
    private final String oauthId;
    private final String email;
    private final String name;

    @Builder
    public UserProfile(String oauthId, String email, String name) {
        this.oauthId = oauthId;
        this.email = email;
        this.name = name;
    }

    public Oauth2Member toMember() {
        return Oauth2Member.builder()
                .oauthId(oauthId)
                .email(email)
                .name(name)
                .build();
    }
}