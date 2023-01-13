package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableJpaAuditing
@EnableWebMvc
public class LocalizacionApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(LocalizacionApplication.class, args);
	}
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	    return builder.sources(LocalizacionApplication.class);
	}
}
