package com.comit.bikerama.security.jwt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/*
 * comprueba si hay un tocken valido, y si no devuelve un 401 no autorizado
 */
@Component
public class JwtEntryPoint implements AuthenticationEntryPoint {

        private final static Logger logger =
                        LoggerFactory.getLogger(JwtEntryPoint.class);

        @Override
        public void commence(HttpServletRequest red, HttpServletResponse res,
                        AuthenticationException e)
                        throws IOException, ServletException {
                logger.error("Authentication failed: {}", e.getMessage());
                res.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                                "Unauthorized: " + e.getMessage());
        }


}
