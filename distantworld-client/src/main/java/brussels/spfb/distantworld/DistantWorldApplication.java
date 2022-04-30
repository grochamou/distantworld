package brussels.spfb.distantworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "brussels.spfb.hermes.client" })
public class DistantWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistantWorldApplication.class, args);
	}

}
