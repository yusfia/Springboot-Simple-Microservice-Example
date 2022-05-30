package com.project.gateserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GateserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(GateserverApplication.class, args);
	}

}
