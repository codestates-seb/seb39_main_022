package main.wheelmaster.oauth2;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(OauthProperties.class)
public class OauthConfig {

    private final OauthProperties oauthProperties;


    @Bean
    public InMemoryProviderRepository inMemoryProviderRepository(){
        Map<String, OauthProvider> providers = OauthAdapter.getOauthProviders(oauthProperties);
        return new InMemoryProviderRepository(providers);
    }
}
