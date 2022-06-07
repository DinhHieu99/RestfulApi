package com.example.RestfulApi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartServer implements CommandLineRunner {

	@Value("${server.port}") private Integer port;

	public void run(String... args) throws Exception {
		System.out.println("-------------------CODE EXECUTE---------------");
		System.out.println("--------------------- " + port);
	}

	public static void main(String[] args) {
		SpringApplication.run(StartServer.class, args);
	}


}
