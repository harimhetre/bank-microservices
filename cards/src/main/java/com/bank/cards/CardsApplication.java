package com.bank.cards;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Cards Microservice",
                description = "REST API's for cards microservice",
                version = "v1",
                contact =  @Contact (
                        name = "Hari Mhetre",
                        email = "hari.mhetre@gmail.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "hari.mhetre.com"
                )
        )
)
public class CardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
	}

}
