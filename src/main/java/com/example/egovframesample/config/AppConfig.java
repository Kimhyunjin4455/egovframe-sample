package com.example.egovframesample.config;

import org.egovframe.rte.fdl.cmmn.trace.LeaveaTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public LeaveaTrace leaveaTrace() {
        return new LeaveaTrace();
    }
}
