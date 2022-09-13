package ru.hj77.client.security;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log
@Component
public class HeaderAuthenticationFilter implements Filter {

    @Value("${server.security.key}")
    private String SECRET_KEY;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String authHeader = req.getHeader("Authorization");

        if (authHeader == null || !authHeader.equals(SECRET_KEY)) {
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            log.info("Ошибка заголовка");
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
