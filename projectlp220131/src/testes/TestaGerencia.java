package testes;

import java.io.IOException;

import classes.Gerencia;
import classes.Livro;
import classes.Usuario;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestaGerencia {
	private Gerencia gerencia;
	private Usuario userUm;
	private Usuario userDois;

	@Before
	public void criaObjetos() throws Exception {
		gerencia = new Gerencia(); 
		  
        userUm = new Usuario("Marcos", "1234567", "marcosasn@gmail.com", 
                "Rua Santo Antonio 260, Centro"); 
        userDois = new Usuario("Rayssa", "0811191", "rayssanol@gmail.com", 
                "Walter Soares Andrade 119, JP");
        
		gerencia.cadastraUsuario(userUm);
		gerencia.cadastraUsuario(userDois);
		gerencia.login(userUm.getEmail(), userUm.getSenha());
		gerencia.adicionaLivro(new Livro("Monte Santo", "Alcione Sales", "Norma",
				"Suspense", "Um"));
		gerencia.adicionaLivro(new Livro("Harry Potter e a pedra filosofal", "J.K.Rolling",
				"Rocco", "Ficcao", "1"));
	}

	@Test
    public void testaCadastraUsuario() throws Exception { 
        try { 
            gerencia.cadastraUsuario(new Usuario(" ", "1234567", "marcosasn@gmail.com", 
                    "Rua Santo Antonio 260, Centro")); 
            Assert.fail("Esperava excessao."); 
        } catch (Exception e) { 
            Assert.assertEquals("nome nao pode ser vazio ou nulo", 
                    e.getMessage()); 
        } 
  
        try { 
            gerencia.cadastraUsuario(new Usuario(null, "1234567", "marcosasn@gmail.com", 
                    "Rua Santo Antonio 260, Centro")); 
            Assert.fail("Esperava excessao."); 
        } catch (Exception e) { 
            Assert.assertEquals("nome nao pode ser vazio ou nulo", 
                    e.getMessage()); 
        } 
  
        try { 
            gerencia.cadastraUsuario(new Usuario("Marcos", "1234567", 
                    "marcosasn@gmail.com", " ")); 
            Assert.fail("Esperava excessao."); 
        } catch (Exception e) { 
            Assert.assertEquals("endereco nao pode ser vazio ou nulo", 
                    e.getMessage()); 
        } 
  
        try { 
            gerencia.cadastraUsuario(new Usuario("Marcos", "1234567", 
                    "marcosasn@gmail.com", null)); 
            Assert.fail("Esperava excessao."); 
        } catch (Exception e) { 
            Assert.assertEquals("endereco nao pode ser vazio ou nulo", 
                    e.getMessage()); 
        } 
  
        try { 
            gerencia.cadastraUsuario(new Usuario("Marcos", "1234567", " ", 
                    "Rua Santo Antonio 260, Centro")); 
            Assert.fail("Esperava excessao."); 
        } catch (Exception e) { 
            Assert.assertEquals("email nao pode ser vazio ou nulo", 
                    e.getMessage()); 
        } 
  
        try { 
            gerencia.cadastraUsuario(new Usuario("Marcos", "1234567", null, 
                    "Rua Santo Antonio 260, Centro")); 
            Assert.fail("Esperava excessao."); 
        } catch (Exception e) { 
            Assert.assertEquals("email nao pode ser vazio ou nulo", 
                    e.getMessage()); 
        } 
  
        try { 
            gerencia.cadastraUsuario(new Usuario("Marcos", " ", "marcosasn@gmail.com", 
                    "Rua Santo Antonio 260, Centro")); 
            Assert.fail("Esperava excessao."); 
        } catch (Exception e) { 
            Assert.assertEquals("senha nao pode ser vazio ou nulo", 
                    e.getMessage()); 
        } 
  
        try { 
            gerencia.cadastraUsuario(new Usuario("Marcos", null, "marcosasn@gmail.com", 
                    "Rua Santo Antonio 260, Centro")); 
            Assert.fail("Esperava excessao."); 
        } catch (Exception e) { 
            Assert.assertEquals("senha nao pode ser vazio ou nulo", 
                    e.getMessage()); 
        } 
  
        try { 
            gerencia.cadastraUsuario(new Usuario("Marcos", "123", "marcosasn@gmail.com", 
                    "Rua Santo Antonio 260, Centro")); 
            Assert.fail("Esperava excessao."); 
        } catch (Exception e) { 
            Assert.assertEquals("senha nao pode ter tamanho menor que 6", 
                    e.getMessage()); 
        } 
  
        Assert.assertFalse(gerencia.cadastraUsuario(userUm)); 
        Assert.assertFalse(gerencia.cadastraUsuario(userDois)); 
        Assert.assertFalse(gerencia.cadastraUsuario(userUm)); 
        Assert.assertFalse(gerencia.cadastraUsuario(userDois)); 
    } 
	
	@Test
	public void testaLogin() {
		Assert.assertTrue(gerencia.login(userUm.getEmail(), userUm.getSenha()));
		Assert.assertEquals(userUm, Gerencia.getLogado());

		Assert.assertTrue(gerencia.login(userDois.getEmail(), userDois.getSenha()));
		Assert.assertEquals(userDois, Gerencia.getLogado());

		Assert.assertTrue(gerencia.login(userUm.getEmail(), userUm.getSenha()));
		Assert.assertEquals(userUm, Gerencia.getLogado());

		Assert.assertTrue(gerencia.login(userDois.getEmail(), userDois.getSenha()));
		Assert.assertEquals(userDois, Gerencia.getLogado());
	}

	@Test
	public void testaAdicionaLivro() throws Exception {
		try {
			gerencia.adicionaLivro(new Livro(" ", "Alcione Sales", "Norma", 
					"Suspense", "Um"));
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("nome nao pode ser vazio ou nulo", e.getMessage());
		}

		try {
			gerencia.adicionaLivro(new Livro(null, "Alcione Sales", "Norma",
					"Suspense", "Um"));
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("nome nao pode ser vazio ou nulo", e.getMessage());
		}

		try {
			gerencia.adicionaLivro(new Livro("Monte Santo", "Alcione Sales", 
					" ", "Suspense", "Um"));
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("editora nao pode ser vazio ou nulo", e.getMessage());
		}

		try {
			gerencia.adicionaLivro(new Livro("Monte Santo", "Alcione Sales",
					null, "Suspense", "Um"));
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("editora nao pode ser vazio ou nulo", e.getMessage());
		}

		try {
			gerencia.adicionaLivro(new Livro("Monte Santo", " ", "Norma",
					"Suspense", "Um"));
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("autor nao pode ser vazio ou nulo", e.getMessage());
		}

		try {
			gerencia.adicionaLivro(new Livro("Monte Santo", null, "Norma",
					"Suspense", "Um"));
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("autor nao pode ser vazio ou nulo", e.getMessage());
		}

		try {
			gerencia.adicionaLivro(new Livro("Monte Santo", "Alcione Sales", "Norma",
					" ", "Um"));
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("genero nao pode ser vazio ou nulo", e.getMessage());
		}

		try {
			gerencia.adicionaLivro(new Livro("Monte Santo", "Alcione Sales", "Norma",
					null, "Um"));
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("genero nao pode ser vazio ou nulo", e.getMessage());
		}

		try {
			gerencia.adicionaLivro(new Livro("Monte Santo", "Alcione Sales", "Norma",
					"Suspense", " "));
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("versao nao pode ser vazio ou nulo", e.getMessage());
		}

		try {
			gerencia.adicionaLivro(new Livro("Monte Santo", "Alcione Sales", "Norma",
					"Suspense", null));
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("versao nao pode ser vazio ou nulo", e.getMessage());
		}

		try {
			gerencia.adicionaLivro(new Livro("Monte Santo", "Alcione Sales", "Norma",
					"Suspense", "Um", " "));
			Assert.fail("Esperava excessao.");
		} catch (IOException e) {
			Assert.assertEquals("Arquivo inexistente", e.getMessage());
		}

		try {
			gerencia.adicionaLivro(new Livro("Monte Santo", "Alcione Sales", "Norma",
					"Suspense", "Um", null));
			Assert.fail("Esperava excessao.");
		} catch (IOException e) {
			Assert.assertEquals("Arquivo inexistente", e.getMessage());
		}

		Assert.assertFalse(gerencia.adicionaLivro(new Livro("Monte Santo", "Alcione Sales",
				"Norma", "Suspense", "Um")));
		Assert.assertTrue(gerencia.adicionaLivro(new Livro("Pratica de ensino", "Clemente Lopes",
				"Estudante", "Capacitacao", "Um")));
	}

	@Test
	public void testaGetsGerencia() throws Exception {
		Assert.assertTrue(gerencia.login(userUm.getEmail(), userUm.getSenha()));
		Assert.assertEquals(userUm, Gerencia.getLogado());
		Assert.assertTrue(gerencia.login(userDois.getEmail(), userDois.getSenha()));
		Assert.assertEquals(userDois, Gerencia.getLogado());
		
		Assert.assertTrue(gerencia.adicionaLivro(new Livro("Pratica de ensino", 
				"Clemente Lopes", "Estudante", "Capacitacao", "Um")));
		Assert.assertTrue(gerencia.getItens().containsKey("Monte Santo"));
		Assert.assertTrue(gerencia.getItens().containsKey("Pratica de ensino"));
		Assert.assertFalse(gerencia.getItens().containsKey("Java para novos programadores"));
		
		Assert.assertTrue(gerencia.listaDeLivros().contains(new Livro("Monte Santo",
				"Alcione Sales", "Norma", "Suspense", "Um")));
		Assert.assertTrue(gerencia.listaDeLivros().contains(new Livro("Pratica de ensino",
				"Clemente Lopes", "Estudante", "Capacitacao", "Um")));
		Assert.assertFalse(gerencia.listaDeLivros().contains(new Livro("Hello Word",
				"Analice Sampaio", "Estudante", "Ensino", "Um")));
		
		Assert.assertTrue(gerencia.getCadastros().containsKey("marcosasn@gmail.com"));
		Assert.assertTrue(gerencia.getCadastros().containsKey("rayssanol@gmail.com"));
		Assert.assertFalse(gerencia.getCadastros().containsKey("icaroforte@gmail.com"));
				
		Assert.assertEquals("cadastro.dat", gerencia.getNomeArquivo());
	}

	@Test
	public void testaGetLogado() throws Exception {
		Assert.assertTrue(gerencia.login(userUm.getEmail(), userUm.getSenha()));
		Assert.assertEquals(userUm, Gerencia.getLogado());

		Assert.assertTrue(gerencia.login(userDois.getEmail(), userDois.getSenha()));
		Assert.assertEquals(userDois, Gerencia.getLogado());

		Usuario userTres = new Usuario("Marcelo", "1234567", "marcelocampelo@gmail.com",
				"Rua Seu Assis 160, Jardin America");
		Assert.assertTrue(gerencia.cadastraUsuario(userTres));
		Assert.assertTrue(gerencia.login(userTres.getEmail(), userTres.getSenha()));
		Assert.assertEquals(userTres, Gerencia.getLogado());

		Usuario userQuatro = new Usuario("Marcelina", "1234567", "marcelinasales@gmail.com",
				"Rua Joao Alves, Jardin Paulista");
		Assert.assertTrue(gerencia.cadastraUsuario(userQuatro));
		Assert.assertTrue(gerencia.login(userQuatro.getEmail(), userQuatro.getSenha()));
		Assert.assertEquals(userQuatro, Gerencia.getLogado());
	}

	@Test
	public void testaAlterSenha() throws Exception {
		try {
			gerencia.alteraSenha(new String(" "));
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("senha nao pode ser vazio ou nulo", e.getMessage());
		}

		try {
			gerencia.alteraSenha(null);
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("senha nao pode ser vazio ou nulo", e.getMessage());
		}

		try {
			gerencia.alteraSenha("123");
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("senha nao pode ter tamanho menor que 6", e.getMessage());
		}

		gerencia.alteraSenha(new String("123456789"));
		Assert.assertEquals("123456789", userUm.getSenha());
		gerencia.alteraSenha(new String("123456"));
		Assert.assertEquals("123456", userUm.getSenha());
	}

	@Test
	public void testaAlteraEndereco() throws Exception {
		try {
			gerencia.alteraEndereco(new String(" "));
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("endereco nao pode ser vazio ou nulo", e.getMessage());
		}

		try {
			gerencia.alteraEndereco(null);
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("endereco nao pode ser vazio ou nulo", e.getMessage());
		}

		gerencia.alteraEndereco(new String("Rua Santo Antonio 260, Santo Antonio"));
		Assert.assertEquals("Rua Santo Antonio 260, Santo Antonio", userUm.getEndereco());
		gerencia.alteraEndereco(new String("Rua Joao Alvez Diniz 43, Castelo Branco"));
		Assert.assertEquals("Rua Joao Alvez Diniz 43, Castelo Branco", userUm.getEndereco());
	}

	@Test
	public void testFavoritarItem() throws Exception {
		try {
			gerencia.favoritarItem("Monte Santo", 50);
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("Numero de estrelas de 1 ate 5.", e.getMessage());
		}

		try {
			gerencia.favoritarItem("Monte Santo", 100);
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("Numero de estrelas de 1 ate 5.", e.getMessage());
		}

		try {
			gerencia.favoritarItem("Monte Santo", -5);
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("Numero de estrelas nao pode ser zero ou negativo.", e.getMessage());
		}

		try {
			gerencia.favoritarItem("Monte Santo", -4);
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("Numero de estrelas nao pode ser zero ou negativo.", e.getMessage());
		}

		try {
			gerencia.favoritarItem("Monte Santo", 0);
			Assert.fail("Esperava excessao.");
		} catch (Exception e) {
			Assert.assertEquals("Numero de estrelas nao pode ser zero ou negativo.", e.getMessage());
		}
		
		gerencia.favoritarItem("Monte Santo", 2);
		Assert.assertTrue(gerencia.getItens().get("Monte Santo").getEstrelas() == 2.0);
		
		Assert.assertTrue(gerencia.login(userDois.getEmail(), userDois.getSenha()));
		gerencia.favoritarItem("Monte Santo", 2);
		Assert.assertTrue(gerencia.getItens().get("Monte Santo").getEstrelas() == 2.0);		
	}

	@Test
	public void testaDoarTodosOsItens() throws Exception {		
		Assert.assertEquals(2, Gerencia.getLogado().getListaDeItens().size());
		Assert.assertEquals(0, 
				gerencia.getCadastros().get("rayssanol@gmail.com").getListaDeItens().size());
		
		gerencia.doarTodosOsItens("rayssanol@gmail.com");
		
		Assert.assertEquals(0, Gerencia.getLogado().getListaDeItens().size());
		Assert.assertEquals(2, 
				gerencia.getCadastros().get("rayssanol@gmail.com").getListaDeItens().size());
	}

	@Test
	public void testaDeletarConta() throws Exception {
		Assert.assertFalse(gerencia.deletarConta());
		Assert.assertEquals(2, Gerencia.getLogado().getListaDeItens().size());
		
		Assert.assertTrue(gerencia.cadastraUsuario(new Usuario("Pedro", "12345678",
				"pedrobraz@gmail.com", "Mirante")));
		Assert.assertEquals(0, 
				gerencia.getCadastros().get("pedrobraz@gmail.com").getListaDeItens().size());
		gerencia.doarTodosOsItens("pedrobraz@gmail.com");
		Assert.assertEquals(2, 
				gerencia.getCadastros().get("pedrobraz@gmail.com").getListaDeItens().size());
		
		Assert.assertTrue(gerencia.deletarConta());
		Assert.assertTrue(gerencia.getCadastros().containsKey("pedrobraz@gmail.com"));
		Assert.assertFalse(gerencia.getCadastros().containsKey("marcosasn@gmail.com"));
	}

	@Test
	public void testaPesquisaLivrosPorNome() throws Exception {
		Assert.assertTrue(gerencia.pesquisaLivrosPorNome("Monte Santo").contains(
				new Livro("Monte Santo", "Alcione Sales", "Norma", "Suspense", "Um")));
		Assert.assertTrue(gerencia.pesquisaLivrosPorNome("Harry Potter e a pedra filosofal").contains(
				new Livro("Harry Potter e a pedra filosofal", "J.K.Rolling", "Rocco", "Ficcao", "1")));
		
		Assert.assertFalse(gerencia.pesquisaLivrosPorNome("Java pra iniciantes").contains(
				new Livro("Java pra iniciantes", "Brenda Morais", "Estude", "Ensino", "Um")));
		Assert.assertFalse(gerencia.pesquisaLivrosPorNome("Profissao Professor").contains(
				new Livro("Profissao Professor", "Alberto Jasper", "Estude", "Ensino", "Um")));
	}

	@Test
	public void testaPesquisaLivrosPorAutor() throws Exception {
		Assert.assertTrue(gerencia.pesquisaLivrosPorAutor("Alcione Sales").contains(
				new Livro("Monte Santo", "Alcione Sales", "Norma", "Suspense", "Um")));
		Assert.assertTrue(gerencia.pesquisaLivrosPorAutor("J.K.Rolling").contains(
				new Livro("Harry Potter e a pedra filosofal", "J.K.Rolling","Rocco", "Ficcao", "1")));
		
		Assert.assertFalse(gerencia.pesquisaLivrosPorAutor("Brenda Morais").contains(
				new Livro("Java pra iniciantes", "Brenda Morais", "Estude","Ensino", "Um")));
		Assert.assertFalse(gerencia.pesquisaLivrosPorAutor("Alberto Jasper").contains(
				new Livro("Profissao Professor", "Alberto Jasper", "Estude", "Ensino", "Um")));
	}

	@Test
	public void testaPesquisaLivrosPorEditora() throws Exception {
		Assert.assertTrue(gerencia.pesquisaLivrosPorEditora("Norma").contains(
				new Livro("Monte Santo", "Alcione Sales", "Norma", "Suspense", "Um")));
		Assert.assertTrue(gerencia.pesquisaLivrosPorEditora("Rocco").contains(
				new Livro("Harry Potter e a pedra filosofal", "J.K.Rolling", "Rocco", "Ficcao", "1")));
		
		Assert.assertFalse(gerencia.pesquisaLivrosPorEditora("Estude").contains(
				new Livro("Java pra iniciantes", "Brenda Morais", "Estude", "Ensino", "Um")));
		Assert.assertFalse(gerencia.pesquisaLivrosPorEditora("Estude").contains(
				new Livro("Profissao Professor", "Alberto Jasper", "Estude", "Ensino", "Um")));
	}

	@Test
	public void testaPesquisaLivrosPorGenero() throws Exception {
		Assert.assertTrue(gerencia.pesquisaLivrosPorGenero("Suspense").contains(
				new Livro("Monte Santo", "Alcione Sales", "Norma", "Suspense", "Um")));
		Assert.assertTrue(gerencia.pesquisaLivrosPorGenero("Ficcao").contains(
				new Livro("Harry Potter e a pedra filosofal", "J.K.Rolling", "Rocco", "Ficcao", "1")));
		
		Assert.assertFalse(gerencia.pesquisaLivrosPorGenero("Ensino").contains(
				new Livro("Java pra iniciantes", "Brenda Morais", "Estude", "Ensino", "Um")));
		Assert.assertFalse(gerencia.pesquisaLivrosPorGenero("Ensino").contains(
				new Livro("Profissao Professor", "Alberto Jasper", "Estude", "Ensino", "Um")));
	}

	@Test
	public void testaPesquisaUsuariosPeloEmail() throws Exception {
		Assert.assertTrue(gerencia.pesquisaUsuariosPeloEmail("rayssanol@gmail.com").contains(
				new Usuario("Rayssa", "0811191", "rayssanol@gmail.com", "Walter Soares Andrade 119, JP")));
		Assert.assertTrue(gerencia.pesquisaUsuariosPeloEmail("marcosasn@gmail.com").contains(
				new Usuario("Marcos", "1234567", "marcosasn@gmail.com", "Rua Santo Antonio 260, Centro")));
		
		Assert.assertFalse(gerencia.pesquisaUsuariosPeloEmail("brendabb@gmail.com").contains(
				new Usuario("Brenda", "1234567", "brendabb@gmail.com", "Rua Seu Calixto 361, Centro")));
		Assert.assertFalse(gerencia.pesquisaUsuariosPeloEmail("jakeloren@gmail.com").contains(
				new Usuario("Jakeline", "12345678", "jakeloren@gmail.com", "Rua Joao Pessoa 21, Centro")));
		Assert.assertFalse(gerencia.pesquisaUsuariosPeloEmail("priscillamars@gmail.com").contains(
				new Usuario("Priscilla", "12345678", "priscillamars@gmail.com", "Rua Joao Pessoa 21, Centro")));
	}

	@Test
	public void testaPesquisaUsuariosPeloNome() throws Exception {
		Assert.assertTrue(gerencia.pesquisaUsuariosPeloNome("Marcos").contains(
				new Usuario("Marcos", "1234567", "marcosasn@gmail.com", "Rua Santo Antonio 260, Centro")));
		Assert.assertTrue(gerencia.pesquisaUsuariosPeloNome("Rayssa").contains(
				new Usuario("Rayssa", "0811191", "rayssanol@gmail.com", "Walter Soares Andrade 119, JP")));
		
		Assert.assertFalse(gerencia.pesquisaUsuariosPeloNome("Brenda").contains(
				new Usuario("Brenda", "1234567", "brendabb@gmail.com", "Rua Seu Calixto 361, Centro")));
		Assert.assertFalse(gerencia.pesquisaUsuariosPeloNome("Jakeline").contains(
				new Usuario("Jakeline", "12345678", "jakeloren@gmail.com", "Rua Joao Pessoa 21, Centro")));
		Assert.assertFalse(gerencia.pesquisaUsuariosPeloNome("Priscilla").contains(
				new Usuario("Priscilla", "12345678", "priscillamars@gmail.com", "Rua Joao Pessoa 21, Centro")));
	}
}