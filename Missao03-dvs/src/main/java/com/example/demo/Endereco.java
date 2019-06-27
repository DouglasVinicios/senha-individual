package com.example.demo;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class Endereco {
	@NotBlank(message = "Nome do endereço é necessário")
	private String nome;
	@NotBlank(message = "Avenida é necessário")
	private String avenida;
	@NotBlank(message = "Bairro é necessário")
	private String bairro;
	@NotBlank(message = "Cidade é necessário")
	private String cidade;
	@NotBlank(message = "Estado é necessário")
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
