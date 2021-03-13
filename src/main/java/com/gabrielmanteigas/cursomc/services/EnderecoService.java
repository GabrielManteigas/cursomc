package com.gabrielmanteigas.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielmanteigas.cursomc.domain.Endereco;
import com.gabrielmanteigas.cursomc.repositories.EnderecoRepository;
import com.gabrielmanteigas.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository repo;
	
	public Endereco find(Integer id) {
		Optional<Endereco> obj = repo.findById(id);
		
		return obj.orElseThrow(()-> new ObjectNotFoundException(
					"Objecto não encontrado! Id: " + id + ", Tipo: " + Endereco.class.getName()));
	}
}
