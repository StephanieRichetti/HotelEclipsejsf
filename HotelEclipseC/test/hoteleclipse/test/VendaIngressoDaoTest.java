package hoteleclipse.test;

import static org.junit.Assert.assertNotNull;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;

import hoteleclipsec.dao.VendaIngressoDao;
import hoteleclipsec.entity.Reserva;
import hoteleclipsec.entity.VendaIngresso;
import hoteleclipsec.util.Util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class VendaIngressoDaoTest extends DBUnitTestVendaIngresso{

	public VendaIngressoDaoTest() {
		super();
		}
	
	private VendaIngresso gravaVendaIngresso() throws java.text.ParseException{
		begin();
		VendaIngresso v = new VendaIngresso();
		Date date = new Date();
		SimpleDateFormat formatdate = new SimpleDateFormat("dd/MM/yyyy");
		
		try{
			date = formatdate.parse("12/01/2014");
		}
		catch(ParseException e){
			e.printStackTrace();
		}
	
		v.setNomeCliente("Jose");
		v.setSetor("A");
		v.setDataEvento(date);
		VendaIngresso vendaIngresso = getDaoVendaIngresso().salvar(v);
		close();
		
		return v;
		}
	
	@Test
	public void testGravaVendaIngresso() throws ParseException, java.text.ParseException {
		assertNotNull(gravaVendaIngresso());
	}	
}
