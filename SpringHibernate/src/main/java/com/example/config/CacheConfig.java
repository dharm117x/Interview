package com.example.config;

import java.util.Collections;
import java.util.Set;

import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@EnableCaching
@Configuration
public class CacheConfig {

	@Primary
	@Bean("cacheManager")
	public CompositeCacheManager cacheManager() {
		CompositeCacheManager compositeCacheManager = new CompositeCacheManager();
		compositeCacheManager.setFallbackToNoOpCache(true);
		compositeCacheManager.setCacheManagers(Collections.singleton(ehCacheManager()));
		return compositeCacheManager;
	}

	@Bean
	public CacheManager ehCacheManager() {
		SimpleCacheManager cacheManager = new SimpleCacheManager();
		cacheManager.setCaches(Set.of(new ConcurrentMapCache("default")));
		return cacheManager;
	}

}