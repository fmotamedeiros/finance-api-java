package br.com.cpsoftware.finance.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.util.Date;
import org.springframework.stereotype.Service;

@Service
public class JwtUtil {

    private String secret = "mySecretKey";

    public String generateToken(String username) {
        Algorithm algorithm = Algorithm.HMAC256("secret");
        String token = JWT.create()
                .withIssuer("auth0")
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + 3600 * 1000)) // 1 hora de validade
                .sign(algorithm);
        return token;
    }
}
