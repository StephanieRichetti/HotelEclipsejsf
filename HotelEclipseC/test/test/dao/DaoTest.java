package test.dao;

import static org.junit.Assert.assertNotNull;
import hoteleclipse.test.DBUnitTest;

import javax.persistence.EntityManager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import hoteleclipsec.dao.ClienteDao;
import hoteleclipsec.dao.ContatoDao;
import hoteleclipsec.dao.HospedagemDao;
import hoteleclipsec.dao.ReservaDao;
import hoteleclipsec.util.Util;

public class DaoTest extends DBUnitTest {
	
	private static EntityManager entityManager;
	
	@BeforeClass
	public static void init(){
		Util.iniciarPersistenceUnit();
		entityManager = Util.createEntityManager();
	}
	
	@Test
	public void testEntityManager(){
	//	assertNotNull("Gerenciamento de entidade está nulo", entityManager);
	}
	
	@Test
	public void testClienteDao() {
		ClienteDao dao = new ClienteDao(entityManager);
		assertNotNull("Objeto de acesso a dados do objeto Cliente esta nulo", dao);
		dao = null;
	}
	
	@Test
	public void testContatoDao() {
		ContatoDao dao = new ContatoDao(entityManager);
		assertNotNull("Objeto de acesso a dados do objeto Contato esta nulo", dao);
		dao = null;
	}
	
	@Test
	public void testReservaDao() {
		ReservaDao dao = new ReservaDao(entityManager);
		assertNotNull("Objeto de acesso a dados do objeto Reserva esta nulo", dao);
		dao = null;
	}
	
	@Test
	public void testHospedagemDao() {
	//	HospedagemDao dao = HospedagemDao(entityManager);
	//	assertNotNull("Objeto de acesso a dados do objeto Reserva esta nulo", dao);
	//	dao = null;

	}
	
	@AfterClass
	public void close(){
		entityManager.close();
		Util.fecharPersistenceUnit();
	}
	
}
