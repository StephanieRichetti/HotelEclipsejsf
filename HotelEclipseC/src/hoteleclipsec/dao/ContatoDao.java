package hoteleclipsec.dao;

import hoteleclipsec.entity.Contato;
import hoteleclipsec.entity.Reserva;
import hoteleclipsec.util.Util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


public class ContatoDao {

	private EntityManager entityManager;

	public ContatoDao() {
		entityManager = Util.getEntityManager();
	}
	
	public ContatoDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public List<Contato> listar() {
		Query query = entityManager.createQuery("From Contato", Contato.class);
		return query.getResultList();
	}

	public void salvar(Contato contato) {
		entityManager.merge(contato);
	}

	public Contato buscarPorId(Long id) {
		return entityManager.find(Contato.class, id);
	}

	public void excluir(Long id) {
		Contato contato = entityManager.getReference(Contato.class, id);
		entityManager.remove(contato);
	}
}