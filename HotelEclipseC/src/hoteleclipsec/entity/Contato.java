package hoteleclipsec.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


	@Entity
	public class Contato {

	@Id
	private Integer idContato;
	@Column
	private String nome;
	@Column
	private String email;	
	private String mensagem;


	public String getNome() {
	return nome;
	}
	public void setNome(String nome) {
	this.nome = nome;
	}
	public String getEmail() {
	return email;
	}
	public void setEmail(String email) {
	this.email = email;
	}
	public String getMensagem() {
	return mensagem;
	}
	public void setMensagem(String mensagem) {
	this.mensagem = mensagem;
	}


	}


