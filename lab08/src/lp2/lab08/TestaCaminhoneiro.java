package lp2.lab08;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
* Aluno: Marcos Antônio Silva Nascimento
* Matrícula: 112210791
*/

public class TestaCaminhoneiro {
	Caminhoneiro caminhoneiroUm;
	Caminhoneiro caminhoneiroDois;
	
	@Before
	public void criaObjetos() throws Exception {
		caminhoneiroUm = new Caminhoneiro("Marcos", 2347);
		caminhoneiroDois = new Caminhoneiro("Kelvin", 5447);
	}
	
	@Test
	public void testaCriaCaminhoneiro() {
		try {
			new Caminhoneiro(null, 2347);
			Assert.fail("Esperava excessao.");
		}catch(Exception e) {
			Assert.assertEquals("Nome nulo ou vazio.", e.getMessage());
		}
		
		try {
			new Caminhoneiro(" ", 2347);
			Assert.fail("Esperava excessao.");
		}catch(Exception e) {
			Assert.assertEquals("Nome nulo ou vazio.", e.getMessage());
		}
		
		try {
			new Caminhoneiro("Marcos", -2347);
			Assert.fail("Esperava excessao.");
		}catch(Exception e) {
			Assert.assertEquals("Numero de contribuinte invalido.", e.getMessage());
		}
		
		try {
			new Caminhoneiro("Marcos", 0);
			Assert.fail("Esperava excessao.");
		}catch(Exception e) {
			Assert.assertEquals("Numero de contribuinte invalido.", e.getMessage());
		}
		
		Assert.assertTrue(caminhoneiroUm.getNumContribuintes() == 2);
		Assert.assertTrue(caminhoneiroDois.getNumContribuintes() == 2);
	}
	
	@Test
	public void testaCriaObjetos() throws Exception {
		Assert.assertTrue(caminhoneiroUm.getNome().equals("Marcos"));
		Assert.assertTrue(caminhoneiroUm.getNumContribuinte() == 2347);
		
		caminhoneiroUm.setNome("Thiago");
		caminhoneiroUm.setNumContribuinte(2348);
		
		Assert.assertTrue(caminhoneiroUm.getNome().equals("Thiago"));
		Assert.assertTrue(caminhoneiroUm.getNumContribuinte() == 2348);
	}
	
	public void testeSetToneTransportadas() throws Exception {
		try {
			caminhoneiroUm.setToneTransportadas(-20);
			Assert.fail("Esperava excessao.");
		} catch(Exception e) {
			Assert.assertEquals("Valor para toneladas invalido.", e.getMessage());
		}
		
		try {
			caminhoneiroUm.setKiloPercorridos(-1000);
			Assert.fail("Esperava excessao.");
		} catch(Exception e) {
			Assert.assertEquals("Numero em kilometros invalido.", e.getMessage());
		}
		
		caminhoneiroUm.setToneTransportadas(20);
		caminhoneiroUm.setKiloPercorridos(1000);
		
		Assert.assertTrue(caminhoneiroUm.getToneTransportadas() == 20);
		Assert.assertTrue(caminhoneiroUm.getKiloPercorridos() == 1000);
	}
	
	public void testaImposto() throws Exception {
		caminhoneiroUm.setToneTransportadas(10);
		Assert.assertTrue(caminhoneiroUm.imposto() == 500.0);	
		
		caminhoneiroUm.setToneTransportadas(20);
		Assert.assertTrue(caminhoneiroUm.imposto() == 1500.0);
	}
	
	public void testaDesconto() throws Exception {
		caminhoneiroUm.setKiloPercorridos(60000);
		Assert.assertTrue(caminhoneiroUm.desconto() == 600);
	}
}
