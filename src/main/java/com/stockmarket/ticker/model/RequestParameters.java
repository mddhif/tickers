package com.stockmarket.ticker.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestParameters {

    private String ticker;
    private String exchange;
    private String market;
    private boolean active;

    private String search;

}
