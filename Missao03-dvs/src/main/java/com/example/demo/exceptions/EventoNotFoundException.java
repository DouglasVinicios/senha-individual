package com.example.demo.exceptions;

public class EventoNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Evento não existe";
	}
}
