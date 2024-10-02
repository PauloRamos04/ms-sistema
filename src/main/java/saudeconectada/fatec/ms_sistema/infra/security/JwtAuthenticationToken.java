package saudeconectada.fatec.ms_sistema.infra.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import org.springframework.security.authentication.AbstractAuthenticationToken;

public class JwtAuthenticationToken extends AbstractAuthenticationToken {
    private final String cpf;

    public JwtAuthenticationToken(String cpf, Object credentials, Object principal) {
        super(null);
        this.cpf = cpf;
        setAuthenticated(true); // Define como autenticado após validação do token
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return cpf; // Retorna o CPF do token
    }
}
