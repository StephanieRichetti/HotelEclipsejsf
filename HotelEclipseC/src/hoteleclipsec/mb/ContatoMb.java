package hoteleclipsec.mb;

import hoteleclipsec.dao.ContatoDao;
import hoteleclipsec.entity.Contato;
import hoteleclipsec.util.EmailUtil;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.persistence.EntityManager;



@ManagedBean
public class ContatoMb {
	private String nome;
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
	
	public String enviar(){
		String mensagemText = "Nome: " + nome +
							  "\nEmail: " + email +
							  "\nMensagem: " + mensagem;
		
		try {
			EmailUtil.enviarEmail(email, "Contato via site.", mensagemText);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}		
		return "";
	}
}


