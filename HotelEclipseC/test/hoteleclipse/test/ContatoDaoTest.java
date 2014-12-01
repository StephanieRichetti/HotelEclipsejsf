package hoteleclipse.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import hoteleclipsec.dao.ContatoDao;
import hoteleclipsec.entity.Contato;
import hoteleclipsec.util.Util;

public class ContatoDaoTest {

	private void resetTableContato() {
		String query = "truncate contato;";
		executeQuery(query);
	}

	private void insertId1() {
		String query = "INSERT INTO contato(id,nome,email,mensagem) VALUES(1,'Contato 1','contato')";
		executeQuery(query);
	}

	private void insertId10() {
		String query = "INSERT INTO contato(nome,email,mensagem) VALUES('Contato 1','contatos contato 1')";

		for (int i = 2; i <= 10; i++)
			query = query.concat(",('Contato " + i + "','Nome " + i + "')");
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
	private ContatoDao dao;

	@Before
	public void begin() {
		resetTableContato();
		entityManager = Util.getEntityManager();
		entityManager.getTransaction().begin();
		dao = new ContatoDao(entityManager);
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
		Contato contato = new Contato();
		contato.setNome("João Paulo ...");
		contato.setEmail("João Paulo ...");
		contato.setMensagem("João Paulo ...");
		dao.salvar(contato);
	}

	@Test
	public void buscarContatoPorId() {
		insertId1();

		testSalvar();
		Contato contato = dao.buscarPorId(1L);
		assertNotNull(contato);
	}

	@Test
	public void excluirContato1() {
		insertId1();
		dao.excluir(1L);

	}

	@Test
	public void listarContato() {
		insertId10();

		List<Contato> contatos = dao.listar();

		assertEquals(10, contatos.size());
	}

}
