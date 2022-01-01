package com.rassuncao.twitterlabs.adapters.controller;

import com.rassuncao.twitterlabs.adapters.controller.dto.TweetResponse;
import com.rassuncao.twitterlabs.core.services.ListMostCountryInWeek;
import com.rassuncao.twitterlabs.core.services.ListTweetsByHashTag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/twitter-labs")
public class TwitterLabsController {

    private final ListTweetsByHashTag listTweetsByHashTag;
    private final ListMostCountryInWeek listMostCountryInWeek;

    public TwitterLabsController(
            ListTweetsByHashTag listTweetsByHashTag,
            ListMostCountryInWeek listMostCountryInWeek) {
        this.listTweetsByHashTag = listTweetsByHashTag;
        this.listMostCountryInWeek = listMostCountryInWeek;
    }

    @GetMapping("/{hashTag}")
    public List<TweetResponse> listTweetsByHashTag(@PathVariable String hashTag) {
        return listTweetsByHashTag
                .execute(hashTag)
                .stream()
                .map(TweetResponse::valueOf)
                .collect(Collectors.toList());
    }

    @GetMapping("/{hashTag}/{initDate}/{endDate}")
    public Map<String, Long> listTweetsByHashTag(
            @PathVariable String hashTag,
            @PathVariable String initDate,
            @PathVariable String endDate) {
        return listMostCountryInWeek.execute(hashTag, initDate, endDate);
    }

}
