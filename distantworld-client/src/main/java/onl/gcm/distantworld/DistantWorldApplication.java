package onl.gcm.distantworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "onl.gcm.hermes.client" })
public class DistantWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistantWorldApplication.class, args);
	}

}
