package com.p1.voting.config;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class JpaAuditingConfig {

	@Bean
	public AuditorAware<Long> auditorProvider() {
		return () -> Optional.ofNullable(1L);
	}
}
