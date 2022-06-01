package com.djl.resources.infrastructure.config

import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.client.MongoClient
import org.springframework.context.annotation.Bean
import org.springframework.data.mongodb.core.MongoTemplate

class MongoConfig {

    @Bean
    MongoClient mongo() {
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

    @Bean
    MongoTemplate mongoTemplate(final String db) throws Exception {
        return new MongoTemplate(mongo(), db);
    }
}