package com.example.demo;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Evento {
	@Id @GeneratedValue
	private Integer codigo;
	private String nomeEvento;
	private String descricaoEvento;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dataRealizacao;
	private int qtdMaximaConvidados;
	private String nomeResponsavel;
	private String telefoneResponsavel;
	private LocalTime duracaoEmHoras;
	@ManyToOne
	private LocalEvento localEvento;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNomeEvento() {
		return nomeEvento;
	}
	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}
	public String getDescricaoEvento() {
		return descricaoEvento;
	}
	public void setDescricaoEvento(String descricaoEvento) {
		this.descricaoEvento = descricaoEvento;
	}
	public LocalDate getDataRealizacao() {
		return dataRealizacao;
	}
	public void setDataRealizacao(LocalDate dataRealizacao) {
		this.dataRealizacao = dataRealizacao;
	}
	public int getQtdMaximaConvidados() {
		return qtdMaximaConvidados;
	}
	public void setQtdMaximaConvidados(int qtdMaximaConvidados) {
		this.qtdMaximaConvidados = qtdMaximaConvidados;
	}
	public String getNomeResponsavel() {
		return nomeResponsavel;
	}
	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}
	public String getTelefoneResponsavel() {
		return telefoneResponsavel;
	}
	public void setTelefoneResponsavel(String telefoneResponsavel) {
		this.telefoneResponsavel = telefoneResponsavel;
	}
	public LocalTime getDuracaoEmHoras() {
		return duracaoEmHoras;
	}
	public void setDuracaoEmHoras(LocalTime duracaoEmHoras) {
		this.duracaoEmHoras = duracaoEmHoras;
	}
	public LocalEvento getLocalEvento() {
		return localEvento;
	}
	public void setLocalEvento(LocalEvento localEvento) {
		this.localEvento = localEvento;
	}
	
	@Override
	public String toString() {
		return "Evento [codigo=" + codigo + ", nomeEvento=" + nomeEvento + ", descricaoEvento=" + descricaoEvento
				+ ", dataRealizacao=" + dataRealizacao + ", qtdMaximaConvidados=" + qtdMaximaConvidados
				+ ", nomeResponsavel=" + nomeResponsavel + ", telefoneResponsavel=" + telefoneResponsavel
				+ ", duracaoEmHoras=" + duracaoEmHoras + "]";
	}
}