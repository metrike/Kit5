package fr.projet.kitcinq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableConfigurationProperties
public class KitcinqApplication {

	public static void main(String[] args) {
		SpringApplication.run(KitcinqApplication.class, args);
	}

}
