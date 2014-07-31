package lp2.lab08;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
* Aluno: Marcos Antônio Silva Nascimento
* Matrícula: 112210791
*/

public class TestaPolitico {
	Politico politicoUm;
	Politico politicoDois;
	
	@Before
	public void criaObjetos() throws Exception {
		politicoUm = new Politico("Marcos", 5671);
		politicoDois = new Politico("Santiago", 3451);
	}
	
	@Test
	public void testaCriaPolitico() {
		try {
			new Politico(null, 5671);
			Assert.fail("Esperava excessao.");
		}catch(Exception e) {
			Assert.assertEquals("Nome nulo ou vazio.", e.getMessage());
		}
		
		try {
			new Politico(" ", 5671);
			Assert.fail("Esperava excessao.");
		}catch(Exception e) {
			Assert.assertEquals("Nome nulo ou vazio.", e.getMessage());
		}
		
		try {
			new Politico("Marcos", -5671);
			Assert.fail("Esperava excessao.");
		}catch(Exception e) {
			Assert.assertEquals("Numero de contribuinte invalido.", e.getMessage());
		}
		
		try {
			new Politico("Marcos", 0);
			Assert.fail("Esperava excessao.");
		}catch(Exception e) {
			Assert.assertEquals("Numero de contribuinte invalido.", e.getMessage());
		}
		
		Assert.assertTrue(politicoUm.getNumContribuintes() == 2);
	}
	
	@Test
	public void testaCriaObjetos() throws Exception {
		Assert.assertTrue(politicoUm.getNome().equals("Marcos"));
		Assert.assertTrue(politicoUm.getNumContribuinte() == 5671);
		
		politicoUm.setNome("Thiago");
		politicoUm.setNumContribuinte(2348);
		
		Assert.assertTrue(politicoUm.getNome().equals("Thiago"));
		Assert.assertTrue(politicoUm.getNumContribuinte() == 2348);
	}
	
	public void testeSetSalario() throws Exception {
		try {
			politicoUm.setSalario(-20);
			Assert.fail("Esperava excessao.");
		} catch(Exception e) {
			Assert.assertEquals("Valor invalido.", e.getMessage());
		}
		
		try {
			politicoUm.setSalario(-1000);
			Assert.fail("Esperava excessao.");
		} catch(Exception e) {
			Assert.assertEquals("Numero em kilometros invalido.", e.getMessage());
		}
		
		politicoUm.setSalario(3000);
		Assert.assertTrue(politicoUm.getSalario() == 3000);		
	}
	
	public void testaDesconto() throws Exception {
		politicoUm.setSalario(3000.0);
		Assert.assertTrue(politicoUm.desconto() == 0.0);	
		
		politicoUm.setSalario(0);
		Assert.assertTrue(politicoUm.imposto() == 0.0);	
	}

	public void testaImposto() throws Exception {
		politicoUm.setSalario(3000.0);
		Assert.assertTrue(politicoUm.imposto() == 300.0);	
		
		politicoUm.setSalario(10000);
		Assert.assertTrue(politicoUm.imposto() == 1000.0);	
	}
}