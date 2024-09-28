package saudeconectada.fatec.ms_sistema.infra.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;

public class JwtAuthenticationToken extends AbstractAuthenticationToken {

    private final String cpf;

    public JwtAuthenticationToken(String cpf) {
        super(null);
        this.cpf = cpf;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return cpf;
    }
}
