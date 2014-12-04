package hoteleclipse.test;

import static org.junit.Assert.*;
import hoteleclipsec.dao.ClienteDao;
import hoteleclipsec.entity.Cliente;
import hoteleclipsec.entity.VendaIngresso;
import hoteleclipsec.util.Util;

import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.apache.jasper.compiler.JavacErrorDetail;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;



public class ClienteDaoTest extends DBUnitTestCliente {
	
	public static EntityManager entityManager;

	public ClienteDaoTest() {
		super();
		}

	
		private Cliente gravaCliente() throws java.text.ParseException{
			begin();
			Cliente c = new Cliente();
			c.setNome("Cliente_Teste_1");
			c.setCpf("66677788898");
			c.setTelefone("32568798");
			c.setEndereco("cipriano nunes");
			c.setBairro("Rio vermelho");
			c.setCidade("florianopolis");
			c.setEstado("SC");
			dao.salvar(c);		
			Cliente cliente = getDaoCliente().salvar(c);
			close();
			
			return c;
			}
		
		@Test
		public void testGravaCliente() throws ParseException, java.text.ParseException {
			assertNotNull(gravaCliente());
		}

			
		
	
}