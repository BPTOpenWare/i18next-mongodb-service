package com.bptopenware.messages;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.bptopenware", "com.bptopenware.api"})
public class MessagesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessagesApplication.class, args);
	}

}
