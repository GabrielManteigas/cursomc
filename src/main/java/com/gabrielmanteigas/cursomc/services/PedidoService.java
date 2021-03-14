package com.gabrielmanteigas.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielmanteigas.cursomc.domain.Pedido;
import com.gabrielmanteigas.cursomc.repositories.PedidoRepository;
import com.gabrielmanteigas.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		
		return obj.orElseThrow(()-> new ObjectNotFoundException(
					"Objecto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
}
