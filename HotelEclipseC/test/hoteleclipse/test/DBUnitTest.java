package hoteleclipse.test;

import java.io.File;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

import hoteleclipsec.dao.ClienteDao;
import hoteleclipsec.dao.ContatoDao;
import hoteleclipsec.dao.HospedagemDao;
import hoteleclipsec.dao.ReservaDao;
import hoteleclipsec.util.Util;



public class DBUnitTest extends DBTestCase{
	
	private EntityManager entityManager;
	private EntityManagerFactory entityManagerFactory;
	private ClienteDao daoCliente;
	private ContatoDao daoContato;
	private HospedagemDao daoHospedagem;
	private ReservaDao daoReserva;
	
	public DBUnitTest(){
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://localhost:3306/hoteleclipsesa_db");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "");
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		return new FlatXmlDataSetBuilder().build(new File("input/dbZerado.xml"));
	}
	
	@Override
	protected DatabaseOperation getSetUpOperation() throws Exception {
		return DatabaseOperation.DELETE_ALL;
	}
	
	public void begin(){
		Util.iniciarPersistenceUnit();
		entityManager = Util.createEntityManager();
		entityManager.getTransaction().begin();
		daoCliente = new ClienteDao(entityManager);		
	}
	
	public void close(){
		entityManager.getTransaction().commit();
		entityManager.close();
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}	
		daoCliente = null;
	}

	public ClienteDao getDaoCliente() {
		return daoCliente;
	}
	
	public ContatoDao getDaoContato() {
		return daoContato;
	}
	
	public HospedagemDao getDaoHospedagem() {
		return daoHospedagem;
	}

	public ReservaDao getDaoReserva() {
		return daoReserva;
	}

}
