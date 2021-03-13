package com.gabrielmanteigas.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielmanteigas.cursomc.domain.Cliente;
import com.gabrielmanteigas.cursomc.repositories.ClienteRepository;
import com.gabrielmanteigas.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		
		return obj.orElseThrow(()-> new ObjectNotFoundException(
					"Objecto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
}
