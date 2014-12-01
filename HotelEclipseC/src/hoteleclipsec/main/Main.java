package hoteleclipsec.main;

import hoteleclipsec.dao.ClienteDao;
import hoteleclipsec.entity.Cliente;
import hoteleclipsec.util.Util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main {
	
	public static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("hoteleclipsesa_pu");
	
	public static EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	public static ClienteDao dao = new ClienteDao();
	
	public static Cliente cliente = new Cliente();
	
	public static void main(String[] args) {
				
		entityManager.getTransaction().begin();
		entityManager.getTransaction().commit();
		atualizarCliente();
		listarClientes();
		excluirCliente(0);
		entityManager.close();
		entityManagerFactory.close();
	}

	private static void excluirCliente(long id) {
		Cliente cliente = entityManager.getReference(Cliente.class, id);
		entityManager.remove(cliente);
	}

	private static List <Cliente> listarClientes() {
		Query query = entityManager.createQuery("From Cliente", Cliente.class);
		return query.getResultList();
		
	}

	private static void atualizarCliente() {
		entityManager.merge(cliente);
		
	}


}