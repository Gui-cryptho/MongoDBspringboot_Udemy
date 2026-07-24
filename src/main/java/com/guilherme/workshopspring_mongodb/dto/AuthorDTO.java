package com.guilherme.workshopspring_mongodb.dto;

import com.guilherme.workshopspring_mongodb.domain.User;

import java.io.Serializable;
import java.util.Objects;

public class AuthorDTO implements Serializable {

    private String id;
    private String name;

    public AuthorDTO(){

    }

    public AuthorDTO(User obj) {
        this.id = obj.getId();
        this.name = obj.getName();

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuthorDTO authorDTO)) return false;
        return Objects.equals(getId(), authorDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
