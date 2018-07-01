package com.be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(scanBasePackages="com.be")
@PropertySource(value= {"classpath:configuration.properties"})
public class BrokeragePortalBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrokeragePortalBeApplication.class, args);
	}


}
