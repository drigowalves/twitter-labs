package com.rassuncao.twitterlabs.core.services;

import com.rassuncao.twitterlabs.core.entities.Tweet;
import com.rassuncao.twitterlabs.core.ports.TwitterApiClient;

import java.util.List;

public class ListTweetsByHashTag {

    private final TwitterApiClient twitterApiService;

    public ListTweetsByHashTag(TwitterApiClient twitterApiService) {
        this.twitterApiService = twitterApiService;
    }

    public List<Tweet> execute(String hashTag) {
        return twitterApiService.listTweetsByHashTag(hashTag);
    }

}
