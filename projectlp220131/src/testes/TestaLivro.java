package testes;

import java.io.IOException;

import classes.Gerencia;
import classes.Livro;
import classes.Usuario;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestaLivro {
	private Livro livroUm;
	private Usuario userUm;
	private Livro livroDois;
	private Livro livroTres;
	private Livro livroQuatro;

	@Before
	public void criaObjetos() throws Exception {
		userUm = new Usuario("Marcos", "1234567", "marcosasn@gmail.com",
				"Rua Santo Antonio 260, Centro");
		livroUm = new Livro("Monte Santo", "Alcione Sales", "Norma",
				"Suspense", "Um");
		livroDois = new Livro("Monte Santo", "Alcione Sales", "Norma",
				"Suspense", "Um");

		livroTres = new Livro("Monte Santo", "Rayssa", "Norma", "Suspense",
				"Um");
		livroQuatro = new Livro("Monte Santo", "Rayssa", "Norma", "Suspense",
				"Um");
	}

	@Test
	public void testaConstrutorLivros() throws Exception {
		try {
			new Livro(" ", "Alcione Sales", "Norma", "Suspense", "Um");
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("nome nao pode ser vazio ou nulo",
					e.getMessage());
		}

		try {
			new Livro(null, "Alcione Sales", "Norma", "Suspense", "Um");
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("nome nao pode ser vazio ou nulo",
					e.getMessage());
		}

		try {
			new Livro("Monte Santo", "Alcione Sales", " ", "Suspense", "Um");
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("editora nao pode ser vazio ou nulo",
					e.getMessage());
		}

		try {
			new Livro("Monte Santo", "Alcione Sales", null, "Suspense", "Um");
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("editora nao pode ser vazio ou nulo",
					e.getMessage());
		}

		try {
			new Livro("Monte Santo", " ", "Norma", "Suspense", "Um");
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("autor nao pode ser vazio ou nulo",
					e.getMessage());
		}

		try {
			new Livro("Monte Santo", null, "Norma", "Suspense", "Um");
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("autor nao pode ser vazio ou nulo",
					e.getMessage());
		}

		try {
			new Livro("Monte Santo", "Alcione Sales", "Norma", " ", "Um");
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("genero nao pode ser vazio ou nulo",
					e.getMessage());
		}

		try {
			new Livro("Monte Santo", "Alcione Sales", "Norma", null, "Um");
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("genero nao pode ser vazio ou nulo",
					e.getMessage());
		}

		try {
			new Livro("Monte Santo", "Alcione Sales", "Norma", "Suspense", " ");
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("versao nao pode ser vazio ou nulo",
					e.getMessage());
		}

		try {
			new Livro("Monte Santo", "Alcione Sales", "Norma", "Suspense", null);
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("versao nao pode ser vazio ou nulo",
					e.getMessage());
		}

		try {
			new Livro("Monte Santo", "Alcione Sales", "Norma", "Suspense", "Um", " ");
			Assert.fail("Esperava excessao.");
		} catch (IOException e) {
			Assert.assertEquals("Arquivo inexistente", e.getMessage());
		}

		try {
			new Livro("Monte Santo", "Alcione Sales", "Norma", "Suspense", "Um", null);
			Assert.fail("Esperava excessao.");
		} catch (IOException e) {
			Assert.assertEquals("Arquivo inexistente", e.getMessage());
		}

	}

	@Test
	public void testaGetsLivro() throws Exception {
		Assert.assertEquals("Monte Santo", livroUm.getNome());
		Assert.assertEquals("Alcione Sales", livroUm.getAutor());
		Assert.assertEquals("Norma", livroUm.getEditora());
		Assert.assertEquals("Suspense", livroUm.getGenero());
		Assert.assertEquals("Um", livroUm.getVersao());
		Assert.assertEquals(null, livroUm.getUsuarioAtual());
	}

	@Test
	public void testaSetsLivro() throws Exception {
		try {
			livroUm.setUsuarioAtual(null);
			Assert.fail("esperava excecao");
		} catch (Exception e) {
			Assert.assertEquals("usuario nao pode ser nulo", e.getMessage());
		}

		try {
			livroUm.setCapa(null);
			Assert.fail("esperava excecao");
		} catch (Exception e) {
			Assert.assertEquals("Arquivo inexistente", e.getMessage());
		}

		try {
			livroUm.setCapa(" ");
			Assert.fail("esperava excecao");
		} catch (Exception e) {
			Assert.assertEquals("Arquivo inexistente", e.getMessage());
		}

		livroUm.setUsuarioAtual(new Usuario("Marcos", "1234567", "marcosasn@gmail.com",
				"Rua Santo Antonio 260, Centro"));
		Assert.assertEquals(userUm, livroUm.getUsuarioAtual());
	}

	@Test
	public void testaFavoritar() throws Exception {
		Gerencia gerencia = new Gerencia();
		gerencia.cadastraUsuario(new Usuario("Marcos", "1234567", "marcosasn@ccc.ufcg.edu.br",
				"Rua Santo Antonio 260, Centro"));
		gerencia.login("marcosasn@ccc.ufcg.edu.br", "1234567");

		try {
			livroUm.favoritar(50);
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("Numero de estrelas de 1 ate 5.",
					e.getMessage());
		}

		try {
			livroUm.favoritar(100);
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("Numero de estrelas de 1 ate 5.",
					e.getMessage());
		}

		try {
			livroUm.favoritar(-5);
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals(
					"Numero de estrelas nao pode ser zero ou negativo.",
					e.getMessage());
		}

		try {
			livroUm.favoritar(-4);
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals(
					"Numero de estrelas nao pode ser zero ou negativo.",
					e.getMessage());
		}

		try {
			livroUm.favoritar(0);
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals(
					"Numero de estrelas nao pode ser zero ou negativo.",
					e.getMessage());
		}

		livroUm.favoritar(4);

		try {
			livroUm.favoritar(3);
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("Usuario ja favoritou o item", e.getMessage());
		}
		
		livroDois.favoritar(5);
		Assert.assertEquals(3.5, 0.0, livroUm.getEstrelas());
		Assert.assertEquals(5.0, 0.0, livroDois.getEstrelas());
	}

	@Test
	public void testaCompareTo() throws Exception {
		livroUm.favoritar(5);
		livroDois.favoritar(4);
		livroTres.favoritar(5);

		Assert.assertEquals(1, livroUm.compareTo(livroDois));
		Assert.assertEquals(-1, livroDois.compareTo(livroUm));
		Assert.assertEquals(0, livroUm.compareTo(livroTres));
	}

	@Test
	public void testaEquals() {
		Assert.assertTrue(livroUm.equals(livroDois));
		Assert.assertFalse(livroUm.equals(livroTres));
		Assert.assertTrue(livroTres.equals(livroQuatro));
		Assert.assertTrue(livroDois.equals(livroUm));
		Assert.assertTrue(livroQuatro.equals(livroTres));
		Assert.assertFalse(livroTres.equals(livroUm));
		Assert.assertFalse(livroDois.equals(livroQuatro));
	}
}