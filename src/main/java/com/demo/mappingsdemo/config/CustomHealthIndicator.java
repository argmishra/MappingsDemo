package com.demo.mappingsdemo.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator implements HealthIndicator {
  @Override
  public Health health() {
    long result = 0L;
    if (result <= 0) {
      return Health.down().withDetail("Something Result", result).build();
    }
    return Health.up().build();
  }
}
