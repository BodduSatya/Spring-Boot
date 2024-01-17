package com.javaminds.springbootiq.jpa.Repository;

import com.javaminds.springbootiq.modal.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    List<User> findByRole(String role);
}
