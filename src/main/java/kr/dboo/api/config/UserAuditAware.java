package kr.dboo.api.config;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserAuditAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return Optional.of("unknown");
        }

        if(authentication.getAuthorities().stream().anyMatch(role -> role.getAuthority().equals("ROLE_ANONYMOUS"))){
            return Optional.of("anonymous");
        }

        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        return Optional.of(username);

    }
}
