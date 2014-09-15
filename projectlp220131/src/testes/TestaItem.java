package testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import classes.Gerencia;
import classes.Item;
import classes.Livro;
import classes.Usuario;

public class TestaItem {
	Item itemUm;
	Usuario userUm;
	
	@Before
	public void criaItens() throws Exception {
		itemUm = new Livro("Como programar em Java", "Aline Campos", "Normalizando", "CC para todos ", "Um");
			
	}

	@Test
	public void testaConstrutorItem() throws Exception {
		try {
			new Livro(" ", "Aline Campos", "Normalizando", "CC para todos ", "Um");
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("nome nao pode ser vazio ou nulo", e.getMessage());
		}

		try {
			new Livro(null, "Aline Campos", "Normalizando", "CC para todos ", "Um");
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("nome nao pode ser vazio ou nulo", e.getMessage());
		}
	}

	@Test
	public void testaGetsIten() throws Exception {
		Calendar data = Calendar.getInstance();
		Assert.assertEquals(data, itemUm.getData());
		Assert.assertEquals(0, 0, itemUm.getEstrelas());
		Assert.assertEquals("Como programar em Java", itemUm.getNome());
		Assert.assertEquals(0, itemUm.getNumDeEmprestimos());
		Assert.assertEquals(null, itemUm.getUsuarioAtual());
		Assert.assertEquals("Como programar em Java", itemUm.getNome());
	}

	@Test
	public void testaSetsIten() throws Exception {
		try {
			itemUm.setUsuarioAtual(null);
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("usuario nao pode ser nulo", e.getMessage());
		}

		itemUm.setUsuarioAtual(new Usuario("Marcos", "1234567", "marcosasn@gmail.com", "Rua Santo Antonio 260, Centro"));
		Assert.assertEquals(new Usuario("Marcos", "1234567", "marcosasn@gmail.com", "Rua Santo Antonio 260, Centro"), itemUm.getUsuarioAtual());
	}
	
	@Test
	public void testaFavoritar() throws Exception {
		Gerencia gerencia = new Gerencia();
		gerencia.cadastraUsuario(new Usuario("Marcos", "1234567", "marcosasn@gmail.com", "Rua Santo Antonio 260, Centro"));
		gerencia.login("marcosasn@gmail.com", "1234567");
		
		try {
			itemUm.favoritar(50);
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("Numero de estrelas de 1 ate 5.", e.getMessage());
		}

		try {
			itemUm.favoritar(100);
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("Numero de estrelas de 1 ate 5.", e.getMessage());
		}

		try {
			itemUm.favoritar(-5);
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("Numero de estrelas nao pode ser zero ou negativo.", e.getMessage());
		}

		try {
			itemUm.favoritar(-4);
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("Numero de estrelas nao pode ser zero ou negativo.", e.getMessage());
		}

		try {
			itemUm.favoritar(0);
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("Numero de estrelas nao pode ser zero ou negativo.", e.getMessage());
		}

		itemUm.favoritar(4);
		Assert.assertEquals(4.0, 0.0, itemUm.getEstrelas());

		try {
			itemUm.favoritar(5);
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("Usuario ja favoritou o item", e.getMessage());

		}
	}
}