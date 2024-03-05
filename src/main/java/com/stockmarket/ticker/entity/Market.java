package com.stockmarket.ticker.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Market {

    //@JsonProperty("stocks")
    STOCKS("stocks"),

    //@JsonProperty("crypto")
    CRYPTO("crypto"),

    //@JsonProperty("fx")
    FX("fx"),

    //@JsonProperty("otc")
    OTC("otc"),

    //@JsonProperty("indices")
    INDICES("indices");
    private final String value;

    Market(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
