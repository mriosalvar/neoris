package com.pruebatecnica.neorisapi.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan("com.pruebatecnica.neorisapi.model")
public class AppConfig {

}
