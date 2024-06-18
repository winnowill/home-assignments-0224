package ru.sberbank.jd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.sberbank.jd.entity.Login;
import ru.sberbank.jd.repository.LoginRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Collection;

@Component
public class LoginDetailsService implements UserDetailsService {
    private LoginRepository repository;

    @Autowired
    public void setUserCache(LoginRepository repository) {
        this.repository = repository;
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Login user = repository.findLoginByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User id=" + username + " found");
        }
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));

        return new User(user.getUsername(), user.getPassword(), authorities);
    }
}

