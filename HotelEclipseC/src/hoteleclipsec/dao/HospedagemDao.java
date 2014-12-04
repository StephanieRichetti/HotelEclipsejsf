package hoteleclipsec.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import hoteleclipsec.entity.Hospedagem;
import hoteleclipsec.util.Util;

public class HospedagemDao {

	private EntityManager entityManager;

	public HospedagemDao() {
		entityManager = Util.getEntityManager();
	}

	public HospedagemDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<Hospedagem> listar() {
		Query query = entityManager.createQuery("From Hospedagem", Hospedagem.class);
		return query.getResultList();
	}

	public Hospedagem salvar(Hospedagem hospedagem) {
		try {
			if (hospedagem.getId() == null) {
				entityManager.persist(hospedagem);
			} else {
				entityManager.merge(hospedagem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hospedagem;
	}

	public Hospedagem buscarPorId(Long id) {
		return entityManager.find(Hospedagem.class, id);
	}

	public void excluir(Long id) {
		Hospedagem hospedagem = entityManager.getReference(Hospedagem.class, id);
		entityManager.remove(hospedagem);
	}

}
