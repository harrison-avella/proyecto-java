package com.comit.bikerama.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.comit.bikerama.domain.User;
import com.comit.bikerama.repository.IUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("El email" + email + " no existe");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                getGrantedAuthority(user));
    }

    private List<GrantedAuthority> getGrantedAuthority(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (user.getRole().getName().equalsIgnoreCase("admin")) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return authorities;
    }
}