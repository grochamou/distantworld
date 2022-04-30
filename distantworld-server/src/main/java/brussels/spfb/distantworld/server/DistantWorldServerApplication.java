package brussels.spfb.distantworld.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "brussels.spfb.distantworld.controller" })
public class DistantWorldServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistantWorldServerApplication.class, args);
	}

}
