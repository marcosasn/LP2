package lp2.lab08;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
* Aluno: Marcos Antônio Silva Nascimento
* Matrícula: 112210791
*/

public class TestaTaxista {
	Taxista taxistaUm;
	Taxista taxistaDois;
	
	@Before
	public void criaObjetos() throws Exception {
		taxistaUm = new Taxista("Marcos", 5671);
		taxistaDois = new Taxista("Santiago", 2782);
	}
	
	@Test
	public void testaCriaTaxista() {
		try {
			new Taxista(null, 5671);
			Assert.fail("Esperava excessao.");
		}catch(Exception e) {
			Assert.assertEquals("Nome nulo ou vazio.", e.getMessage());
		}
		
		try {
			new Taxista(" ", 5671);
			Assert.fail("Esperava excessao.");
		}catch(Exception e) {
			Assert.assertEquals("Nome nulo ou vazio.", e.getMessage());
		}
		
		try {
			new Taxista("Marcos", -5671);
			Assert.fail("Esperava excessao.");
		}catch(Exception e) {
			Assert.assertEquals("Numero de contribuinte invalido.", e.getMessage());
		}
		
		try {
			new Taxista("Marcos", 0);
			Assert.fail("Esperava excessao.");
		}catch(Exception e) {
			Assert.assertEquals("Numero de contribuinte invalido.", e.getMessage());
		}
		
		Assert.assertTrue(taxistaUm.getNumContribuintes() == 2);
	}
	
	@Test
	public void testaCriaObjetos() throws Exception {
		Assert.assertTrue(taxistaUm.getNome().equals("Marcos"));
		Assert.assertTrue(taxistaUm.getNumContribuinte() == 5671);
		
		taxistaUm.setNome("Thiago");
		taxistaUm.setNumContribuinte(2348);
		
		Assert.assertTrue(taxistaUm.getNome().equals("Thiago"));
		Assert.assertTrue(taxistaUm.getNumContribuinte() == 2348);
	}
	
	public void testeSetPassageiros() throws Exception {
		try {
			taxistaUm.setNumContribuinte(-20);
			Assert.fail("Esperava excessao.");
		} catch(Exception e) {
			Assert.assertEquals("Numero de passageiros ivalido.", e.getMessage());
		}
		
		try {
			taxistaUm.setNumPassageiros(-1000);
			Assert.fail("Esperava excessao.");
		} catch(Exception e) {
			Assert.assertEquals("Numero de passageiros ivalido.", e.getMessage());
		}
		
		taxistaUm.setNumPassageiros(50);
		Assert.assertTrue(taxistaUm.getNumPassageiros() == 50);		
	}
	
	public void testaImposto() throws Exception {
		taxistaUm.setNumPassageiros(50);
		Assert.assertTrue(taxistaUm.imposto() == 25.0);	
		
		taxistaUm.setNumPassageiros(200);
		Assert.assertTrue(taxistaUm.imposto() == 100.0);	
	}
	
	public void testaDesconto() throws Exception {
		taxistaUm.setNumPassageiros(50);
		taxistaUm.setKiloPercorridos(100.0);
		Assert.assertTrue(taxistaUm.desconto() == 1);
		Assert.assertTrue(taxistaUm.totalImposto() == 24);
		
		taxistaUm.setNumPassageiros(100);
		taxistaUm.setKiloPercorridos(10.0);
		Assert.assertTrue(taxistaUm.desconto() == 50);
		Assert.assertTrue(taxistaUm.totalImposto() == 49.9);
	}
}