package com.projetointegrador.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.projetointegrador.model.UsuarioModel;

@Service
public class UserDetailsServiceImplements implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UsuarioModel> user;
		if (user.isPresent()) {
			return new UserDetailsImplements(user.get());
		} else {
			throw new UsernameNotFoundException(username + " não existe");
		}
	}

}
