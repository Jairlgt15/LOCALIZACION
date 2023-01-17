package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableJpaAuditing
@EnableWebMvc
@EnableSwagger2

public class LocalizacionApplication extends SpringBootServletInitializer {
	
	@Override
	public SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	    return builder.sources(LocalizacionApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(LocalizacionApplication.class, args);
	}
	


	



}
