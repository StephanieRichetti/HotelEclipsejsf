package hoteleclipse.test;

import static org.junit.Assert.*;
import hoteleclipsec.dao.ClienteDao;
import hoteleclipsec.entity.Cliente;
import hoteleclipsec.util.Util;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ClienteDaoTest {

	private void resetTableCliente() {
		String query = "truncate cliente;";
		executeQuery(query);
	}

	private void insertId1() {
		String query = "INSERT INTO cliente(id,nome,cpf,endereco,bairro,cidade,estado,email,telefone) VALUES(1,'Cliente 1','cliente')";
		executeQuery(query);
	}

	private void insertId10() {
		String query = "INSERT INTO cliente(nome,email,telefone) VALUES('Cliente 1','clientes cliente 1')";

		for (int i = 2; i <= 10; i++)
			query = query.concat(",('Cliente " + i + "','Nome " + i + "')");
		executeQuery(query);
	}

	private void executeQuery(String query) {
		EntityManager em = Util.getEntityManager();
		em.getTransaction().begin();

		em.createNativeQuery(query).executeUpdate();

		em.getTransaction().commit();
		em.close();
	}

	@BeforeClass
	public static void init() {
		Util.initFactory();
	}

	@AfterClass
	public static void finish() {
		Util.closeFactory();
	}

	private EntityManager entityManager;
	private ClienteDao dao;

	@Before
	public void begin() {
		resetTableCliente();
		entityManager = Util.getEntityManager();
		entityManager.getTransaction().begin();
		dao = new ClienteDao(entityManager);
	}

	@After
	public void close() {
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManager = null;
		dao = null;
	}

	@Test
	public void testSalvar() {
		Cliente cliente = new Cliente();
		cliente.setNome("Sara ...");
		cliente.setCpf("888.769.345-11");
		cliente.setBairro("Centro");
		cliente.setCidade("Rio de Janeiro");
		cliente.setEstado("RJ");
		cliente.setEmail("João Paulo ...");
		cliente.setTelefone("32668574");
		dao.salvar(cliente);
	}

	@Test
	public void buscarClientePorId() {
		insertId1();

		testSalvar();
		Cliente cliente = dao.buscarPorId(1L);
		assertNotNull(cliente);
	}

	@Test
	public void excluirCliente1() {
		insertId1();
		dao.excluir(1L);

	}

	@Test
	public void listarCliente() {
		insertId10();

		List<Cliente> clientes = dao.listar();
		assertEquals(10, clientes.size());
	}

}