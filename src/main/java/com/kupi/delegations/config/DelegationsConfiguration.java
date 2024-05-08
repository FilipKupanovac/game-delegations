package com.kupi.delegations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.util.IdGenerator;
import org.springframework.util.JdkIdGenerator;

import java.time.Clock;
import java.util.Optional;

@EnableJpaAuditing(dateTimeProviderRef = "customDateTimeProvider")
@EnableAspectJAutoProxy
@Configuration
public class DelegationsConfiguration {

    @Bean
    public Clock utcClock() {
        return Clock.systemUTC();
    }

    @Bean
    public DateTimeProvider customDateTimeProvider(Clock clock) {
        return () -> Optional.of(clock.instant());
    }

    @Bean
    public IdGenerator jdkIdGenerator() {
        return new JdkIdGenerator();
    }
}
