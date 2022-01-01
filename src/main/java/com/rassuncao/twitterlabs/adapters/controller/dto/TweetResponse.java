package com.rassuncao.twitterlabs.adapters.controller.dto;

import com.rassuncao.twitterlabs.core.entities.Tweet;

public class TweetResponse {

    private String message;
    private Long tweetId;
    private Long twitterUserId;
    private String twitterUserName;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTweetId() {
        return tweetId;
    }

    public void setTweetId(Long tweetId) {
        this.tweetId = tweetId;
    }

    public Long getTwitterUserId() {
        return twitterUserId;
    }

    public void setTwitterUserId(Long twitterUserId) {
        this.twitterUserId = twitterUserId;
    }

    public String getTwitterUserName() {
        return twitterUserName;
    }

    public void setTwitterUserName(String twitterUserName) {
        this.twitterUserName = twitterUserName;
    }

    public static TweetResponse valueOf(Tweet tweet) {
        TweetResponse tweetResponse = new TweetResponse();
        tweetResponse.setTweetId(tweet.getTweetId());
        tweetResponse.setMessage(tweet.getMessage());
        tweetResponse.setTwitterUserId(tweet.getTwitterUserId());
        tweetResponse.setTwitterUserName(tweet.getTwitterUserName());
        return tweetResponse;
    }
}
