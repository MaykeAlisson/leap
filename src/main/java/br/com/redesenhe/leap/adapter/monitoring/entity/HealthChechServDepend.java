package br.com.redesenhe.leap.adapter.monitoring.entity;

import org.springframework.boot.actuate.health.Health;

public record HealthChechServDepend(String url, Health health) {
}
