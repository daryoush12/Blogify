package com.project.Blogify;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory.*;

import com.project.Blogify.domain.*;
import com.project.Blogify.storage.*;
@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class BlogifyApplication  extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder
	application) {
	return application.sources(BlogifyApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BlogifyApplication.class, args);
	}
	
	//Test users added via commandlinerunner:
	@Bean
	public CommandLineRunner UserToAdded(UserRepository urepository, StorageService storageService) {
		return (args) -> {
			//Test users for db:
//			System.out.println("DATABASE ACTION: Adding test users:");
//			User user1 = new User("user","$2a$04$5I5PlB8atlxa19Nx0Xng2.jkQAbO4tVrJc1pn6rdh7UR2wgzETawC","USER", "Jonathan", "James");
//			User user2 = new User("admin","$2a$04$5I5PlB8atlxa19Nx0Xng2.jkQAbO4tVrJc1pn6rdh7UR2wgzETawC","ADMIN","Jack","Bauer");
//			urepository.save(user1);
//			urepository.save(user2);
			//DeleteAll method resets our image folder:
			// storageService.deleteAll();
			//Initiate storageservice:
	        storageService.init();
			};
	}
}

