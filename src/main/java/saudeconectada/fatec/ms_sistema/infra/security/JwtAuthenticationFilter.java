package saudeconectada.fatec.ms_sistema.infra.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;


import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final String secretKey = "seuSecretAqui";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = request.getHeader("Authorization");

        if (token != null && token.startsWith("Bearer ")) {
            token = token.replace("Bearer ", "");

            try {
                Claims claims = Jwts.parser()
                        .setSigningKey(secretKey)
                        .parseClaimsJws(token)
                        .getBody();

                String cpf = claims.getSubject();

                // Aqui você pode associar o CPF ao contexto de segurança, se necessário
                SecurityContextHolder.getContext().setAuthentication(new JwtAuthenticationToken(cpf));

            } catch (Exception e) {
                // Em caso de erro, você pode invalidar a requisição
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}
