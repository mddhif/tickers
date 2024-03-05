package com.stockmarket.ticker.service;

import com.stockmarket.ticker.entity.Ticker;
import com.stockmarket.ticker.mapper.TickerMapper;
import com.stockmarket.ticker.model.RequestParameters;
import com.stockmarket.ticker.repository.TickerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TickerService {

    @Autowired
    private ApiService apiService;

    public List<Ticker> retrieveTickers(RequestParameters requestParameters) {

        log.info("retrieving tickers from server....");

        return apiService
                .requestData(requestParameters.getTicker(),
                        requestParameters.getExchange(),
                        requestParameters.getMarket(),
                        requestParameters.isActive(),
                        requestParameters.getSearch());
    }
}
