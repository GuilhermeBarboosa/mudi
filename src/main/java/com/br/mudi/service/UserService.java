package com.br.mudi.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.br.mudi.entity.User;
import com.br.mudi.repository.PedidoRepository;
import com.br.mudi.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
	
	private UserRepository userRepository;
	
	public Optional<User> findBy(String name) {
		return userRepository.findById(name);
	}

}
