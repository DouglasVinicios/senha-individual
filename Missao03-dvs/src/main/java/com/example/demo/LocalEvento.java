package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class LocalEvento {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	@Embedded
	@NotNull
	private Endereco endereco;
	@NotBlank(message = "Link do Maps é necessário")
	private String linkGoogleMaps;
	@Min(value = 1, message = "Capacidade deve ser maior que 0")
	private int capacidade;
	@Column(nullable = false, columnDefinition = "BIT(1) default 1")
	private boolean aberto;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getLinkGoogleMaps() {
		return linkGoogleMaps;
	}
	public void setLinkGoogleMaps(String linkGoogleMaps) {
		this.linkGoogleMaps = linkGoogleMaps;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public boolean isAberto() {
		return aberto;
	}
	public void setAberto(boolean aberto) {
		this.aberto = aberto;
	}
}
