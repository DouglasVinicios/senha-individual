package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.EventoNotFoundException;
import com.example.demo.models.Evento;
import com.example.demo.repository.EventoDAO;

@Service
public class EventoService {
	@Autowired
	private EventoDAO eventoRep;
	
	public void salvarEvento(Evento evento) {
		this.eventoRep.save(evento);
	}
	
	public List<Evento> listarEventos() {
		return this.eventoRep.findAll(Sort.by("nome"));
	}
	
	public List<Evento> buscarEventosPeloNome(String nomePesquisado) {
		if(nomePesquisado == null || nomePesquisado.trim().isEmpty()) {
			return listarEventos();
		}
		return this.eventoRep.findByNomeEventoContainingIgnoreCase(nomePesquisado);	
	}
	
	public Evento buscarEventoExistente(Evento evento) throws EventoNotFoundException {
		if(evento != null && evento.getCodigo() != null) {
			return this.eventoRep.getOne(evento.getCodigo());
		}
		throw new EventoNotFoundException();
	}
	
	public void removerEvento(Evento evento) {
		if(evento != null && evento.getCodigo() != null) {
			this.eventoRep.delete(evento);
		}
	}
	
}
