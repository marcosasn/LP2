package lp2.lab08;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
* Aluno: Marcos Antônio Silva Nascimento
* Matrícula: 112210791
*/

public class TestaMedico {
	Medico medicoUm;
	Medico medicoDois;
	
	@Before
	public void criaObjetos() throws Exception {
		medicoUm = new Medico("Marcos", 2347);
		medicoDois = new Medico("Kleper", 4432);
	}
	
	@Test
	public void testaCriaMedico() {
		try {
			new Medico(null, 2347);
			Assert.fail("Esperava excessao.");
		}catch(Exception e) {
			Assert.assertEquals("Nome nulo ou vazio.", e.getMessage());
		}
		
		try {
			new Medico(" ", 2347);
			Assert.fail("Esperava excessao.");
		}catch(Exception e) {
			Assert.assertEquals("Nome nulo ou vazio.", e.getMessage());
		}
		
		try {
			new Medico("Marcos", -2347);
			Assert.fail("Esperava excessao.");
		}catch(Exception e) {
			Assert.assertEquals("Numero de contribuinte invalido.", e.getMessage());
		}
		
		try {
			new Medico("Marcos", 0);
			Assert.fail("Esperava excessao.");
		}catch(Exception e) {
			Assert.assertEquals("Numero de contribuinte invalido.", e.getMessage());
		}
		
		Assert.assertTrue(medicoUm.getNumContribuintes() == 2);
	}
	
	@Test
	public void testaCriaObjetos() throws Exception {
		Assert.assertTrue(medicoUm.getNome().equals("Marcos"));
		Assert.assertTrue(medicoUm.getNumContribuinte() == 2347);
		
		medicoUm.setNome("Helder");
		medicoUm.setNumContribuinte(8367);
		
		Assert.assertTrue(medicoUm.getNome().equals("Helder"));
		Assert.assertTrue(medicoUm.getNumContribuinte() == 8367);
	}
	
	public void testeSetNumClientes() throws Exception {
		try {
			medicoUm.setNumClientes(-20);
			Assert.fail("Esperava excessao.");
		} catch(Exception e) {
			Assert.assertEquals("Numero invalido.", e.getMessage());
		}
		
		try {
			medicoUm.setNumClientes(-1000);
			Assert.fail("Esperava excessao.");
		} catch(Exception e) {
			Assert.assertEquals("Numero invalido.", e.getMessage());
		}
		
		medicoUm.setNumClientes(200);
		Assert.assertTrue(medicoUm.getNumClientes() == 200);		
	}
	
	public void testaSetDespesas() throws Exception {
		try {
			medicoUm.setDespesas(-500);
			Assert.fail("Esperava excessao.");
		} catch(Exception e) {
			Assert.assertEquals("Valor invalido.", e.getMessage());
		}
		
		try {
			medicoUm.setDespesas(-1000);
			Assert.fail("Esperava excessao.");
		} catch(Exception e) {
			Assert.assertEquals("Valor invalido.", e.getMessage());
		}
		
		medicoUm.setDespesas(500);
		Assert.assertTrue(medicoUm.getDespesas() == 500.0);	
		
		medicoUm.setDespesas(0);
		Assert.assertTrue(medicoUm.getDespesas() == 0.0);	
	}
	
	public void testaDesconto() throws Exception {
		medicoUm.setDespesas(0);
		Assert.assertTrue(medicoUm.desconto() == 0);
		
		medicoUm.setDespesas(300);
		Assert.assertTrue(medicoUm.desconto() == 300.0);
	}
	
	public void testaImposto() throws Exception {
		medicoUm.setNumClientes(0);
		Assert.assertTrue(medicoUm.imposto() == 0.0);
		
		medicoUm.setNumClientes(200);
		Assert.assertTrue(medicoUm.imposto() == 2000);
	}
}
