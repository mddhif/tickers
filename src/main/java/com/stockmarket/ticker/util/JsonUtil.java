package com.stockmarket.ticker.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.stockmarket.ticker.entity.Ticker;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;

@Slf4j
public class JsonUtil {

    public static List<Ticker> getResponse(String str) {


        try {
            log.info("converting string....");
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(str);

            if (jsonNode.has("results")) {
                JsonNode results = jsonNode.get("results");
                log.info("Results: found...");

                CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(List.class, Ticker.class);
                List<Ticker> tickerList = objectMapper.convertValue(results, listType);
                log.info("Ticker list size :{}", tickerList.size());
                return tickerList;
            } else {
                log.info("Key 'results' not found");
                return Collections.emptyList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }
}
