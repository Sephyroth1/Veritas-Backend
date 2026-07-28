package dev.sid.VeritasBackend.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import dev.sid.VeritasBackend.DTO.Auth.LoginDTO;
import dev.sid.VeritasBackend.DTO.Auth.SignupDTO;
import dev.sid.VeritasBackend.Entities.Roles;
import dev.sid.VeritasBackend.Service.AuthService;
import dev.sid.VeritasBackend.shared.Role;
import tools.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class AuthControllerIT {
  @Autowired
  private MockMvc mockMvc;

  // @Autowired
  // private AuthController authController;

  @Autowired
  private AuthService authService;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private ObjectMapper objectMapper;

  @BeforeEach
  void setup() {
    authService.deleteAllUsers();
  }

  @Test
  void signupShouldCreateUser() throws Exception {
    Roles r = new Roles();
    r.setRole(Role.EMPLOYEE);
    SignupDTO signupDTO = new SignupDTO("John", "password", "john@example.com", r);
    mockMvc.perform(post("/api/auth/signup").contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(signupDTO))).andExpect(status().isCreated());
  }

  @Test
  void loginShouldReturnToken() throws Exception {
    Roles r = new Roles();
    r.setRole(Role.EMPLOYEE);
    SignupDTO signupDTO = new SignupDTO(
        "john",
        "password", "john@example.com", r);

    authService.registerUser(signupDTO);
    r = new Roles();
    r.setRole(Role.EMPLOYEE);
    LoginDTO loginDTO = new LoginDTO("john", "password");
    mockMvc.perform(post("/api/auth/login").contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(loginDTO))).andExpect(status().isOk())
        .andExpect(jsonPath("$.token").isNotEmpty())
        .andExpect(jsonPath("$.token").exists());
  }
}
