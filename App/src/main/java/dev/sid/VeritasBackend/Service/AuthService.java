package dev.sid.VeritasBackend.Service;

import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.sid.VeritasBackend.DTO.Auth.SignupDTO;
import dev.sid.VeritasBackend.Entities.Users;
import dev.sid.VeritasBackend.Mapper.AuthMapper;

import dev.sid.VeritasBackend.Repositories.AuthRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;
    private final AuthMapper authMapper;
    private final PasswordEncoder passwordEncoder;

    public void registerUser(SignupDTO signupDTO) {
        Users user = authMapper.signupDTOToUser(signupDTO);
        user.setPassword(passwordEncoder.encode(signupDTO.password()));

        authRepository.save(user);
    }

    public Users getUserById(UUID userId) {
        return authRepository.findById(userId).orElse(null);
    }

    public void deleteUser(UUID userId) {
        authRepository.deleteById(userId);
    }

    public void deleteAllUsers() {
        authRepository.deleteAll();
    }
}
