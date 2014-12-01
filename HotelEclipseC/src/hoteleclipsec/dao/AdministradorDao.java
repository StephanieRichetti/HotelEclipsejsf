package hoteleclipsec.dao;

import hoteleclipsec.entity.Administrador;
import hoteleclipsec.mb.SessaoAdministradorMb;
import hoteleclipsec.util.Util;

import javax.persistence.EntityManager;
import javax.persistence.Query;



public class AdministradorDao {
	private EntityManager entityManager;

	public AdministradorDao() {
		entityManager = Util.getEntityManager();
	}

	public Administrador buscarAdministradorPorNome(String nome) {
		SessaoAdministradorMb s = new SessaoAdministradorMb();
		Query query = entityManager.createQuery(
				"SELECT a From Administrador a Where a.nome = ?", Administrador.class);
		query.setParameter(1, s.getAdminLogin().getNome());
		try {
			return (Administrador) query.getSingleResult();
		} catch (Exception exception) {
			return null;
		}
	}
}
