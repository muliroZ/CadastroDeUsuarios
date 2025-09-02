package com.muriloscorp.cadastrodeusuarios.repository;

import com.muriloscorp.cadastrodeusuarios.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByNome(String nome);
    Optional<User> findByEmail(String email);
}
