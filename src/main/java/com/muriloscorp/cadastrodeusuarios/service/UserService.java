package com.muriloscorp.cadastrodeusuarios.service;

import com.muriloscorp.cadastrodeusuarios.exceptions.EmailAlreadyExistsException;
import com.muriloscorp.cadastrodeusuarios.model.User;
import com.muriloscorp.cadastrodeusuarios.repository.UserRepository;
import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public User criarUser(@Nonnull User user) {
        if (user.getNome().isEmpty() || user.getEmail().isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (userRepository.existsUserByEmail(user.getEmail())) {
            throw new EmailAlreadyExistsException();
        }
        return userRepository.save(user);
    }

    public List<User> buscarTodos() {
        return userRepository.findAll();
    }

    public Optional<User> buscarPorNome(String nome) {
        return userRepository.findByNome(nome);
    }

    public Optional<User> buscarPorEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
