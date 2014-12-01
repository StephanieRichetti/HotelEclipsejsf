package hoteleclipsec.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Hospedagem {

	@Id
	@GeneratedValue
	private Long id;
	@Column(length = 30, nullable = false)
	private String nome;
	@Column(length = 14, nullable = false)
	private String categoriaQuartos;
	private Integer quantidadePessoas;
	private Date entrada;
	private Date saida;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoriaQuartos() {
		return categoriaQuartos;
	}

	public void setCategoriaQuartos(String categoriaQuartos) {
		this.categoriaQuartos = categoriaQuartos;
	}

	public Integer getQuantidadePessoas() {
		return quantidadePessoas;
	}

	public void setQuantidadePessoas(Integer quantidadePessoas) {
		this.quantidadePessoas = quantidadePessoas;
	}

	public Date getEntrada() {
		return entrada;
	}

	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}

	public Date getSaida() {
		return saida;
	}

	public void setSaida(Date saida) {
		this.saida = saida;
	}

}
