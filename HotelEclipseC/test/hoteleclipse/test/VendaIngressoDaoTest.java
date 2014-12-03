package hoteleclipse.test;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;




import hoteleclipsec.dao.VendaIngressoDao;
import hoteleclipsec.entity.VendaIngresso;
import hoteleclipsec.util.Util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class VendaIngressoDaoTest {

	private void resetTableVendaIngresso() {
		String query = "truncate vendaIngresso;";
		executeQuery(query);
	}

	private void insertId1() {
		String query = "INSERT INTO vendaIngresso(id,nome,setor, dataEvento) VALUES(1,'VendaIngresso 1','A', 12/11/2014 )";
		executeQuery(query);
	}

	private void insertId10() {
		String query = "INSERT INTO vendaIngresso(id,nome,setor, dataEvento) VALUES(1,'VendaIngresso 2','b', 22/11/2014 )";

		for (int i = 2; i <= 10; i++)
			query = query.concat(",('Stephanie " + i + "'A' " + i
					+ "'29/12/2014" + i + ")");

		executeQuery(query);
	}
	
	private void executeQuery(String query) {
		EntityManager em = Util.getEntityManager();
		em.getTransaction().begin();

		em.createNativeQuery(query).executeUpdate();

		em.getTransaction().commit();
		em.close();
	}
	
	// fim de manipulação do banco

		@BeforeClass
		public static void init() {
			Util.initFactory();
		}

		@AfterClass
		public static void finish() {
			Util.closeFactory();
		}

		private EntityManager entityManager;
		private VendaIngressoDao dao;

		@Before
		public void begin() {
			resetTableVendaIngresso();
			entityManager = Util.getEntityManager();
			entityManager.getTransaction().begin();
	//		dao = new VendaIngressoDao(entityManager);
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
		VendaIngresso vendaIngresso = new VendaIngresso();
		vendaIngresso.setNomeCliente("Stephanie");
		vendaIngresso.setSetor("A");
	//	vendaIngresso.setDataEvento(dataEvento);
		

		dao.salvar(vendaIngresso);
	}
	
	@Test
	public void buscarVendaIngressoPorId() {
		insertId1();

		testSalvar();
		VendaIngresso vendaIngresso = dao.buscarPorId(1L);
		assertNotNull(vendaIngresso);
	}

	@Test
	public void excluirVendaIngresso1() {
		insertId1();
		dao.excluir(1L);

	}
	
}
