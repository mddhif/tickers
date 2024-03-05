package com.stockmarket.ticker.repository;

import com.stockmarket.ticker.entity.Ticker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TickerRepository extends JpaRepository<Ticker, Long> {
}
