package com.rassuncao.twitterlabs.core.entities;

public class Tweet {

    private Long id;
    private String message;
    private Long tweetId;
    private Long twitterUserId;
    private String twitterUserName;

    public Tweet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tweet)) return false;

        Tweet tweet = (Tweet) o;

        if (getId() != null ? !getId().equals(tweet.getId()) : tweet.getId() != null) return false;
        if (getMessage() != null ? !getMessage().equals(tweet.getMessage()) : tweet.getMessage() != null) return false;
        if (getTweetId() != null ? !getTweetId().equals(tweet.getTweetId()) : tweet.getTweetId() != null) return false;
        if (getTwitterUserId() != null ? !getTwitterUserId().equals(tweet.getTwitterUserId()) : tweet.getTwitterUserId() != null)
            return false;
        return getTwitterUserName() != null ? getTwitterUserName().equals(tweet.getTwitterUserName()) : tweet.getTwitterUserName() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getMessage() != null ? getMessage().hashCode() : 0);
        result = 31 * result + (getTweetId() != null ? getTweetId().hashCode() : 0);
        result = 31 * result + (getTwitterUserId() != null ? getTwitterUserId().hashCode() : 0);
        result = 31 * result + (getTwitterUserName() != null ? getTwitterUserName().hashCode() : 0);
        return result;
    }
}
