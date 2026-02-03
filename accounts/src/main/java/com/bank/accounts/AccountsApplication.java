package com.bank.accounts;

import com.bank.accounts.dto.AccountContactInfoDto;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = AccountContactInfoDto.class)
@OpenAPIDefinition(
        info = @Info(
                title = "Accounts microservice REST API documentation",
                description = "My bank accounts microservice REST API documentation",
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
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
