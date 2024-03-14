package br.com.redesenhe.leap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class LeapApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeapApplication.class, args);
	}

}
