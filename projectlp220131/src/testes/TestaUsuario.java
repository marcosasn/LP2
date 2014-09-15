package testes;

import classes.Item;
import classes.Livro;
import classes.Usuario;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestaUsuario {
	private Usuario userUm;
	private Usuario userDois;
	private Usuario userTres;
	private Item itemUm; 
    private Item itemDois; 

	@Before
	public void criaUsuarios() throws Exception {
		userUm = new Usuario("Marcos", "1234567", "marcosasn@gmail.com",
				"Rua Santo Antonio 260, Centro");
		userDois = new Usuario("Marcos", "1234567", "marcosasn@gmail.com",
				"Rua Santo Antonio 260, Centro");
		userTres = new Usuario("Marcos Aurelio", "1234567",
				"marcosaurelio@gmail.com", "Rua Santo Antonio 260, Centro");
		
		itemUm = new Livro("Como programar em Java", "Aline Campos", "Normalizando", "CC para todos ", "Um"); 
        itemDois = new Livro("Monte Santo", "Alcione Sales", "Norma", 
                "Suspense", "Um");
	}

	@Test
	public void testaConstrutorUsuario() throws Exception {
		try {
			new Usuario(" ", "1234567", "marcosasn@gmail.com",
					"Rua Santo Antonio 260, Centro");
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("nome nao pode ser vazio ou nulo",
					e.getMessage());
		}

		try {
			new Usuario(null, "1234567", "marcosasn@gmail.com",
					"Rua Santo Antonio 260, Centro");
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("nome nao pode ser vazio ou nulo",
					e.getMessage());
		}

		try {
			new Usuario("Marcos", "1234567", "marcosasn@gmail.com", " ");
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("endereco nao pode ser vazio ou nulo",
					e.getMessage());
		}

		try {
			new Usuario("Marcos", "1234567", "marcosasn@gmail.com", null);
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("endereco nao pode ser vazio ou nulo",
					e.getMessage());
		}

		try {
			new Usuario("Marcos", "1234567", " ",
					"Rua Santo Antonio 260, Centro");
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("email nao pode ser vazio ou nulo",
					e.getMessage());
		}

		try {
			new Usuario("Marcos", "1234567", null,
					"Rua Santo Antonio 260, Centro");
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("email nao pode ser vazio ou nulo",
					e.getMessage());
		}

		try {
			new Usuario("Marcos", "1234567", "marcosasn",
					"Rua Santo Antonio 260, Centro");
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("dominio do email eh invalido", e.getMessage());
		}

		try {
			new Usuario("Marcos", "1234567", "marcosasn@.coom",
					"Rua Santo Antonio 260, Centro");
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("dominio do email eh invalido", e.getMessage());
		}

		try {
			new Usuario("Marcos", "1234567", "marcosasn@gmail",
					"Rua Santo Antonio 260, Centro");
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("dominio do email eh invalido", e.getMessage());
		}

		try {
			new Usuario("Marcos", " ", "marcosasn@gmail.com",
					"Rua Santo Antonio 260, Centro");
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("senha nao pode ser vazio ou nulo",
					e.getMessage());
		}

		try {
			new Usuario("Marcos", null, "marcosasn@gmail.com",
					"Rua Santo Antonio 260, Centro");
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("senha nao pode ser vazio ou nulo",
					e.getMessage());
		}

		try {
			new Usuario("Marcos", "123", "marcosasn@gmail.com",
					"Rua Santo Antonio 260, Centro");
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("senha nao pode ter tamanho menor que 6",
					e.getMessage());
		}
	}

	@Test
	public void testaGetsUsuarios() {
		Assert.assertEquals("Marcos", userUm.getNome());
		Assert.assertEquals("1234567", userUm.getSenha());
		Assert.assertEquals("marcosasn@gmail.com", userUm.getEmail());
		Assert.assertEquals("Rua Santo Antonio 260, Centro",
				userUm.getEndereco());
		Assert.assertEquals(0, userUm.getQtdDeItens());
	}

	@Test
	public void testaSetsUsuario() throws Exception {
		try {
			userUm.setEndereco(new String(" "));
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("endereco nao pode ser vazio ou nulo",
					e.getMessage());
		}

		try {
			userUm.setEndereco(null);
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("endereco nao pode ser vazio ou nulo",
					e.getMessage());
		}

		try {
			userUm.setSenha(new String(" "));
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("senha nao pode ser vazio ou nulo",
					e.getMessage());
		}

		try {
			userUm.setSenha(null);
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("senha nao pode ser vazio ou nulo",
					e.getMessage());
		}

		try {
			userUm.setSenha("123");
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("senha nao pode ter tamanho menor que 6",
					e.getMessage());
		}

		userUm.setSenha(new String("123456789"));
		userUm.setEndereco(new String("Rua Santo Antonio 260, Santo Antonio"));
		Assert.assertEquals("123456789", userUm.getSenha());
		Assert.assertEquals("Rua Santo Antonio 260, Santo Antonio",
				userUm.getEndereco());
	}

	@Test
	public void testaAdicionaItem() throws Exception {
		try { 
			userUm.adicionaItem(null); 
			Assert.fail("Esperava excessao."); 
		}catch(Exception e) { 
			Assert.assertEquals("item nao pode ser nulo", e.getMessage()); 
		} 
			          
		userDois.adicionaItem(itemUm); 
		userDois.adicionaItem(itemDois); 
		userTres.adicionaItem(itemUm); 
			          
		Assert.assertEquals(2, userDois.getQtdDeItens()); 
		Assert.assertTrue(userDois.getListaDeItens().contains("Monte Santo")); 
		Assert.assertTrue(userDois.getListaDeItens().contains("Como programar em Java")); 
		Assert.assertEquals(1, userTres.getQtdDeItens()); 
		Assert.assertTrue(userTres.getListaDeItens().contains("Como programar em Java")); 
	}

	@Test
	public void testaRemoveItem() throws Exception {
		userDois.adicionaItem(itemUm); 
        userDois.adicionaItem(itemDois); 
          
        userDois.removeItem("Monte Santo"); 
        Assert.assertFalse(userDois.getListaDeItens().contains("Monte Santo")); 
        Assert.assertTrue(userDois.getListaDeItens().contains("Como programar em Java")); 
        Assert.assertEquals(2, userDois.getQtdDeItens()); 
          
        userDois.removeItem("Como programar em Java"); 
        Assert.assertFalse(userDois.getListaDeItens().contains("Como programar em Java")); 
        Assert.assertEquals(2, userDois.getQtdDeItens()); 

	}

	@Test
	public void testaEqualsUsuario() {
		Assert.assertTrue(userUm.equals(userDois));
		Assert.assertTrue(userDois.equals(userUm));
		Assert.assertFalse(userUm.equals(userTres));
		Assert.assertFalse(userTres.equals(userUm));
	}

	@Test
	public void testaCompareToUsuario() throws Exception {
		Assert.assertEquals(0, userUm.compareTo(userDois));
		Assert.assertEquals(0, userUm.compareTo(userDois));
		Assert.assertEquals(0, userUm.compareTo(userTres));
		Assert.assertEquals(0, userTres.compareTo(userDois));
		Assert.assertEquals(0, userDois.compareTo(userTres));
	}
}