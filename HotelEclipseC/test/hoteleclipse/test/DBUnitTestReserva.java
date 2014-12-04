package hoteleclipse.test;


import hoteleclipsec.dao.ReservaDao;
import hoteleclipsec.util.Util;

import java.io.File;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

public class DBUnitTestReserva extends DBTestCase  {
	private EntityManager entityManager;
	private EntityManagerFactory entityManagerFactory;
	private ReservaDao dao;

	public DBUnitTestReserva() {
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS,"com.mysql.jdbc.Driver");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL,"jdbc:mysql://localhost:3306/hoteleclipsec_db");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME,"root");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD,"");
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		return new FlatXmlDataSetBuilder().build(new File("input/dbZerado.xml"));
	}

	@Override
	protected DatabaseOperation getSetUpOperation() throws Exception {
		return DatabaseOperation.DELETE_ALL;
	}

	public void begin() {
		Util.iniciarPersistenceUnit();
		entityManager = Util.createEntityManager();
		entityManager.getTransaction().begin();
		dao = new ReservaDao(entityManager);
	}

	public void close() {
		entityManager.getTransaction().commit();
		entityManager.close();
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		dao = null;
	}

	public ReservaDao getDaoReserva() {
		return dao;
	}

}