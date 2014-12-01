package hoteleclipse.test;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import hoteleclipsec.dao.HospedagemDao;
import hoteleclipsec.entity.Hospedagem;
import hoteleclipsec.util.Util;

public class HospedagemDaoTest {

	private void resetTableHospedagem() {
		String query = "truncate hospedagem;";
		executeQuery(query);
	}

	private void insertId1() {
		String query = "INSERT INTO hospedagem(id,nome,categoriaQuartos, quantidadePessoas,entrada,saida) VALUES(1,'Hospedagem 1','Simples',2,'17/11/2014','19/11/2014)";
		executeQuery(query);
	}

	private void insertId10() {
		String query = "INSERT INTO hospedagem(nome,categoriaQuartos, quantidadePessoas,entrada,saida) VALUES(2,'Hospedagem 2','Casal',2,'19/11/2014','21/11/2014)";

		for (int i = 2; i <= 10; i++)
			query = query.concat(",('Stephanie " + i + "','25/12/2014 " + i
					+ "'29/12/2014" + i + "'Simples" + i + "'2" + i + ")");

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
	private HospedagemDao dao;

	@Before
	public void begin() {
		resetTableHospedagem();
		entityManager = Util.getEntityManager();
		entityManager.getTransaction().begin();
//		dao = new HospedagemDao(entityManager);
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
		Hospedagem hospedagem = new Hospedagem();
		hospedagem.setNome("Stephanie");
		hospedagem.setCategoriaQuartos("Simples");
		hospedagem.setQuantidadePessoas(1);
	//	hospedagem.setEntrada(entrada);
	//  hospedagem.setSaida(saida);
		

		dao.salvar(hospedagem);
	}

	@Test
	public void buscarHospedagemPorId() {
		insertId1();

		testSalvar();
		Hospedagem hospedagem = dao.buscarPorId(1L);
		assertNotNull(hospedagem);
	}

	@Test
	public void excluirHospedagem1() {
		insertId1();
		dao.excluir(1L);

	}
}
