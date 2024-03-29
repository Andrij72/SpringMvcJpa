package net.mateakademy.service;

import net.mateakademy.dto.User;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import net.mateakademy.entities.RoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Log4j
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserServiceImpl userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.getUserByEmail(email);
        List<String> roleNames = new ArrayList<>();
        List<GrantedAuthority> authorityList = new ArrayList<>();

        try {
            if (user == null) {
                log.info("User's email not found: " + email);
                throw new UsernameNotFoundException("User was not found " + email);
            }
        } catch (UsernameNotFoundException e) {
            e.getMessage();
        }

        log.info("Found user: " + email);

        for (RoleEntity roleEntity : user.getRoles()) {
            roleNames.add(roleEntity.getName());
        }

        if (roleNames.size() > 0) {
            for (String role : roleNames) {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role);
                authorityList.add(grantedAuthority);
            }
        }

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorityList);
    }
}
