package com.vineet.web_api.filter;

import com.vineet.web_api.dao.ExceptionLogRepository;
import com.vineet.web_api.entity.ExceptionLog;
import com.vineet.web_api.utits.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalDateTime;

public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private ExceptionLogRepository exceptionLogRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws ServletException, IOException {
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            chain.doFilter(request, response);
            return;
        }

        String path = request.getServletPath();
        if (path.equals("/login")) {
            chain.doFilter(request, response);
            return;
        }
        String header = request.getHeader("Authorization");
try{


        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);
            String username = jwtUtil.extractUsername(token);

            if (username != null) {
                SecurityContextHolder.getContext().setAuthentication(
                        new org.springframework.security.authentication.UsernamePasswordAuthenticationToken(
                                username, null, new java.util.ArrayList<>()
                        )
                );
            }
        }else{
            throw new RuntimeException("Authorization Header is not Found..");
        }
} catch (Exception e) {
    ExceptionLog log = new ExceptionLog(
            e.getClass().getSimpleName(),
            e.getMessage(),
            request.getRequestURI(),
            500,
            LocalDateTime.now(),
            request.getRemoteAddr()
    );
    exceptionLogRepository.save(log);
    throw new RuntimeException(e);
}
        chain.doFilter(request, response);
    }
}