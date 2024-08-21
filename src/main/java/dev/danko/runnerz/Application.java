package dev.danko.runnerz;

import dev.danko.runnerz.Run.Location;
import dev.danko.runnerz.Run.Run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


@SpringBootApplication
public class Application {

	public static Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			Run run = new Run(123,"SchoolRun", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS),5,Location.OUTDOOR);
			logger.info("Run: " + run );
		};
	}
}
