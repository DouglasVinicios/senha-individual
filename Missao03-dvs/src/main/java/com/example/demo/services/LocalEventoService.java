package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.LocalEventoNotFoundException;
import com.example.demo.models.LocalEvento;
import com.example.demo.repository.LocalEventoDAO;

@Service
public class LocalEventoService {
	@Autowired
	private LocalEventoDAO localEventoRep;
	
	public List<LocalEvento> listarLocaisEventos() {
		return localEventoRep.findAll(Sort.by("endereco.nome"));
	}
	
	public void salvarLocalEvento(LocalEvento localEvento) {
		this.localEventoRep.save(localEvento);
	}
	
	public LocalEvento buscarLocalEvento(LocalEvento localEvento) throws LocalEventoNotFoundException {
		if(localEvento != null && localEvento.getCodigo() != null) {
			return this.localEventoRep.getOne(localEvento.getCodigo());
		}
		throw new LocalEventoNotFoundException();
	}
	
	public void removerLocalEvento(LocalEvento localEvento) {
		if(localEvento != null && localEvento.getCodigo() != null) {
			this.localEventoRep.delete(localEvento);
		}
	}
	
}
