package hoteleclipse.test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import hoteleclipsec.dao.ReservaDao;
import hoteleclipsec.entity.Reserva;
import hoteleclipsec.util.Util;

public class ReservaDaoTest {

	private void resetTableReserva() {
		String query = "truncate reserva;";
		executeQuery(query);
	}

	private void insertId1() {
		String query = "INSERT INTO reserva(id,nomeCliente,chegada.saida,quartos,quantidadePessoas,observacao) VALUES(1,'Reserva 1','reserva')";
		executeQuery(query);
	}

	private void insertId10() {
		String query = "INSERT INTO reserva(nomeCliente,chegada,saida,quartos,quantidadePessoas,observacao) VALUES('Reserva 1','reservas reserva 1')";

		for (int i = 2; i <= 10; i++)
			query = query.concat(",('João Paulo " + i + "','25/12/2014 " + i
					+ "'29/12/2014" + i + "'Luxo" + i + "'2" + i + "'obs" + i
					+ ")");

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
	private ReservaDao dao;

	@Before
	public void begin() {
		resetTableReserva();
		entityManager = Util.getEntityManager();
		entityManager.getTransaction().begin();
		dao = new ReservaDao(entityManager);
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
		Reserva reserva = new Reserva();
		reserva.setNomeCliente("João Paulo ...");
	//	reserva.setChegada("25/12/2014");
	//	reserva.setSaida("29/12/2014");
		reserva.setQuartos(3);
		reserva.setQuantidadePessoas(6);
		reserva.setObservacao("observacao");

		dao.salvar(reserva);
	}

	@Test
	public void buscarReservaPorId() {
		insertId1();

		testSalvar();
		Reserva reserva = dao.buscarPorId(1L);
		assertNotNull(reserva);
	}

	@Test
	public void excluirReserva1() {
		insertId1();
		dao.excluir(1L);

	}
}