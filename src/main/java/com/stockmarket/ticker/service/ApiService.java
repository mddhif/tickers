package com.stockmarket.ticker.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stockmarket.ticker.entity.Ticker;
import com.stockmarket.ticker.exception.CustomException;
import com.stockmarket.ticker.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class ApiService {

    @Value("${server.url}")
    private String serverUrl;

    public List<Ticker> requestData(String ticker, String exchange, String market, boolean active, String search) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(serverUrl)
                .queryParam("ticker", ticker)
                .queryParam("exchange", exchange)
                .queryParam("market", market)
                .queryParam("active", active)
                .queryParam("search", search)
                .queryParam("limit", 500)
                .queryParam("apiKey", System.getenv("API_KEY"));


        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response =  restTemplate.getForEntity(builder.toUriString(), String.class);

        log.info("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        log.info(response.getStatusCode().toString());
        log.info("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        if (response.getStatusCode().is2xxSuccessful()) {
            log.info("Data retrieval successful...");
            return JsonUtil.getResponse(response.getBody());
        } else {
            log.error("Data retrieval failed due to error...Status code :{}", response.getStatusCode());

        }

        return Collections.emptyList();
    }
}
