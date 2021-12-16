package com.projetointegrador.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.projetointegrador.model.UsuarioModel;
import com.projetointegrador.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImplements implements UserDetailsService {
	private @Autowired UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UsuarioModel> user = repository.findByEmail(username);
		if (user.isPresent()) {
			return new UserDetailsImplements(user.get().getEmail(), user.get().getSenha());
		} else {
			throw new UsernameNotFoundException(username + " não existe");
		}
	}

}
