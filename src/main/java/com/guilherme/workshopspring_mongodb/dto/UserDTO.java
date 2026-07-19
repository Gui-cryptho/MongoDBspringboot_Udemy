package com.guilherme.workshopspring_mongodb.dto;

import com.guilherme.workshopspring_mongodb.domain.User;

import java.io.Serializable;
import java.util.Objects;

public class UserDTO implements Serializable {

    private String id;
    private String nome;
    private String email;

    public UserDTO(){

    }

    public UserDTO(User obj){
        this.id = obj.getId();
        this.nome = obj.getName();
        this.email = obj.getEmail();

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDTO userDTO)) return false;
        return Objects.equals(getId(), userDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
