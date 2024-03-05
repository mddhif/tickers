package com.stockmarket.ticker.controller;

import com.stockmarket.ticker.dto.TickerDTO;
import com.stockmarket.ticker.entity.Ticker;
import com.stockmarket.ticker.mapper.TickerMapper;
import com.stockmarket.ticker.model.RequestParameters;
import com.stockmarket.ticker.service.ApiService;
import com.stockmarket.ticker.service.TickerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class TickerController {

    @Autowired
    private TickerService tickerService;

    private ModelMapper modelMapper = new ModelMapper();

    @PostMapping("/tickers")
    public ResponseEntity<List<TickerDTO>> retrieveTickers(@RequestBody RequestParameters requestParameters) {

       return ResponseEntity.ok(tickerService
               .retrieveTickers(requestParameters)
               .stream()
               .map(ticker -> modelMapper.map(ticker, TickerDTO.class))
               .collect(Collectors.toList()));



      //  return ResponseEntity.ok(tickerService.retrieveTickers(requestParameters));

    }


}
