package com.comit.bikerama.security.jwt;


import java.util.Date;
import com.comit.bikerama.security.entity.UserPrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

/*
 * genera el tocken y un metodo de validadiocn que este bien formado, y no este
 * expirado
 */
@Component
public class JwtProvider {
    private final static Logger logger =
            LoggerFactory.getLogger(JwtProvider.class);
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private int expiration;

    public String generateToken(Authentication authentication) {
        UserPrincipal userPrincipal =
                (UserPrincipal) authentication.getPrincipal();
        return Jwts.builder().setSubject(userPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(new Date().getTime() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token)
                .getBody().getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException e) {
            logger.error("Token mal formado {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("Token no soportado {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("Token expirado {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("Token vacio {}", e.getMessage());
        } catch (SignatureException e) {
            logger.error("Falla en la firma {}", e.getMessage());
        }
        return false;
    }
}
