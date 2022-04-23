package com.jld.keycloackapi.domain.data;

import org.springframework.data.annotation.Id;
public class UserEntity {

    @Id
    private String id;
    private String authorName;
    private String title;

    public UserEntity(String authorName, String title) {
        this.authorName = authorName;
    }

}
