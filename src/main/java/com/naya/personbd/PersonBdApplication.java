package com.naya.personbd;

import com.naya.personbd.services.MyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.ControllerAdvice;

@SpringBootApplication
public class PersonBdApplication {

	@Bean
	public MyService myService(){
		return new MyService();
	}


	public static void main(String[] args) {
		SpringApplication.run(PersonBdApplication.class, args);
	}
}
