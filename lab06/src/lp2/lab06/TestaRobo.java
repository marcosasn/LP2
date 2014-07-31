package lp2.lab06;

import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

/* Aluno: Marcos Antônio */

public class TestaRobo {
	private Robo robo;
	private Sala salaRobo;
	
	@Before
	public void criaObjetos() throws Exception {
		salaRobo = new Sala(10, 10);
		robo = new Robo(salaRobo, 10);
	}
	
	@Test
	public void testaCriaRobo() {
		try {
			new Robo(salaRobo, -10);
			Assert.fail();
		}catch(Exception e){
			Assert.assertEquals("Energia invalida.", e.getMessage());
		}
		
		try {
			new Robo(salaRobo, 0);
			Assert.fail();
		}catch(Exception e){
			Assert.assertEquals("Energia invalida.", e.getMessage());
		}
		
		Assert.assertFalse(salaRobo.verificarPosicaoLivre(0, 0));
		Assert.assertEquals("Linha: 0, Coluna: 0", robo.toString());
	}
	
	@Test
	public void testaAndarParaCima() {
		Assert.assertFalse(robo.andarParaCima());
		Assert.assertFalse(salaRobo.verificarPosicaoLivre(0, 0));
		Assert.assertTrue(robo.getLinhaRobo() == 0);
		Assert.assertTrue(robo.getColunaRobo() == 0);
	}
	
	@Test
	public void testaAndarParaBaixo() {
		Assert.assertTrue(robo.andarParaBaixo());
		Assert.assertTrue(salaRobo.verificarPosicaoLivre(0, 0));
		Assert.assertFalse(salaRobo.verificarPosicaoLivre(1, 0));
		Assert.assertTrue(robo.getEnergiaRobo() == 9);
		Assert.assertTrue(robo.getPassosRobo() == 1);
		
		Assert.assertTrue(robo.andarParaBaixo());
		Assert.assertTrue(salaRobo.verificarPosicaoLivre(1, 0));
		Assert.assertFalse(salaRobo.verificarPosicaoLivre(2, 0));
		Assert.assertTrue(robo.getEnergiaRobo() == 8);
		Assert.assertTrue(robo.getPassosRobo() == 2);
		
		Assert.assertTrue(salaRobo.inserirObstaculo(3, 0));
		Assert.assertFalse(robo.andarParaBaixo());
		Assert.assertTrue(robo.getEnergiaRobo() == 8);
		Assert.assertTrue(robo.getPassosRobo() == 2);
	}
	
	@Test
	public void testaAndarParaEsquerda() {
		Assert.assertFalse(robo.andarParaEsquerda());
		Assert.assertFalse(salaRobo.verificarPosicaoLivre(0, 0));
		Assert.assertTrue(robo.getEnergiaRobo() == 10);
		Assert.assertTrue(robo.getPassosRobo() == 0);
	}
	
	@Test
	public void testaAndarParaDireita() {
		Assert.assertTrue(robo.andarParaDireita());
		Assert.assertTrue(salaRobo.verificarPosicaoLivre(0, 0));
		Assert.assertFalse(salaRobo.verificarPosicaoLivre(0, 1));
		Assert.assertTrue(robo.getEnergiaRobo() == 9);
		Assert.assertTrue(robo.getPassosRobo() == 1);
		
		Assert.assertTrue(robo.andarParaDireita());
		Assert.assertTrue(salaRobo.verificarPosicaoLivre(0, 1));
		Assert.assertFalse(salaRobo.verificarPosicaoLivre(0, 2));
		Assert.assertTrue(robo.getEnergiaRobo() == 8);
		Assert.assertTrue(robo.getPassosRobo() == 2);
		
		Assert.assertTrue(salaRobo.inserirObstaculo(0, 3));
		Assert.assertFalse(robo.andarParaDireita());
		Assert.assertTrue(robo.getEnergiaRobo() == 8);
		Assert.assertTrue(robo.getPassosRobo() == 2);
	}
	
	@Test
	public void testaTodosMovimentos() {
		Assert.assertTrue(robo.andarParaDireita());
		Assert.assertTrue(salaRobo.verificarPosicaoLivre(0, 0));
		Assert.assertFalse(salaRobo.verificarPosicaoLivre(0, 1));
		Assert.assertTrue(robo.getEnergiaRobo() == 9);
		
		Assert.assertTrue(robo.andarParaBaixo());
		Assert.assertTrue(salaRobo.verificarPosicaoLivre(0, 1));
		Assert.assertFalse(salaRobo.verificarPosicaoLivre(1, 1));
		Assert.assertTrue(robo.getEnergiaRobo() == 8);
		
		Assert.assertTrue(robo.andarParaEsquerda());
		Assert.assertTrue(salaRobo.verificarPosicaoLivre(1, 1));
		Assert.assertFalse(salaRobo.verificarPosicaoLivre(1, 0));
		Assert.assertTrue(robo.getEnergiaRobo() == 7);
		
		Assert.assertTrue(robo.andarParaCima());
		Assert.assertTrue(salaRobo.verificarPosicaoLivre(1, 0));
		Assert.assertFalse(salaRobo.verificarPosicaoLivre(0, 0));
		Assert.assertTrue(robo.getEnergiaRobo() == 6);
		
		Assert.assertTrue(robo.getPassosRobo() == 4);
	}
}