package co.com.gestionsitios.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan ({"co.com.gestionsitios.admin.usuario"})
@EntityScan({"co.com.gestionsitios.common.entity"})
@EnableJpaRepositories("co.com.gestionsitios.usuario")

public class GestionSitiosBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionSitiosBackEndApplication.class, args);
	}

}
