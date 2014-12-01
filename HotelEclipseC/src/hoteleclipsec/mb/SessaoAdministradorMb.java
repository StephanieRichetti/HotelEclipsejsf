package hoteleclipsec.mb;

import java.io.Serializable;

import hoteleclipsec.dao.AdministradorDao;
import hoteleclipsec.entity.Administrador;
import hoteleclipsec.util.Util;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.persistence.Query;

@SessionScoped
@ManagedBean
public class SessaoAdministradorMb {
	private Administrador adminLogado;
	private Administrador adminLogin;

	@PostConstruct
	public void init() {
		adminLogin = new Administrador();
	}

	public String getNomeAdministrador() {
		return adminLogado.getNome();
	}

	public boolean isLogado() {
		return adminLogado != null;
	}

	public String login() {
		if  (fazerLogin()) {
			return "index?faces-redirect=true";
		}
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Usuário ou senha não confere."));
		return "";
	}

	private boolean fazerLogin() {
		AdministradorDao dao = new AdministradorDao();
		Administrador admin = dao.buscarAdministradorPorNome(adminLogin.getNome());
		
		if (admin == null)
			return false;
		if (!admin.getSenha().equals(adminLogin.getSenha()))
			return false;
		if (!admin.getNome().equalsIgnoreCase(adminLogin.getNome()))
			return false;
		
		adminLogado = admin;
		return true;
	}
	
	public String fazerLogin2(){
		Query query = Util.getEntityManager().createQuery(
				"SELECT a FROM Administrador a WHERE a.nome = ?", Administrador.class);
	
		query.setParameter(1, getAdminLogin().getNome());
		try{
			Administrador a = (Administrador) query.getSingleResult();
			if(a.getNome().equalsIgnoreCase(adminLogin.getNome()) && a.getSenha().equalsIgnoreCase(adminLogin.getSenha())){
				adminLogado = a;
				return "admin/listagemClientes.xhtml?faces-redirect-true";
			}
		}catch(Exception e) {
			System.out.println("Usuário  ou senha incorretos!");
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Üsuário ou senha incorretos!"));
		return "";
	}

	public String logout() {
		adminLogado = null;
		return "index?faces-redirect=true";
	}

	public Administrador getAdminLogin() {
		return adminLogin;
	}

	public void setAdminLogin(Administrador adminLogin) {
		this.adminLogin = adminLogin;
	}
}
