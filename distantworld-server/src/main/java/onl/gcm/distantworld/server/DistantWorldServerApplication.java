package onl.gcm.distantworld.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "onl.gcm.distantworld.controller" })
public class DistantWorldServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistantWorldServerApplication.class, args);
	}

}
