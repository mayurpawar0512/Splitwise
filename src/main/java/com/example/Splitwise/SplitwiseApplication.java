package com.example.Splitwise;

import com.example.Splitwise.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SplitwiseApplication implements CommandLineRunner {

	@Autowired
	private InitService initService;

	public static void main(String[] args) {
		SpringApplication.run(SplitwiseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("In a run method of SplitwiseApplication");
		initService.initialise();
	}
}
