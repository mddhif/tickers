package com.stockmarket.ticker.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Locale {

    US("us"),
   // @JsonProperty("global")
    GLOBAL("global");

    private final String value;

    Locale(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
