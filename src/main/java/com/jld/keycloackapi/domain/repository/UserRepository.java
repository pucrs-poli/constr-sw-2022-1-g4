package com.jld.keycloackapi.domain.repository;


import com.jld.keycloackapi.domain.data.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface UserRepository extends MongoRepository<UserEntity,String> {


}
