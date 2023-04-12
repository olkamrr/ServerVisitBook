package com.olkamrr.servervisitbook.repositories;

import com.olkamrr.servervisitbook.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByLogin(String login);
}
