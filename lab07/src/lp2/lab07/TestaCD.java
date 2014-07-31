package lp2.lab07;

import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

/*

 * Aluno: Marcos Antônio Silva Nascimento

 * Matrícula: 112210791

 */

public class TestaCD {
	private CD cd_um;
	private CD cd_dois;
	private CD cd_tres;
	private CD cd_quatro;
	
	@Before
	public void criaObjetos() throws Exception {
		cd_um = new CD("Vida", "Padre Fabio de Melo", 11, " ");
		cd_dois = new CD("Aguape", "Padre Marcelo Rossi", 11, " ");
		cd_tres = new CD("Vida", "Padre Fabio de Melo", 10, " ");
		cd_quatro = new CD("Aguape", "Padre Marcelo Rossi", 10, " ");	
	}
	
	@Test
	public void testaCriaCD() throws Exception {
		try {
			new CD("Vida", "Padre Fabio de Melo", -10, " ");
			Assert.fail("Esperava excessao.");
		}catch(Exception e) {
			Assert.assertEquals("Valor invalido para quantidade de musicas.", e.getMessage());
		}
		
		try {
			new CD("Vida", "Padre Fabio de Melo", 0, " ");
			Assert.fail("Esperava excessao.");
		}catch(Exception e) {
			Assert.assertEquals("Valor invalido para quantidade de musicas.", e.getMessage());
		}
		
		try {
			new CD(" ", "Padre Fabio de Melo", 11, " ");
			Assert.fail("Esperava excessao.");
		}catch(Exception e) {
			Assert.assertEquals("Titulo nao pode ser vazio.", e.getMessage());
		}
		
		try {
			new CD("Vida", " ", -10, " ");
			Assert.fail("Esperava excessao.");
		}catch(Exception e) {
			Assert.assertEquals("Autor nao pode ser vazio.", e.getMessage());
		}
		
		try {
			new CD(" ", " ", 0, " ");
			Assert.fail("Esperava excessao.");
		}catch(Exception e) {
			Assert.assertEquals("Titulo nao pode ser vazio.", e.getMessage());
		}
	}
	
	@Test
	public void testaCriaObjetos() {
		Assert.assertTrue(cd_um.getTitulo().equals("Vida"));
		Assert.assertTrue(cd_um.getAutor().equals("Padre Fabio de Melo"));
		Assert.assertTrue(cd_um.getMusicas() == 11);
		Assert.assertTrue(cd_um.getCarroChefe().equals(" "));
		
		cd_um.setCarroChefe("Vida");
		Assert.assertTrue(cd_um.getCarroChefe().equals("Vida"));
		Assert.assertEquals("Padre Fabio de Melo, Vida, Vida, ", cd_um.toString());
	}
	
	@Test
	public void testaCadastraFaixa() {
		Assert.assertNull(cd_um.getFaixa(1));
		
		Assert.assertTrue(cd_um.cadastraFaixa("Vida"));
		Assert.assertTrue(cd_um.cadastraFaixa("Tudo e do pai"));
		Assert.assertTrue(cd_um.cadastraFaixa("Cara de familia"));
		Assert.assertTrue(cd_um.cadastraFaixa("Deus e capaz"));
		Assert.assertTrue(cd_um.cadastraFaixa("Tudo posso"));
		
		Assert.assertTrue(cd_um.getFaixa(1).equals("Vida"));
		Assert.assertTrue(cd_um.getFaixa(2).equals("Tudo e do pai"));
		Assert.assertTrue(cd_um.getFaixa(3).equals("Cara de familia"));
		Assert.assertTrue(cd_um.getFaixa(4).equals("Deus e capaz"));
		Assert.assertTrue(cd_um.getFaixa(5).equals("Tudo posso"));
		
		Assert.assertNull(cd_um.getFaixa(6));
		Assert.assertNull(cd_um.getFaixa(-1));
		Assert.assertNull(cd_um.getFaixa(0));
	
		Assert.assertEquals("Padre Fabio de Melo, Vida,  , 1 - Vida/2 - Tudo e do pai/" +
				"3 - Cara de familia/4 - Deus e capaz/5 - Tudo posso", cd_um.toString());	
	}
	
	@Test
	public void testaEquals() {
		Assert.assertFalse(cd_um.equals(cd_dois));
		Assert.assertTrue(cd_um.equals(cd_tres));
		Assert.assertTrue(cd_tres.equals(cd_um));
		
		Assert.assertFalse(cd_dois.equals(cd_tres));
		Assert.assertTrue(cd_dois.equals(cd_quatro));
		Assert.assertTrue(cd_quatro.equals(cd_dois));
	}
	
	@Test
	public void cadastraVariasFaixas() {
		Assert.assertTrue(cd_um.cadastraFaixa("Vida"));
		Assert.assertTrue(cd_um.cadastraFaixa("Tudo e do pai"));
		Assert.assertTrue(cd_um.cadastraFaixa("Cara de familia"));
		Assert.assertTrue(cd_um.cadastraFaixa("Deus e capaz"));
		Assert.assertTrue(cd_um.cadastraFaixa("Tudo posso"));
		Assert.assertTrue(cd_um.cadastraFaixa("O caderno"));
		Assert.assertTrue(cd_um.cadastraFaixa("Deus e pai-poema"));
		Assert.assertTrue(cd_um.cadastraFaixa("Pai"));
		Assert.assertTrue(cd_um.cadastraFaixa("Graças, pai"));
		Assert.assertTrue(cd_um.cadastraFaixa("Humano demais"));
		Assert.assertTrue(cd_um.cadastraFaixa("Nao foi tua culpa"));
		
		Assert.assertFalse(cd_um.cadastraFaixa("Deus e capaz"));
		Assert.assertEquals("Padre Fabio de Melo, Vida,  , 1 - Vida/2 - Tudo e do pai/" +
				"3 - Cara de familia/4 - Deus e capaz/5 - Tudo posso/6 - O caderno/7 - Deus e pai-poema/" +
				"8 - Pai/9 - Graças, pai/10 - Humano demais/11 - Nao foi tua culpa", cd_um.toString());
	}
}