package com.example.demo;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {
	private String nome;
	private String avenida;
	private String bairro;
	private String cidade;
	private String estado;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAvenida() {
		return avenida;
	}
	public void setAvenida(String avenida) {
		this.avenida = avenida;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
