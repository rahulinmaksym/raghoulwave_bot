package org.raghoul.raghoulwavebot.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpotifyWebApiConfig {

    @Value("${raghoulwavebot.config.spotify.client_id}")
    private String clientId;
    @Value("${raghoulwavebot.config.spotify.client_secret}")
    private String clientSecret;
    @Value("${raghoulwavebot.config.spotify.redirect_uri}")
    String redirectUriString;

    @Bean
    public String clientId() {
        return clientId;
    }

    @Bean
    public String clientSecret() {
        return clientSecret;
    }

    @Bean
    public String redirectUriString() {
        return redirectUriString;
    }
}
