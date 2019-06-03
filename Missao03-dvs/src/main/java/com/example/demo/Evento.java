package com.example.demo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Evento {
	@Id @GeneratedValue
	private Integer codigo;
	@NotBlank(message = "Obrigatório, não deve ter apenas espaços em branco")
	private String nomeEvento;
	@NotBlank(message = "É necessário uma descrição do evento")
	private String descricaoEvento;
	@DateTimeFormat(pattern="yyyy-MM-dd") @FutureOrPresent(message = "Obrigatório, deve ser maior ou igual a data atual")
	private LocalDate dataRealizacao;
	@Min(value = 11, message = "Deve ser maior que 10")
	private int qtdMaximaConvidados;
	@NotBlank(message = "Nome é necessário")
	private String nomeResponsavel;
	@Pattern(regexp = "^[0-9]{9}", message = "Número de telefone inválido")
	private String telefoneResponsavel;
	@Min(value = 1, message = "Deve ser maior que 0")
	private int duracaoEmHoras;
	@ManyToOne @NotNull(message = "Obrigatório")
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
	public int getDuracaoEmHoras() {
		return duracaoEmHoras;
	}
	public void setDuracaoEmHoras(int duracaoEmHoras) {
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