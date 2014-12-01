package hoteleclipsec.dao;

import hoteleclipsec.entity.Cliente;
import hoteleclipsec.entity.Reserva;
import hoteleclipsec.util.Util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ReservaDao {

	private EntityManager entityManager;

	public ReservaDao() {
		entityManager = Util.getEntityManager();
	}

	public ReservaDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<Reserva> listar() {
		Query query = entityManager.createQuery("From Reserva", Reserva.class);
		return query.getResultList();
	}

	public Reserva salvar(Reserva reserva) {
		try {
			if (reserva.getId() == null) {
				entityManager.persist(reserva);
			} else {
				entityManager.merge(reserva);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reserva;
	}

	public Reserva buscarPorId(Long id) {
		return entityManager.find(Reserva.class, id);
	}

	public Reserva excluir(Long ID) {
		Reserva reserva = entityManager.getReference(Reserva.class, ID);
		entityManager.remove(reserva);
		return reserva;
	}
}
