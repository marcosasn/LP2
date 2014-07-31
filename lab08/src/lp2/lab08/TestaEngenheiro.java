package lp2.lab08;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
* Aluno: Marcos Antônio Silva Nascimento
* Matrícula: 112210791
*/

public class TestaEngenheiro {
	Engenheiro engenheiroUm;
	Engenheiro engenheiroDois;
	
	@Before
	public void criaObjetos() throws Exception {
		engenheiroUm = new Engenheiro("Marcos", 2347);
		engenheiroDois = new Engenheiro("Kyoto", 4377);
	}
	
	@Test
	public void testaCriaEngenheiro() {
		try {
			new Engenheiro(null, 2347);
			Assert.fail("Esperava excessao.");
		}catch(Exception e) {
			Assert.assertEquals("Nome nulo ou vazio.", e.getMessage());
		}
		
		try {
			new Engenheiro(" ", 2347);
			Assert.fail("Esperava excessao.");
		}catch(Exception e) {
			Assert.assertEquals("Nome nulo ou vazio.", e.getMessage());
		}
		
		try {
			new Engenheiro("Marcos", -2347);
			Assert.fail("Esperava excessao.");
		}catch(Exception e) {
			Assert.assertEquals("Numero de contribuinte invalido.", e.getMessage());
		}
		
		try {
			new Engenheiro("Marcos", 0);
			Assert.fail("Esperava excessao.");
		}catch(Exception e) {
			Assert.assertEquals("Numero de contribuinte invalido.", e.getMessage());
		}
		
		Assert.assertTrue(engenheiroUm.getNumContribuintes() == 2);
	}
	
	@Test
	public void testaCriaObjetos() throws Exception {
		Assert.assertTrue(engenheiroUm.getNome().equals("Marcos"));
		Assert.assertTrue(engenheiroUm.getNumContribuinte() == 2347);
		
		engenheiroUm.setNome("Felipe");
		engenheiroUm.setNumContribuinte(3428);
		
		Assert.assertTrue(engenheiroUm.getNome().equals("Felipe"));
		Assert.assertTrue(engenheiroUm.getNumContribuinte() == 3428);
	}
	
	public void testeSetNumProjetos() throws Exception {
		try {
			engenheiroUm.setNumProjetos(-20);
			Assert.fail("Esperava excessao.");
		} catch(Exception e) {
			Assert.assertEquals("Numero invalido.", e.getMessage());
		}
		
		try {
			engenheiroUm.setNumProjetos(-1000);
			Assert.fail("Esperava excessao.");
		} catch(Exception e) {
			Assert.assertEquals("Numero invalido.", e.getMessage());
		}
		
		engenheiroUm.setNumProjetos(200);
		Assert.assertTrue(engenheiroUm.getNumProjetos() == 200);		
	}
	
	public void testaSetDespesas() throws Exception {
		try {
			engenheiroUm.setDespesas(-500);
			Assert.fail("Esperava excessao.");
		} catch(Exception e) {
			Assert.assertEquals("Valor invalido.", e.getMessage());
		}
		
		try {
			engenheiroUm.setDespesas(1000);
			Assert.fail("Esperava excessao.");
		} catch(Exception e) {
			Assert.assertEquals("Valor invalido.", e.getMessage());
		}
		
		engenheiroUm.setDespesas(500);
		Assert.assertTrue(engenheiroUm.getDespesas() == 500.0);	
		
		engenheiroUm.setDespesas(1000);
		Assert.assertTrue(engenheiroUm.getDespesas() == 1000.0);	
	}
	
	public void testaDesconto() throws Exception {
		engenheiroUm.setDespesas(500);
		Assert.assertTrue(engenheiroUm.desconto() == 100);
		
		engenheiroUm.setDespesas(0);
		Assert.assertTrue(engenheiroUm.desconto() == 0);
	}
	
	public void testaImposto() throws Exception {
		engenheiroUm.setNumProjetos(200);
		Assert.assertTrue(engenheiroUm.imposto() == 200000);
		
		engenheiroUm.setNumProjetos(0);
		Assert.assertTrue(engenheiroUm.imposto() == 0);
	}
}