package lp2.lab07;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Studing {
	private CD cd;
	private CD cdDois;
	
	@Before
	public void criaObjetos() throws Exception {
		cd = new CD("Vida", "Padre Fabio de Melo", 10, " ");
		cdDois = cd;
	}
	
	@Test
	public void testaCriaCD() {
		try {
			new CD(" ", " ", 0, " ");
			Assert.fail("Esperava excessao.");
		} catch(Exception e) {
			Assert.assertEquals("Titulo nao pode ser vazio.", e.getMessage());
		}
		
		try {
			new CD("Vida", " ", 0, " ");
			Assert.fail("Esperava excessao.");
		} catch(Exception e) {
			Assert.assertEquals("Autor nao pode ser vazio.", e.getMessage());
		}
		
		try {
			new CD("Vida", "Padre Fabio de Melo", 0, " ");
			Assert.fail("Esperava excessao.");
		} catch(Exception e) {
			Assert.assertEquals("Valor invalido para quantidade de musicas.", e.getMessage());
		}
		
		try {
			new CD("Vida", "Padre Fabio de Melo", -10, " ");
			Assert.fail("Esperava excessao.");
		} catch(Exception e) {
			Assert.assertEquals("Valor invalido para quantidade de musicas.", e.getMessage());
		}
	}
	
	@Test
	public void testaCriaObjetos() {
		Assert.assertTrue(cd.getTitulo().toLowerCase().equals("vida"));
		Assert.assertTrue(cd.getAutor().toLowerCase().equals("padre fabio de melo"));
		Assert.assertTrue(cd.getMusicas() == 10);
		Assert.assertTrue(cd.getCarroChefe().toLowerCase().equals(" "));
		
		Assert.assertTrue(cdDois.getTitulo().toLowerCase().equals("vida"));
		Assert.assertTrue(cdDois.getAutor().toLowerCase().equals("padre fabio de melo"));
		Assert.assertTrue(cdDois.getMusicas() == 10);
		Assert.assertTrue(cdDois.getCarroChefe().toLowerCase().equals(" "));
	}
}
