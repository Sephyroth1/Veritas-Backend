package dev.sid.VeritasBackend.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import dev.sid.VeritasBackend.Security.JwtService;
import io.jsonwebtoken.Claims;

public class jwtUtilsTest {
    private JwtService jwtService;
    private UserDetails userDetails;
    private String jwt;

    @BeforeEach
    public void setUp() {
        this.jwt = "0Jc346wYxJfRdzmg4CchYEVxboRDt92FpRJeFItU9WJ";
        jwtService = new JwtService(this.jwt, 1000 * 60 * 60);
        this.userDetails = User.builder().username("test").password("test").roles("EMPLOYEE").build();
    }

    @Test
    void shouldGenerateValidToken() {
        String token = jwtService.generateToken(this.userDetails);
        assertNotNull(token);
        assertTrue(jwtService.isTokenValid(token, userDetails));
    }

    @Test
    void tokenContainsUsername() {
        String token = jwtService.generateToken(this.userDetails);
        assertNotNull(token);
        String username = jwtService.extractUsername(token);
        assertNotNull(username);
        assertTrue(username.equals(this.userDetails.getUsername()));
    }

    @SuppressWarnings("unchecked")

    @Test
    void tokenContainsRolesClaim() {
        String token = jwtService.generateToken(this.userDetails);
        assertNotNull(token);
        Claims claims = jwtService.extractAllClaims(token);
        assertNotNull(claims);
        assertNotNull(claims.getIssuedAt());
        assertNotNull(claims.getExpiration());
        assertEquals("test", claims.getSubject());
        List<String> role = (List<String>) claims.get("roles");
        assertTrue(role.contains("ROLE_EMPLOYEE"));
    }

    @Test
    void tokenExpirationTimestampIsCorrect() {
        String token = jwtService.generateToken(this.userDetails);
        assertNotNull(token);
        Claims claims = jwtService.extractAllClaims(token);
        assertNotNull(claims);
        assertNotNull(claims.getIssuedAt());
        assertNotNull(claims.getExpiration());
        assertEquals("test", claims.getSubject());
        Long expirationTimestamp = claims.getExpiration().getTime();
        Long issuedTimestamp = claims.getIssuedAt().getTime();
        assertEquals(expirationTimestamp, issuedTimestamp + jwtService.getJwtExpiration());
    }
}
