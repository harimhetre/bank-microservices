package com.bank.loans;

import com.bank.loans.dto.LoansContactInfoDto;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableConfigurationProperties(value = LoansContactInfoDto.class)
@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
        info = @Info(
                title = "Loans microservices",
                description = "Loans microservices REST API documentation",
                version = "v1",
                contact = @Contact(
                        name = "Hari Mhetre",
                        email = "hari.mhetre22@gmail.com",
                        url = "hari.mhetre.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "hari.mhetre.com"
                )
        )
)
public class LoansApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoansApplication.class, args);
	}

}
