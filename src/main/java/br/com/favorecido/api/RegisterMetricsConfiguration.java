package br.com.favorecido.api;

import javax.annotation.PostConstruct;

import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Metrics;

@Configuration
@EnableAspectJAutoProxy
public class RegisterMetricsConfiguration {

	public static Counter counter;
	
	@PostConstruct 
	public void init(){
		counter = Metrics.counter("consulta.por.cnpj.cpf.cliente", "type", "order");
		counter = Metrics.counter("incluir.favorecido", "type", "order");
	}
	
	@Bean
    MeterRegistryCustomizer<MeterRegistry> metricsCommonTags() {
        return registry -> {
            registry.config().commonTags("application", "favorecidos-api");
        };
    }
}
