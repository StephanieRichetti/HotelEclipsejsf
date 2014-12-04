package hoteleclipse.test;

import static org.junit.Assert.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import hoteleclipsec.dao.ReservaDao;
import hoteleclipsec.entity.Reserva;
import hoteleclipsec.util.Util;

public class ReservaDaoTest extends DBUnitTestReserva{

	public ReservaDaoTest() {
		super();
		}
	
	private Reserva gravaReserva() throws java.text.ParseException{
		begin();
		Reserva r = new Reserva();
		Date date = new Date();
		SimpleDateFormat formatdate = new SimpleDateFormat("dd/MM/yyyy");
		
		try{
			date = formatdate.parse("12/01/2014");
		}
		catch(ParseException e){
			e.printStackTrace();
		}
	
		r.setNomeCliente("MAria");
		r.setCategoriaQuartos("Classic");
		r.setQuantidadePessoas(3);
		r.setEntrada(date);
		r.setSaida(date);
		Reserva reserva = getDaoReserva().salvar(r);
		close();
		
		return r;
		}
	
	@Test
	public void testGravaReserva() throws ParseException, java.text.ParseException {
		assertNotNull(gravaReserva());
	}
	
}