package com.github.maikoncanuto.quotes.core.healthcheck;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

import javax.enterprise.context.ApplicationScoped;


@Readiness
@ApplicationScoped
public class ReadinessHealthCheckConfig implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.named("Serviço pronto").up().build();
    }
}
