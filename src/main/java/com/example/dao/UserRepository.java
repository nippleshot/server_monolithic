package com.example.dao;

import com.example.domain.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

     @Cacheable("userCache")
     User findUserByUserName(String userName);
}
