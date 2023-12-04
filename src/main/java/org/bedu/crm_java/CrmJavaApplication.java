package org.bedu.crm_java;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrmJavaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CrmJavaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Iniciado proyecto CRM");
	}

}
