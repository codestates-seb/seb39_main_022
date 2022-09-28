package main.wheelmaster.oauth2;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Oauth2MemberRepository extends JpaRepository<Oauth2Member, Long> {
    Optional<Oauth2Member> findByOauthId(String id);
}
