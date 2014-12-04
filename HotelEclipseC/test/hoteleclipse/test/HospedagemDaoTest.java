package hoteleclipse.test;

import static org.junit.Assert.assertNotNull;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import hoteleclipsec.dao.HospedagemDao;
import hoteleclipsec.entity.Hospedagem;
import hoteleclipsec.util.Util;

public class HospedagemDaoTest extends DBUnitTestHospedagem {

	public HospedagemDaoTest() {
		super();
		}
	
	private Hospedagem gravaHospedagem() throws java.text.ParseException{
		begin();
		Hospedagem h = new Hospedagem();
		Date date = new Date();
		SimpleDateFormat formatdate = new SimpleDateFormat("dd/MM/yyyy");
		
		try{
			date = formatdate.parse("12/01/2014");
		}
		catch(ParseException e){
			e.printStackTrace();
		}
		h.setNome("Joao");
		h.setCategoriaQuartos("Classic");
		h.setQuantidadePessoas(3);
		h.setEntrada(date);
		h.setSaida(date);
		Hospedagem hospedagem = getDaoHospedagem().salvar(h);
		close();
		
		return h;
		}
	
	@Test
	public void testGravaHospedagem() throws ParseException, java.text.ParseException {
		assertNotNull(gravaHospedagem());
	}
	
}
