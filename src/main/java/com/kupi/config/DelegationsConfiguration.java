package com.kupi.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.util.IdGenerator;
import org.springframework.util.JdkIdGenerator;

import java.time.Clock;

@Configuration
@EnableJpaRepositories("com.kupi.persistence.repository")
@EntityScan("com.kupi.persistence.entity")
@ComponentScan(basePackages = {"com.kupi.persistence", "com.kupi.rest.api", "com.kupi.service"})
public class DelegationsConfiguration {

    @Bean
    public Clock utcClock() {
        return Clock.systemUTC();
    }

    @Bean
    public IdGenerator jdkIdGenerator() {
        return new JdkIdGenerator();
    }
}
