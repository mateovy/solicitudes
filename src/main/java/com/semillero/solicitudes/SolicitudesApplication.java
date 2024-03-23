package com.semillero.solicitudes;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.semillero.solicitudes.persistence.entities")
@EnableJpaRepositories("com.semillero.solicitudes.persistence.repositories")
@ComponentScan(basePackages = { "com.semillero.solicitudes" })
public class SolicitudesApplication {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SolicitudesApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}
}

