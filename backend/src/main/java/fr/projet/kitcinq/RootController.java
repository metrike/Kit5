package fr.projet.kitcinq;

import fr.projet.kitcinq.user.Role;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RootController {

    public record MeResponse(String role) {}

    @GetMapping(value = "/me", produces = MediaType.APPLICATION_JSON_VALUE)
    public MeResponse me(Authentication authentication) {
        Optional<Role> role = Role.fromAuthentication(authentication);

        var roleName = role.map(Enum::name).orElse("NO_ROLE");

        return new MeResponse(roleName);
    }

    @GetMapping(value = "/", produces = MediaType.TEXT_PLAIN_VALUE)
    public String index() {
        return "OK";
    }

    @GetMapping(value = "/private", produces = MediaType.TEXT_PLAIN_VALUE)
    @PreAuthorize("hasAnyRole('ADMIN', 'USER', 'PROFESSOR')")
    public String privateEndpoint() {
        return "OK";
    }
}
