package com.muriloscorp.cadastrodeusuarios.service;

import com.muriloscorp.cadastrodeusuarios.model.User;
import com.muriloscorp.cadastrodeusuarios.repository.UserRepository;
import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public User criarUser(@Nonnull User user) {
        if (user.getNome().isEmpty() || user.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Nome e email são obrigatórios.");
        }
        return userRepository.save(user);
    }

    public Optional<User> buscarPorNome(String nome) {
        return userRepository.findByNome(nome);
    }

    public Optional<User> buscarPorEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
