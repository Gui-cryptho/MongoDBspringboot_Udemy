package com.guilherme.workshopspring_mongodb.services;

import com.guilherme.workshopspring_mongodb.domain.User;
import com.guilherme.workshopspring_mongodb.dto.UserDTO;
import com.guilherme.workshopspring_mongodb.repositories.UserRepositorie;
import com.guilherme.workshopspring_mongodb.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepositorie userRepositorie;

    public List<User> findAll(){
        List<User> obj = userRepositorie.findAll();

        return obj;
    }

    public User findById(String id){
        Optional<User> obj = userRepositorie.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException("Obejeto não encontrado"));
    }

    public User post(User obj){
        return userRepositorie.insert(obj);
    }

    public void deleteById(String id){
        findById(id);
        userRepositorie.deleteById(id);
    }

    public User put(User obj){
        User newObj = findById(obj.getId());
        updateData(newObj, obj);
        return userRepositorie.save(newObj);

    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO objDTO){
        return new User(objDTO.getId(), objDTO.getNome(), objDTO.getEmail());
    }

}
