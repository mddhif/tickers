package com.stockmarket.ticker.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.stockmarket.ticker.entity.Locale;
import com.stockmarket.ticker.entity.Market;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TickerDTO {

    private boolean active;
    private String cik;
    private String composite_figi;
    private String currency_name;
    private String last_updated_utc;

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    private Locale locale;

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    private Market market;

    private String name;

    private String primary_exchange;
    private String share_class_figi;
    private String ticker;
    private String type;

}
