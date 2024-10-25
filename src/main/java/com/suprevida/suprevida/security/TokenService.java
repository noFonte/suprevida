package com.suprevida.suprevida.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.suprevida.suprevida.entyties.UserEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {
    private final String SECRET_KEY = "suprevida"; // Mantenha essa chave segura
    private final long EXPIRATION_TIME = 1000 * 60  * 1; // 10 horas

    // Gera um novo token JWT
    public String generateToken(UserEntity user) {
        return JWT.create()
                .withSubject(user.getUsername())
                .withClaim("id",user.getId())
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME)
                        .toInstant())
                .sign(Algorithm.HMAC256(SECRET_KEY));
    }

    // Extrai o nome de usuário do token
    public String extractUsername(String token) {
        DecodedJWT decodedJWT = JWT.decode(token);
        return decodedJWT.getSubject();
    }

    // Verifica se o token é válido
    public boolean validateToken(String token, String username) {
        try {
            DecodedJWT decodedJWT = JWT.decode(token);
            String extractedUsername = decodedJWT.getSubject();
            return (extractedUsername.equals(username) && !isTokenExpired(decodedJWT));
        } catch (Exception e) {
            return false;
        }
    }

    // Verifica se o token está expirado
    private boolean isTokenExpired(DecodedJWT decodedJWT) {
        return decodedJWT.getExpiresAt().before(new Date());
    }

    public String getSubject(String token) {
        return JWT.require(Algorithm.HMAC256(SECRET_KEY)).build().verify(token).getSubject();
    }
}
