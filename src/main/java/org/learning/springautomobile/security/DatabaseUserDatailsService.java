package org.learning.springautomobile.security;

import org.learning.springautomobile.model.AutoUser;
import org.learning.springautomobile.repository.AutoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class DatabaseUserDatailsService implements UserDetailsService {
    @Autowired
    private AutoUserRepository autoUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<AutoUser> autoUser = autoUserRepository.findByUsername(username);
        if (autoUser.isPresent()) {
            return new DatabaseUserDetails(autoUser.get());
        } else {
            throw new UsernameNotFoundException(username);
        }
    }
}
