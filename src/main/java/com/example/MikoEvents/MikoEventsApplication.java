package com.example.MikoEvents;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.support.NoOpCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableCaching
public class MikoEventsApplication {

	private static final Logger logger = LoggerFactory.getLogger(MikoEventsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MikoEventsApplication.class, args);
	}

	@Bean
	@Primary
	public CacheManager cacheManager() {
		logger.info("Using NoOpCacheManager - caching is disabled");
		return new NoOpCacheManager(); // Wyłączenie cachowania
	}
}

