/*
 * Login and Signup are dealt with here, specifically we have Login and Signup
 * endpoints
 * and also we use LoginDTO and SignupDTO to validate the login and signup
 * requests.
 *
 */

package dev.sid.VeritasBackend.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import dev.sid.VeritasBackend.DTO.Auth.LoginDTO;
import dev.sid.VeritasBackend.DTO.Auth.SignupDTO;
import dev.sid.VeritasBackend.DTO.Auth.AuthResponseDTO;
// import dev.sid.VeritasBackend.Security.CustomUserDetailsService;
import dev.sid.VeritasBackend.Security.JwtService;
import dev.sid.VeritasBackend.Service.AuthService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    // private final CustomUserDetailsService customUserDetailsService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    // Post endpoints for login and signup, use AuthMapper for mapping DTOs to
    // entities
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDTO loginDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.username(), loginDTO.password()));
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = jwtService.generateToken(userDetails);
        return ResponseEntity.ok(new AuthResponseDTO(token));
    }

    @PostMapping("/signup")
    public ResponseEntity<Void> signup(@RequestBody SignupDTO signupDTO) {
        authService.registerUser(signupDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
