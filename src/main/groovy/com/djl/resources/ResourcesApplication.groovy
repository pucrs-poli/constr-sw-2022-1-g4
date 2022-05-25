package com.djl.resources

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@EnableMongoRepositories
class ResourcesApplication {

	static void main(String[] args) {
		SpringApplication.run(ResourcesApplication, args)
	}

}
