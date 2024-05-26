package br.com.tasifyi.gestao_vagas.providers;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JWTProvider {

    @Value("${security.token.secret}")
    private String secretKey;

    public DecodedJWT validateToken(String token){
        token = token.replace("Bearer ", "");

        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        try {
            var tokenDecode = JWT.require(algorithm)
                    .build()
                    .verify(token);
            return tokenDecode;
        }
        catch (JWTVerificationException ex){
            ex.printStackTrace();
            return null;
        }

    }
}
