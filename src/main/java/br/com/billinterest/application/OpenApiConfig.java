package br.com.billinterest.application;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API bill interest")
                        .description("API to calculate expired bill fees.")
                        .contact(new Contact().name("Bovas").email("tiagaoalb@gmail.com"))
                        .version("1.0.0"));
    }
}
