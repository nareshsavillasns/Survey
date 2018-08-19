package com.survey.app.config;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.survey.app.util.FileStorageProperties;

@SpringBootApplication(exclude = {BatchAutoConfiguration.class})
@ComponentScan({"com.survey.app.*"})
@EnableJpaRepositories(basePackages ={"com.survey.app*"})
@EntityScan("com.survey.app*")
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class PollsApplication {

	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	public static void main(String[] args) {
		SpringApplication.run(PollsApplication.class, args);
	}
}
