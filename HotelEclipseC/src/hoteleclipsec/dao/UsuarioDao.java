package hoteleclipsec.dao;


import hoteleclipsec.entity.Usuario;
import hoteleclipsec.mb.SessaoUsuarioMb;
import hoteleclipsec.util.Util;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class UsuarioDao {
	
	private EntityManager entityManager;

	public UsuarioDao() {
		entityManager = Util.getEntityManager();
	}

	public  Usuario buscarUsuarioPorNome(String nome) {
		SessaoUsuarioMb s = new SessaoUsuarioMb();
		Query query = entityManager.createQuery(
				"SELECT u From Usuario u Where u.nome = ?", Usuario.class);
		query.setParameter(1, s.getUsuarioLogin().getNome());
		try {
			return (Usuario) query.getSingleResult();
		} catch (Exception exception) {
			return null;
		}
	}
}
