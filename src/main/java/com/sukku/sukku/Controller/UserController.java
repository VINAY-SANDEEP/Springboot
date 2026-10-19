package com.sukku.sukku.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.sukku.sukku.Model.User;
import com.sukku.sukku.Service.UserService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;





@RestController 
@RequestMapping("/api")
public class UserController {
    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user){
        User saved = service.create(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
    @GetMapping
    public List<User> getall(){
        return service.getall();
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getone(@PathVariable Long id){
        return service.getUser(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id ,@RequestBody User user){
        return  service.update(id, user).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable  Long id){
        boolean delete = service.delete(id);
        if(!delete){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
    
}
