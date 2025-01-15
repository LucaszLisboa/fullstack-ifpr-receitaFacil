package edu.ifpr.receitafacil.configuration;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import edu.ifpr.receitafacil.model.User;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    // Utilizar esse método para gerar o token quando o usuário logar

    public String generateToken(User user){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                        .withIssuer("auth-api")
                        .withSubject(user.getLogin())
                        .withExpiresAt(getExpirationDate())
                        .sign(algorithm);
                        
            return token;
        } catch (JWTCreationException e) {
            throw new RuntimeException("Error", e);
        }
    }

    public String validatedToken (String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token)
                    .getSubject();
        }catch(JWTVerificationException e){
            return "";
        }
    }

    private Instant getExpirationDate(){
        return LocalDateTime.now()
            .plusHours(2)
            .toInstant(ZoneOffset.of("-03:00"));
    }
    
}