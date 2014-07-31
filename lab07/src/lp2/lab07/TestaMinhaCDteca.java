package lp2.lab07;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*

 * Aluno: Marcos Antônio Silva Nascimento

 * Matricula: 112210791

 */

public class TestaMinhaCDteca {
	MinhaCDteca colecaoCds;
	MinhaCDteca colecaoCdsDois;
	MinhaCDteca colecaoCdsTres;
	MinhaCDteca colecaoCdsQuatro;

	
	@Before
	public void criaObjetos() throws Exception {
		colecaoCds = new MinhaCDteca();
		colecaoCds.adicionaCD(new CD("Vida", "Padre Fabio de Melo", 11, " "));
		colecaoCds.adicionaCD(new CD("Aguape", "Padre Marcelo Rossi", 11, " "));
		
		colecaoCdsDois = new MinhaCDteca();
		colecaoCdsDois.adicionaCD(new CD("Aguape", "Padre Marcelo Rossi", 11, " "));
		colecaoCdsDois.adicionaCD(new CD("Vida", "Padre Fabio de Melo", 11, " "));
		
		colecaoCdsTres = new MinhaCDteca();
		colecaoCdsTres.adicionaCD(new CD("Best of Cazuza", "Cazuza", 12, " "));
		colecaoCdsTres.adicionaCD(new CD("OFMGG", "Feature GG", 20, " "));
		
		colecaoCdsQuatro = new MinhaCDteca();
		colecaoCdsQuatro.adicionaCD(new CD("Best of Cazuza", "Cazuza", 11, " "));
		colecaoCdsQuatro.adicionaCD(new CD("OFMTVD", "Feature TVD", 11, " "));
	}
	
	
	@Test
	public void testaAdicionaCD() throws Exception {
		colecaoCds.adicionaCD(new CD("The best of Aerosmith", "Aerosmith", 20, " "));
		colecaoCds.adicionaCD(new CD("Glee Cast One", "Glee", 20, " "));
		colecaoCds.adicionaCD(new CD("It's my life", "Bon Jovi", 11, " "));
		colecaoCds.adicionaCD(new CD("Em Santidade", "Ministerio de Adoracao e Vida", 11, " "));
		colecaoCds.adicionaCD(new CD("The best of Aerosmith", "Aerosmith", 20, " "));
		Assert.assertTrue(colecaoCds.numeroDeCDs() == 7);
	}
	
	@Test
	public void testaRemoveCD() throws Exception {
		Assert.assertNull(colecaoCds.removeCD("The best of Aerosmith"));
		Assert.assertNull(colecaoCds.removeCD(" "));
		Assert.assertNull(colecaoCds.removeCD("The best of cine"));
		
		colecaoCds.adicionaCD(new CD("The best of Aerosmith", "Aerosmith", 20, " "));
		colecaoCds.adicionaCD(new CD("Glee Cast One", "Glee", 20, " "));
		colecaoCds.adicionaCD(new CD("It's my life", "Bon Jovi", 11, " "));
	
		colecaoCds.removeCD("The best of Aerosmith");
		colecaoCds.removeCD("Glee Cast One");
		colecaoCds.removeCD("It's my life");
		colecaoCds.removeCD("Vida");
		colecaoCds.removeCD("Aguape");
		Assert.assertTrue(colecaoCds.numeroDeCDs() == 0);
	}
	
	@Test
	public void testaPesquisaCD() throws Exception {
		CD lista[] = {new CD("The best of Aerosmith", "Aerosmith", 20, " "), new CD("The best of cine", "Som Livre", 15, " "), 
				new CD("Glee Cast One", "Glee", 20, " "), new CD("It's my life", "Bon Jovi", 11, " ")}; 
		
		for (int i = 0; i < lista.length; i++) {
			colecaoCds.adicionaCD(lista[i]); 
		}
		
		Assert.assertTrue(colecaoCds.pesquisaCD("The best of Aerosmith").equals(lista[0]));
		Assert.assertTrue(colecaoCds.pesquisaCD("The best of cine").equals(lista[1]));
		Assert.assertTrue(colecaoCds.pesquisaCD("Glee Cast One").equals(lista[2]));
		Assert.assertTrue(colecaoCds.pesquisaCD("It's my life").equals(lista[3]));
		Assert.assertTrue(colecaoCds.numeroDeCDs() == 6);
	}
	
	@Test
	public void testaEquals() throws Exception {
		Assert.assertTrue(colecaoCds.equals(colecaoCdsDois));
		Assert.assertTrue(colecaoCdsDois.equals(colecaoCds));

		Assert.assertFalse(colecaoCdsTres.equals(colecaoCdsQuatro));
		colecaoCdsQuatro.adicionaCD(new CD("OFMGG", "Feature GG", 20, " "));
		colecaoCdsTres.adicionaCD(new CD("OFMTVD", "Feature TVD", 20, " "));
		
		Assert.assertTrue(colecaoCdsTres.equals(colecaoCdsQuatro));
		Assert.assertTrue(colecaoCdsQuatro.equals(colecaoCdsTres));
	}
}