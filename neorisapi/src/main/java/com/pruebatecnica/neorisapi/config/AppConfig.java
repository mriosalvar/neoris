package com.pruebatecnica.neorisapi.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.pruebatecnica.neorisapi.repository")
@EntityScan("com.pruebatecnica.neorisapi.model")
public class AppConfig {

}
