package com.stacksmplify.restservices.sprngbootbuildingblocks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("Iniciando el proyecto! :D");
		SpringApplication.run(DemoApplication.class, args);
	}

}
