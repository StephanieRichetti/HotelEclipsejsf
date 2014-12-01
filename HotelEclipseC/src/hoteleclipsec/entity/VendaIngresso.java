package hoteleclipsec.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


	@Entity

	public class VendaIngresso {
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String nomeCliente;
	@Column
	private Date dataEvento ;	
	private String setor;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public Date getDataEvento() {
		return dataEvento;
	}
	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}


}
