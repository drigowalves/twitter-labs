package com.rassuncao.twitterlabs.core.ports;

import com.rassuncao.twitterlabs.core.entities.Tweet;

import java.util.List;
import java.util.Map;

public interface TwitterApiClient {

    public List<Tweet> listTweetsByHashTag(String hashTag);

    public Map<String, Long> listMostCountryInWeek(String hashTag, String initDate, String endDate);

}
