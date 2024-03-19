package br.com.redesenhe.leap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import static br.com.redesenhe.leap.adapter.constrans.Environment.DEV;
import static br.com.redesenhe.leap.adapter.constrans.Environment.SPRING_PROFILES_ACTIVE;
import static java.lang.System.getenv;
import static java.lang.System.setProperty;
import static java.util.Optional.ofNullable;
import static org.springframework.core.env.AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME;

@EnableFeignClients
@SpringBootApplication
public class LeapApplication {

	public static void main(String[] args) {
		setProperty(ACTIVE_PROFILES_PROPERTY_NAME, ofNullable(getenv(SPRING_PROFILES_ACTIVE)).orElse(DEV));
		SpringApplication.run(LeapApplication.class, args);
	}

}
