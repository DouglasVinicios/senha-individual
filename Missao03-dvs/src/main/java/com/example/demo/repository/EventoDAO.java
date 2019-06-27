package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Evento;

@Repository
public interface EventoDAO extends JpaRepository<Evento, Integer> {

	public List<Evento> findByNomeEventoContainingIgnoreCase(String nome);
}
