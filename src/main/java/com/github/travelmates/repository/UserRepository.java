package com.github.travelmates.repository;

import com.github.travelmates.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
