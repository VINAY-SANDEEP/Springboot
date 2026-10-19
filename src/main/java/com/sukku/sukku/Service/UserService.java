package com.sukku.sukku.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.sukku.sukku.Model.User;
import com.sukku.sukku.Repository.UserRepository;

@Service 
public class UserService {
    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }
    public Optional<User> getUser(Long id){
        return repository.findById(id);
    }
    public List<User> getall(){
        return repository.findAll();
    }
    public User create(User user ){
        return repository.save(user);
    }
    public Optional<User> update(Long id,User Updateuser){
        return repository.findById(id).map( user->{
            user.setName(Updateuser.getName());
            user.setVillage(Updateuser.getVillage());
             user.setLoverName(Updateuser.getLoverName());
             return repository.save(user);
        });
    }
    public boolean delete(Long id){
        if(!repository.existsById(id)){
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}
