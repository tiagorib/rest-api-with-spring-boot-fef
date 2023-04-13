package br.com.fefproject.FefProjectApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition (info = @Info(title = "Rest API FEF", description = "FEF") )
public class FefProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FefProjectApplication.class, args);
	}

}
