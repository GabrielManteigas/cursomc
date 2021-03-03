package com.gabrielmanteigas.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielmanteigas.cursomc.domain.Categoria;
import com.gabrielmanteigas.cursomc.repositories.CategoriaRepository;
import com.gabrielmanteigas.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		
		return obj.orElseThrow(()-> new ObjectNotFoundException(
					"Objecto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
}
