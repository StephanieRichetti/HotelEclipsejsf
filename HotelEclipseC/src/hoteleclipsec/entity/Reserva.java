package hoteleclipsec.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Reserva {

	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String nomeCliente;
	@Column
	private Date entrada;
	private Date saida;
	private Integer quantidadePessoas;
	private String categoriaQuartos;
	private String observacao;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
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


	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Integer getQuantidadePessoas() {
		return quantidadePessoas;
	}

	public void setQuantidadePessoas(Integer quantidadePessoas) {
		this.quantidadePessoas = quantidadePessoas;
	}

	public String getCategoriaQuartos() {
		return categoriaQuartos;
	}

	public void setCategoriaQuartos(String categoriaQuartos) {
		this.categoriaQuartos = categoriaQuartos;
	}


}
