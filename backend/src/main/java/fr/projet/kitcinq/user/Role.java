package fr.projet.kitcinq.user;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Optional;

public enum Role {
    STUDENT,
    PROFESSOR,
    ADMIN;

    public static final String ROLE_STUDENT = "ROLE_STUDENT";
    public static final String ROLE_PROFESSOR = "ROLE_PROFESSOR";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";

    public static Optional<Role> fromAuthentication(Authentication authentication) {
        if (authentication == null) {
            return Optional.empty();
        }

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        if (authorities == null) {
            return Optional.empty();
        }

        for (GrantedAuthority authority : authorities) {
            if (authority.getAuthority().equals(ROLE_STUDENT)) {
                return Optional.of(STUDENT);
            }
            if (authority.getAuthority().equals(ROLE_PROFESSOR)) {
                return Optional.of(PROFESSOR);
            }
            if (authority.getAuthority().equals(ROLE_ADMIN)) {
                return Optional.of(ADMIN);
            }
        }

        return Optional.empty();
    }
}
