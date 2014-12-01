package hoteleclipsec.dao;

import hoteleclipsec.entity.Cliente;
import hoteleclipsec.util.Util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ClienteDao {

	private EntityManager entityManager;

	public ClienteDao() {
		entityManager = Util.getEntityManager();
	}

	public ClienteDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<Cliente> listar() {
		Query query = entityManager.createQuery("From Cliente", Cliente.class);
		return query.getResultList();
	}

	public Cliente salvar(Cliente cliente) {
		try {
			if (cliente.getId() == null) {
				entityManager.persist(cliente);
			} else {
				entityManager.merge(cliente);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cliente;
	}

	public Cliente buscarPorId(Long id) {
		return entityManager.find(Cliente.class, id);
	}

	public void excluir(Long id) {
		Cliente cliente = entityManager.getReference(Cliente.class, id);
		entityManager.remove(cliente);
	}

}
