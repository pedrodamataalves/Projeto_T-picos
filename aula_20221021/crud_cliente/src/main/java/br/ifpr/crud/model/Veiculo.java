package br.ifpr.crud.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "veiculos")
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String placa;
	
	@Column
	private String fabricante;
	
	@Column
	private String modelo;
	
	@Column
	private Integer ano_fabricacao;
	
	public Integer getAno_fabricacao() {
		return ano_fabricacao;
	}
	public void setAno_fabricacao(Integer ano_fabricacao) {
		this.ano_fabricacao = ano_fabricacao;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return placa;
	}
	public void setNome(String nome) {
		this.placa = nome;
	}
	public String getEmail() {
		return fabricante;
	}
	public void setEmail(String email) {
		this.fabricante = email;
	}
	public String getTelefone() {
		return modelo;
	}
	public void setTelefone(String telefone) {
		this.modelo = telefone;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		return Objects.equals(id, other.id);
	}
	
}