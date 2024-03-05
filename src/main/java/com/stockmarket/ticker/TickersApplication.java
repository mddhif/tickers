package com.stockmarket.ticker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class TickersApplication {

	public static void main(String[] args) {
		SpringApplication.run(TickersApplication.class, args);
	}

}
