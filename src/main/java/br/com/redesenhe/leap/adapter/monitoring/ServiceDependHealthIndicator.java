package br.com.redesenhe.leap.adapter.monitoring;

import br.com.redesenhe.leap.config.health.HealthCheckEndpointConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.AbstractReactiveHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

@ConditionalOnProperty(prefix = "management.health.servicosDependentes", name = "enabled", havingValue = "true")
@Component
public class ServiceDependHealthIndicator extends AbstractReactiveHealthIndicator {

    private static final Logger LOGGER_TECNICO = LoggerFactory.getLogger(ServiceDependHealthIndicator.class);

    private HealthCheckEndpointConfig healthCheckEndpointConfig;
    private RestTemplate restTemplate;

    @Autowired
    public ServiceDependHealthIndicator(HealthCheckEndpointConfig healthCheckEndpointConfig, RestTemplate restTemplate){
        this.healthCheckEndpointConfig = healthCheckEndpointConfig;
        this.restTemplate = restTemplate;
    }

    /**
     * Implementar quando tiver conexao com outros servicos
     *
     * @return
     */
    @Override
    protected Mono<Health> doHealthCheck(Health.Builder builder) {
//        HealthCheckServDependGeneral servDependGeneral
        return null;
    }
}
