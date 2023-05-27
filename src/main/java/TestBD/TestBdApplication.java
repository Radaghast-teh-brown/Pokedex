package TestBD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"TestBD.controller", "TestBD.model","TestBD.repositoy","TestBD.service"})
public class TestBdApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestBdApplication.class, args);
	}

}
