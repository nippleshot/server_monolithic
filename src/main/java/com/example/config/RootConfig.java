package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import com.example.config.RootConfig.WebPackage;

import java.util.regex.Pattern;

@Configuration
@Import({DataConfig.class, CacheConfig.class})
@ComponentScan(basePackages = {"com.example"},
        excludeFilters = {
                @Filter(type = FilterType.CUSTOM, value = WebPackage.class)
        })
public class RootConfig {
    public static class WebPackage extends RegexPatternTypeFilter {
        // Scan every package under com.example except com.example.web
        // (com.example.web gonna be scanned by WebConfig.java)
        public WebPackage() {
            super(Pattern.compile("com.example\\.web"));
        }
    }
}