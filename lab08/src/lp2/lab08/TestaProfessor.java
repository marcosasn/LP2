package lp2.lab08;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
* Aluno: Marcos Antônio Silva Nascimento
* Matrícula: 112210791
*/

public class TestaProfessor {
	Professor professorUm;
	Professor professorDois;
	Professor professorTres;
	
	@Before
	public void criaObjetos() throws Exception {
		professorUm = new Professor("Marcos", 5671);
		professorDois = new Professor("Jorge", 7142);
		professorTres = new Professor("thiago", 7121);
	}
	
	@Test
	public void testaCriaProfessor() {
		try {
			new Professor(null, 5671);
			Assert.fail("Esperava excessao.");
		}catch(Exception e) {
			Assert.assertEquals("Nome nulo ou vazio.", e.getMessage());
		}
		
		try {
			new Professor(" ", 5671);
			Assert.fail("Esperava excessao.");
		}catch(Exception e) {
			Assert.assertEquals("Nome nulo ou vazio.", e.getMessage());
		}
		
		try {
			new Professor("Marcos", -5671);
			Assert.fail("Esperava excessao.");
		}catch(Exception e) {
			Assert.assertEquals("Numero de contribuinte invalido.", e.getMessage());
		}
		
		try {
			new Professor("Marcos", 0);
			Assert.fail("Esperava excessao.");
		}catch(Exception e) {
			Assert.assertEquals("Numero de contribuinte invalido.", e.getMessage());
		}
		
		Assert.assertTrue(professorUm.getNumContribuintes() == 3);
	}
	
	@Test
	public void testaCriaObjetos() throws Exception {
		Assert.assertTrue(professorUm.getNome().equals("Marcos"));
		Assert.assertTrue(professorUm.getNumContribuinte() == 5671);
		
		professorUm.setNome("Santiago");
		professorUm.setNumContribuinte(4832);
		
		Assert.assertTrue(professorUm.getNome().equals("Santiago"));
		Assert.assertTrue(professorUm.getNumContribuinte() == 4832);
	}
	
	public void testeSetSalario() throws Exception {
		try {
			professorUm.setSalario(-20);
			Assert.fail("Esperava excessao.");
		} catch(Exception e) {
			Assert.assertEquals("Valor invalido.", e.getMessage());
		}
		
		try {
			professorUm.setSalario(-1000);
			Assert.fail("Esperava excessao.");
		} catch(Exception e) {
			Assert.assertEquals("Numero em kilometros invalido.", e.getMessage());
		}
		
		professorUm.setSalario(3000);
		Assert.assertTrue(professorUm.getSalario() == 3000);
		professorUm.setSalario(2000);
		Assert.assertTrue(professorUm.getSalario() == 2000);
	}
	
	public void testaImposto() throws Exception {
		professorUm.setSalario(3000.0);
		Assert.assertTrue(professorUm.imposto() == 300.0);	
		
		professorUm.setSalario(10000);
		Assert.assertTrue(professorUm.imposto() == 1000.0);	
	}
	
	public void testeSetDespesas() throws Exception {
		try {
			professorUm.setDespesas(-20);
			Assert.fail("Esperava excessao.");
		} catch(Exception e) {
			Assert.assertEquals("Valor invalido.", e.getMessage());
		}
		
		try {
			professorUm.setDespesas(-1000);
			Assert.fail("Esperava excessao.");
		} catch(Exception e) {
			Assert.assertEquals("Valor invalido.", e.getMessage());
		}
		
		professorUm.setDespesas(300);
		Assert.assertTrue(professorUm.getDespesas() == 300);
		professorUm.setDespesas(200);
		Assert.assertTrue(professorUm.getDespesas() == 200);
	}
	
	public void testaDesconto() throws Exception {
		professorUm.setDespesas(300);
		Assert.assertTrue(professorUm.desconto() == 150.0);	
		
		professorUm.setDespesas(400);
		Assert.assertTrue(professorUm.desconto() == 200.0);	
	}	
}