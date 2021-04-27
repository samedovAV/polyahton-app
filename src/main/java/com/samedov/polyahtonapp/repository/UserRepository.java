package com.samedov.polyahtonapp.repository;

import com.samedov.polyahtonapp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
