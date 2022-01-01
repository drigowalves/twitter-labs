package com.rassuncao.twitterlabs.adapters.service;

import com.rassuncao.twitterlabs.adapters.client.twitter.TwitterApiClientImpl;
import com.rassuncao.twitterlabs.core.services.ListTweetsByHashTag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationListTweetsByHashTag {

    private final TwitterApiClientImpl twitterApiClient;

    public ConfigurationListTweetsByHashTag(TwitterApiClientImpl twitterApiClient) {
        this.twitterApiClient = twitterApiClient;
    }

    @Bean
    public ListTweetsByHashTag listTweetsByHashTag() {
        return new ListTweetsByHashTag(twitterApiClient);
    }

}
