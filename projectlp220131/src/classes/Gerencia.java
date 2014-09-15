package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Classe que gerencia todos os componentes participantes da biblioteca como: os
 * usuarios, os itens e as operacoes realizadas entre eles.
 * 
 * @author Icaro Forte, Marcos Antonio, Rayssa Naianny, Wandson Allys
 */
public class Gerencia {

	private HashMap<String, Item> itens;
	private HashMap<String, Usuario> cadastros;
	private static Usuario logado;
	private Relatorios relatorios;
	private boolean aberto = false;

	public Gerencia() {
		itens = new HashMap<String, Item>();
		cadastros = new HashMap<String, Usuario>();
		relatorios = new Relatorios();
		logado = null;
	}

	/**
	 * Cadastra o usuario no sistema da biblioteca.
	 * 
	 * @param usuario
	 *            O usuario a ser cadastrado.
	 * @return Se o email nao estiver sido cadastrado anteriormente e realizado
	 *         o cadastro do usuario e retornado 'true', caso contrario retorna
	 *         'false'.
	 * 
	 * @throws Exception
	 *             Se o nome, endereco, email ou senha forem igual a null ou
	 *             vazio e se a senha do email ter tamanho menor que 6.
	 */
	public boolean cadastraUsuario(Usuario usuario) throws Exception {
		if (!(cadastros.containsKey(usuario.getEmail()))) {
			cadastros.put(usuario.getEmail(), usuario);
			return true;
		}
		return false;
	}

	/**
	 * Verifica se os dados do login sao validos.
	 * 
	 * @param email
	 *            O email do usuario.
	 * @param senha
	 *            A senha do usuario.
	 * @return Se o email do usuario se encontra no sistema e se a senha
	 *         correspondente ao email estiver correta, o login e valido e
	 *         retorna 'true', caso contrario retorna 'false'.
	 */
	public boolean login(String email, String senha) {

		boolean loginInvalido = false;

		if (cadastros.containsKey(email)) {
			if (cadastros.get(email).getSenha().equals(senha)) {
				logado = cadastros.get(email);
				return true;
			}
			return loginInvalido;
		}
		return loginInvalido;
	}

	/**
	 * Adiciona o item do tipo livro ao sistema.
	 * 
	 * @param livro
	 *            O livro a ser adicionado.
	 * @return Se o livro nao se encontrar no sistema, e adicionado na lista de
	 *         livros do usuario logado no momento e retorna 'true', caso
	 *         contrario retorna 'false'.
	 * @throws Exception
	 *             Se o autor, genero, editora ou a versao forem iguais a null
	 *             ou vazio.
	 */
	public boolean adicionaLivro(Livro livro) throws Exception {
		if (!(itens.containsKey(livro.getNome()))) {
			itens.put(livro.getNome(), livro);
			logado.adicionaItem(livro);
			return true;
		}
		return false;
	}

	/**
	 * Recupera a lista de livros da biblioteca.
	 * 
	 * @return A lista de livros que foram cadastrados.
	 */
	public List<Livro> listaDeLivros() {
		List<Livro> livros = new ArrayList<Livro>();

		for (Item item : itens.values()) {
			if (item instanceof Livro)
				livros.add((Livro) item);
		}
		return livros;
	}

	/**
	 * Recupera os itens compostos no sistema.
	 * 
	 * @return Os itens do sistema.
	 */
	public HashMap<String, Item> getItens() {
		return itens;
	}

	/**
	 * Recupera os usuarios cadastros no sistema.
	 * 
	 * @return Os usuarios cadatrados.
	 */
	public HashMap<String, Usuario> getCadastros() {
		return cadastros;
	}

	/**
	 * Recupera o usuario logado no momento.
	 * 
	 * @return O usuario logado.
	 */
	public static Usuario getLogado() {
		return logado;
	}

	/**
	 * Modifica o usuario logado no sistema.
	 * 
	 * @param novoUsuario
	 *            O novo usuario que irá logar no sistema.
	 */
	public void setLogado(Usuario novoUsuario) {
		logado = novoUsuario;
	}

	/**
	 * Altera a senha do usuario ques esta logado no sistema.
	 * 
	 * @param senha
	 *            A nova senha do usuario.
	 * @throws Exception
	 *             Se a senha e vazia ou menor que 6.
	 */
	public void alteraSenha(String senha) throws Exception {
		logado.setSenha(senha);
	}

	/**
	 * Altera o endereco do usuario.
	 * 
	 * @param endereco
	 *            O novo endereco do usuario.
	 * @throws Exception
	 *             Se o endereco for igual a vazio ou null.
	 */
	public void alteraEndereco(String endereco) throws Exception {
		logado.setEndereco(endereco);
	}

	/**
	 * Permite que um usuario pegue um item no sistema a partir do nome do item.
	 * Se o item se encontra no sistema, o mesmo é removido da lista do usuario
	 * atual e adicionado a lista do usuario que pediu emprestado.
	 * 
	 * @param nome
	 *            O nome do item.
	 * @throws Exception
	 *             Se o usuario for igual a null.
	 */
	public void pegarItem(String nome) throws Exception {
		itens.get(nome).getUsuarioAtual().removeItem(nome);
		logado.adicionaItem(itens.get(nome));
		itens.get(nome).setUsuarioAtual(logado);
	}

	/**
	 * Permite favoritar um item do sistema.
	 * 
	 * @param nome
	 *            O nome do item.
	 * @param valor
	 *            O valor para favoritar.
	 * @throws Exception
	 *             Se o item ja foi favoritado anteriormente e se os valores
	 *             passados pelo usuario forem menor ou igual a 0 e maior que 5.
	 */
	public void favoritarItem(String nome, int valor) throws Exception {
		itens.get(nome).favoritar(valor);
	}

	/**
	 * Metodo para doar todos os itens de um usuario para outro que esteja
	 * cadastrado no sistema.
	 * 
	 * @param email
	 *            O email do usuario que ira receber os itens.
	 * @throws Exception
	 */
	public void doarTodosOsItens(String email) throws Exception {

		for (int i = logado.getListaDeItens().size() - 1; i >= 0; i--) {
			cadastros.get(email).adicionaItem(
					itens.get(logado.getListaDeItens().get(i)));
			logado.removeItem(logado.getListaDeItens().get(i));
		}
	}

	/**
	 * Deleta a conta do usuario logado no sistema.
	 * 
	 * @return Se a lista de itens do usuario estiver vazia sua conta e removida
	 *         e retorna 'true', se na lista existir itens, sua conta nao e
	 *         deletada, para isso e preciso doar todos os itens a um usuario do
	 *         sistema.
	 */
	public boolean deletarConta() {
		if (logado.getListaDeItens().size() > 0) {
			return false;
		}
		cadastros.remove(logado.getEmail());
		return true;
	}

	/**
	 * Mostra os 5 primeiros itens favoritos do sistema.
	 */
	public void imprimeTop5ItensFavoritos() {
		relatorios.imprimeTop5ItensFavoritos(itens);
	}

	/**
	 * Mostra o ranking dos itens emprestados, ordenados de acordo com a
	 * quantidade de emprestimos.
	 */
	public void imprimeRankingDeEmprestimos() {
		relatorios.imprimeRankingDeEmprestimos(itens);
	}

	/**
	 * Mostra os 5 primeiros usuarios que pegaram mais itens.
	 */
	public void imprimeTop5Usuarios() {
		relatorios.imprimeTop5Usuarios(cadastros);
	}

	/**
	 * Pesquisa livros que se encontram no sistema pelo nome.
	 * 
	 * @param nome
	 *            O String a ser pesquisado nas informacoes dos livros.
	 * @return Os livros cadastrados no sistema.
	 */
	public List<Livro> pesquisaLivrosPorNome(String nome) {
		List<Livro> encontrados = new ArrayList<Livro>();

		for (Livro livro : listaDeLivros()) {
			if (livro.getNome().toLowerCase().contains(nome.toLowerCase()))
				encontrados.add(livro);
		}
		return encontrados;
	}

	/**
	 * Pesquisa livros que se encontram no sistema pelo autor.
	 * 
	 * @param autor
	 *            O string a ser pesquisado nas informacoes dos livros.
	 * @return Os livros encontrados no sistema que possuem como autor o mesmo
	 *         passado pelo parametro.
	 */
	public List<Livro> pesquisaLivrosPorAutor(String autor) {
		List<Livro> encontrados = new ArrayList<Livro>();

		for (Livro livro : listaDeLivros()) {
			if (livro.getAutor().toLowerCase().contains(autor.toLowerCase()))
				encontrados.add(livro);
		}
		return encontrados;
	}

	/**
	 * Pesquisa livros que se encontram no sistema pela editora.
	 * 
	 * @param editora
	 *            O string a ser pesquisado nas informacoes dos livros.
	 * @return Os livros que possuem a mesma editora passado pelo parametro.
	 */
	public List<Livro> pesquisaLivrosPorEditora(String editora) {
		List<Livro> encontrados = new ArrayList<Livro>();

		for (Livro livro : listaDeLivros()) {
			if (livro.getEditora().toLowerCase()
					.contains(editora.toLowerCase()))
				encontrados.add(livro);
		}
		return encontrados;
	}

	/**
	 * Pesquisa livros que se encontram no sistema pelo genero.
	 * 
	 * @param genero
	 *            O String a ser pesquisado nas informacoes dos livros.
	 * @return Os livros que possuem o mesmo genero que foi passado como
	 *         parametro.
	 */
	public List<Livro> pesquisaLivrosPorGenero(String genero) {
		List<Livro> encontrados = new ArrayList<Livro>();

		for (Livro livro : listaDeLivros()) {
			if (livro.getGenero().toLowerCase().equals(genero.toLowerCase()))
				encontrados.add(livro);
		}
		return encontrados;
	}

	/**
	 * Pesquisa usuarios no sistema atraves do email.
	 * 
	 * @param email
	 *            O termo a ser pesquisado nas informacoes dos usuarios.
	 * @return Os usuarios encontrados no sistema.
	 */
	public List<Usuario> pesquisaUsuariosPeloEmail(String email) {
		List<Usuario> encontrados = new ArrayList<Usuario>();

		for (Usuario usuario : getCadastros().values()) {
			if (usuario.getEmail().toLowerCase().equals(email.toLowerCase()))
				encontrados.add(usuario);
		}
		return encontrados;
	}

	/**
	 * Pesquisa usuarios no sistema pelo nome.
	 * 
	 * @param nome
	 *            O termo a ser pesquisado nas informacoes dos usuarios.
	 * @return Os usuarios encontrados no sistema que tenham o mesmo nome do que
	 *         foi passado por parametro.
	 */
	public List<Usuario> pesquisaUsuariosPeloNome(String nome) {
		List<Usuario> encontrados = new ArrayList<Usuario>();

		for (Usuario usuario : getCadastros().values()) {
			if (usuario.getNome().toLowerCase().contains(nome.toLowerCase()))
				encontrados.add(usuario);
		}
		return encontrados;
	}

	/**
	 * Metodo responsavel por salvar e gravar as informacoes do sistema.
	 */

	@SuppressWarnings("rawtypes")
	public void serializar() {

		List<HashMap> tudo = new ArrayList<>();
		tudo.add(itens);
		tudo.add(cadastros);
		ObjectOutputStream out = null;
		try {
			try {
				out = new ObjectOutputStream(new FileOutputStream(new File(
						getNomeArquivo())));
			} catch (IOException ex) {
				System.err.print(ex.getMessage());
				System.exit(1);
			}
			out.writeObject(tudo);
			out.close();
		} catch (IOException ex) {
			System.err.print(ex.getMessage());
			System.exit(1);
		}
	}

	/**
	 * Captura as informacoes do sistema gravadas em um arquivo.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void deserializar() {

		if (aberto) {
			return;
		}
		itens = new HashMap<String, Item>();
		cadastros = new HashMap<String, Usuario>();

		aberto = true;
		ObjectInputStream in = null;
		try {
			try {
				in = new ObjectInputStream(
						new FileInputStream(getNomeArquivo()));
			} catch (FileNotFoundException e) {
				return;
			}
			List<HashMap> tudo = (ArrayList<HashMap>) in.readObject();
			itens = tudo.get(0);
			cadastros = tudo.get(1);
			in.close();
		} catch (IOException | ClassNotFoundException e) {
			System.err.println(e);
			System.exit(1);
		}

	}

	/**
	 * Recupera o nome do arquivo que guarda as informacoes do sistema.
	 * 
	 * @return O nome do arquivo.
	 */
	public String getNomeArquivo() {
		return "cadastro.dat";
	}

	/**
	 * Envia uma indicacao de um item para um usuario do sistema.
	 * 
	 * @param receptor
	 *            O usuario que ira receber a mensagem de indicacao.
	 * @param item
	 *            O item referente a indicacao.
	 * @param mensagem
	 *            A mensagem que sera enviada ao usuario.
	 * @throws Exception
	 *             Se a indicacao for vazia ou nula.
	 */
	public void enviarIndicacaoItem(Usuario receptor, Item item, String mensagem)
			throws Exception {
		receptor.getInbox().recebeIndicacao(
				new SistemaDeIndicacao(getLogado(), item, mensagem));
	}

	/**
	 * Recupera os relatorios do sistema.
	 * 
	 * @return Os relatorios encontrados no sistema.
	 */
	public Relatorios getRelatorios() {
		return relatorios;
	}
}