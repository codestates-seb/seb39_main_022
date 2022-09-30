package main.wheelmaster.oauth2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Oauth2MemberRepository extends JpaRepository<Oauth2Member, Long> {
    Optional<Oauth2Member> findByOauthId(String id);
}
