package com.rassuncao.twitterlabs.adapters.client.twitter;

import com.rassuncao.twitterlabs.core.entities.Tweet;
import com.rassuncao.twitterlabs.core.ports.TwitterApiClient;
import org.springframework.stereotype.Service;
import twitter4j.Query;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TwitterApiClientImpl implements TwitterApiClient {

    private final Twitter twitter;

    public TwitterApiClientImpl(Twitter twitter) {
        this.twitter = twitter;
    }

    @Override
    public List<Tweet> listTweetsByHashTag(String hashTag) {
        validateHashTag(hashTag);
        Query query = new Query(hashTag);
        query.count(100);
        try {
            return twitter.search(query)
                    .getTweets()
                    .parallelStream()
                    .map(this::tweetFromStatus)
                    .collect(Collectors.toList());
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return List.of();
    }

    @Override
    public Map<String, Long> listMostCountryInWeek(String hashTag, String initDate, String endDate) {
        Query query = new Query(hashTag);
        query.count(100);
        query.setSince(initDate);
        query.setUntil(endDate);
        try {
            return twitter.search(query)
                    .getTweets()
                    .parallelStream()
                    .filter(status -> status.getUser().getLocation().contains(","))
                    .map(status -> status.getUser().getLocation().split(",")[1].trim())
                    .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return Map.of();
    }

    private void validateHashTag(String hashTag) {
        if(!hashTag.startsWith("#")) hashTag = new StringBuilder("#").append(hashTag).toString();
    }

    private Tweet tweetFromStatus(Status status) {
        Tweet tweet = new Tweet();
        tweet.setTweetId(status.getId());
        tweet.setMessage(status.getText());
        tweet.setTwitterUserId(status.getUser().getId());
        tweet.setTwitterUserName(status.getUser().getName());
        return tweet;
    }
}
