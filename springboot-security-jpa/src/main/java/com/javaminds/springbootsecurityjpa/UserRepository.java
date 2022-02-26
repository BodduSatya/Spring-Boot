package com.javaminds.springbootsecurityjpa;

import com.javaminds.springbootsecurityjpa.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository {
    Optional<User> findByUserName(String userName);
}
