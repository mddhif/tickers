package com.stockmarket.ticker.mapper;


import com.stockmarket.ticker.dto.TickerDTO;
import com.stockmarket.ticker.entity.Ticker;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TickerMapper {

    TickerMapper INSTANCE = Mappers.getMapper(TickerMapper.class);

    TickerDTO toDTO(Ticker ticker);
    Ticker toEntity(TickerDTO dto);
}