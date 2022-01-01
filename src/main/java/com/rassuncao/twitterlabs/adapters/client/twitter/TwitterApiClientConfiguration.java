package com.rassuncao.twitterlabs.adapters.client.twitter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Configuration
public class TwitterApiClientConfiguration {

    @Value("${twitter.access-token}")
    private String accessToken;
    @Value("${twitter.access-token-secret}")
    private String accessTokenSecret;
    @Value("${twitter.api-key}")
    private String apiKey;
    @Value("${twitter.api-key-secret}")
    private String apiKeySecret;

    @Bean
    public Twitter twitter() {
        return createTwitterFactory().getInstance();
    }

    private TwitterFactory createTwitterFactory() {
        return new TwitterFactory(createrConfigurationBuilder().build());
    }

    private ConfigurationBuilder createrConfigurationBuilder() {
        return new ConfigurationBuilder()
                .setDebugEnabled(true)
                .setOAuthConsumerKey(apiKey)
                .setOAuthConsumerSecret(apiKeySecret)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessTokenSecret);
    }

}
