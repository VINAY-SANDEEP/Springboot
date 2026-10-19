package com.sukku.sukku.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sukku.sukku.Model.User;

public interface UserRepository extends JpaRepository<User,Long>{
    
}
