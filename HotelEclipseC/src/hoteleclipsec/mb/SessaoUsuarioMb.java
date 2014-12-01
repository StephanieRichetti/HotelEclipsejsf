package hoteleclipsec.mb;

import hoteleclipsec.dao.UsuarioDao;
import hoteleclipsec.entity.Usuario;
import hoteleclipsec.util.Util;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Query;

	@SessionScoped
	@ManagedBean
	public class SessaoUsuarioMb {
		private Usuario usuarioLogado;
		private Usuario usuarioLogin;

		@PostConstruct
		public void init() {
			usuarioLogin = new Usuario();
		}

		public String getNomeUsuario() {
			return usuarioLogado.getNome();
		}

		public boolean isLogado() {
			return usuarioLogado != null;
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
			UsuarioDao dao = new UsuarioDao();
			Usuario usuario  = dao.buscarUsuarioPorNome(usuarioLogin.getNome());
			
			if (usuario == null)
				return false;
			if (!usuario.getSenha().equals(usuarioLogin.getSenha()))
				return false;
			if (!usuario.getNome().equalsIgnoreCase(usuarioLogin.getNome()))
				return false;
			
			usuarioLogado = usuario;
			return true;
		}
		
		public String fazerLogin2(){
			Query query = Util.getEntityManager().createQuery(
					"SELECT u FROM Usuario u WHERE a.nome = ?", Usuario.class);
		
			query.setParameter(1, getUsuarioLogin().getNome());
			try{
				Usuario u = (Usuario) query.getSingleResult();
				if(u.getNome().equalsIgnoreCase(usuarioLogin.getNome()) && u.getSenha().equalsIgnoreCase(usuarioLogin.getSenha())){
					usuarioLogado = u;
					return "index?faces-redirect=true";
				}
			}catch(Exception e) {
				System.out.println("Usuário  ou senha incorretos!");
			}
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Üsuário ou senha incorretos!"));
			return "";
		}

		public String logout() {
			usuarioLogado = null;
			return "index?faces-redirect=true";
		}

		public Usuario getUsuarioLogin() {
			return usuarioLogin;
		}

		public void setAdminLogin(Usuario usuarioLogin) {
			this.usuarioLogin = usuarioLogin;
		}
}
