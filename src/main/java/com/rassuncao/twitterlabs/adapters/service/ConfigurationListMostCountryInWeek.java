package com.rassuncao.twitterlabs.adapters.service;

import com.rassuncao.twitterlabs.adapters.client.twitter.TwitterApiClientImpl;
import com.rassuncao.twitterlabs.core.services.ListMostCountryInWeek;
import com.rassuncao.twitterlabs.core.services.ListTweetsByHashTag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationListMostCountryInWeek {

    private final TwitterApiClientImpl twitterApiClient;

    public ConfigurationListMostCountryInWeek(TwitterApiClientImpl twitterApiClient) {
        this.twitterApiClient = twitterApiClient;
    }

    @Bean
    public ListMostCountryInWeek listMostCountryInWeek() {
        return new ListMostCountryInWeek(twitterApiClient);
    }

}
