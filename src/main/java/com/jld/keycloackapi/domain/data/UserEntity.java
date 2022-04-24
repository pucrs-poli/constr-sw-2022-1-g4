package com.jld.keycloackapi.domain.data;

public class UserEntity {

    private String id;
    private String authorName;
    private String title;

    public UserEntity(String authorName, String title) {
        this.authorName = authorName;
    }

}
