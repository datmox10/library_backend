package com.example.library.repository;

import com.example.library.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    UserEntity findAllByUserName(String userName);
    Boolean existsByUserName(String userName);
    List<UserEntity> findAllByEmail(String email);
}
