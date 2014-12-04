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

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import hoteleclipsec.dao.ContatoDao;
import hoteleclipsec.entity.Cliente;
import hoteleclipsec.entity.Contato;
import hoteleclipsec.util.Util;

public class ContatoDaoTest extends DBUnitTestContato {

	public ContatoDaoTest() {
		super();
		}
	
	private Contato gravaContato() throws java.text.ParseException{
		begin();
		Contato c = new Contato();
		c.setNome("Cliente_Teste_1");
		c.setEmail("test@hotmaill.com");
		c.setMensagem("TESTE TESTE");
		close();
		
		return c;
		}
	
	@Test
	public void testGravaContato() throws ParseException, java.text.ParseException {
		assertNotNull(gravaContato());
	}
	
	

	
	
}
