package com.whoosh_backend.Whoosh_Backend.data.repository;

import com.whoosh_backend.Whoosh_Backend.data.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
    User findByEmail(String email);

}
