package com.rassuncao.twitterlabs.core.services;

import com.rassuncao.twitterlabs.core.ports.TwitterApiClient;

import java.util.Map;

public class ListMostCountryInWeek {

    private final TwitterApiClient twitterApiClient;

    public ListMostCountryInWeek(TwitterApiClient twitterApiClient) {
        this.twitterApiClient = twitterApiClient;
    }

    public Map<String, Long> execute(String hashTag, String initDate, String endDate) {
        return twitterApiClient.listMostCountryInWeek(hashTag, initDate, endDate);
    }
}
