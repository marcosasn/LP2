package classes;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Classe desenvolvida para a criacao de um item e que implementa as interfaces
 * Comparable e Serializable.
 * 
 * @author Icaro Forte, Marcos Antonio, Rayssa Naianny, Wandson Allys
 * 
 */
public abstract class Item implements Comparable<Item>, Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String historicoItem;
	private Usuario usuarioAtual;
	private int numDeEmprestimos;
	private double estrelas;
	private List<Integer> notasDeFavoritar;
	private Set<String> emailsDeFavoritar;
	private boolean disponivel;

	private Calendar data;

	/**
	 * Cria um item a partir do nome.
	 * 
	 * @param nome
	 *            O nome do item.
	 * @throws Exception
	 *             Se o nome for igual a vazio ou null.
	 */
	public Item(String nome) throws Exception {
		isNomeValido(nome);
		data = Calendar.getInstance();
		numDeEmprestimos = 0;
		historicoItem = "";
		notasDeFavoritar = new ArrayList<Integer>();
		emailsDeFavoritar = new HashSet<String>();
		disponivel = false;
	}

	/**
	 * Verifica se o nome do item eh valido.
	 * 
	 * @param nome
	 *            O nome do item.
	 * @throws Exception
	 *             Se o nome do item for vazio ou null.
	 */
	private void isNomeValido(String nome) throws Exception {
		if (nome == null || nome.trim().equals(""))
			throw new Exception("nome nao pode ser vazio ou nulo");
		this.nome = nome;
	}

	/**
	 * Verifica se o usuario possui dados validos para que possa acessar o
	 * sistema.
	 * 
	 * @param usuarioAtual
	 *            O usuario atual.
	 * @throws Exception
	 *             Se o usuario for igual a null.
	 */
	private void isUsuarioAtualValido(Usuario usuarioAtual) throws Exception {
		if (usuarioAtual == null)
			throw new Exception("usuario nao pode ser nulo");
		this.usuarioAtual = usuarioAtual;
	}

	/**
	 * Recupera a data correspondente ao dia do emprestimo do item.
	 * 
	 * @return A data do emprestimo.
	 */
	public Calendar getData() {
		return data;
	}

	/**
	 * Recupera o valor das estrelas atribuidas a um item.
	 * 
	 * @return O valor das estrelas.
	 */
	public double getEstrelas() {
		return estrelas;
	}

	/**
	 * Recupera o nome do item.
	 * 
	 * @return O string referente ao nome do item.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Recupera o numero de emprestimos de um item.
	 * 
	 * @return O inteiro correspondente a quantidade de emprestimos de um item.
	 */
	public int getNumDeEmprestimos() {
		return numDeEmprestimos;
	}

	/**
	 * Recupera o usuario atual.
	 * 
	 * @return O usuario atual.
	 */
	public Usuario getUsuarioAtual() {
		return usuarioAtual;
	}

	/**
	 * Modifica o usuario que possui o item.
	 * 
	 * @param usuario
	 *            O usuario que passará a ter o item.
	 * @throws Exception
	 *             Se o usuario for igual a null.
	 */
	public void setUsuarioAtual(Usuario usuario) throws Exception {
		isUsuarioAtualValido(usuario);
		data = Calendar.getInstance();
		geraHistoricoItem(usuario);
	}

	/**
	 * Favorita um item que se encontra no sistema e calcula a media de estrelas
	 * de um determinado item.
	 * 
	 * @param valor
	 *            O valor que o usuario ira informar para favoritar o item.
	 * @throws Exception
	 *             Se o item ja foi favoritado anteriormente e se o valor a ser
	 *             favoritado for menor ou igual a 0, ou maior que 5.
	 */
	public void favoritar(int valor) throws Exception {
		if (emailsDeFavoritar.contains(Gerencia.getLogado().getEmail()))
			throw new Exception("Usuario ja favoritou o item");
		if (valor <= 0)
			throw new Exception(
					"Numero de estrelas nao pode ser zero ou negativo.");
		if (valor > 5)
			throw new Exception("Numero de estrelas de 1 ate 5.");

		double contador = 0;
		emailsDeFavoritar.add(Gerencia.getLogado().getEmail());
		notasDeFavoritar.add(valor);

		for (int nota : notasDeFavoritar) {
			contador += nota;
		}

		estrelas = contador / notasDeFavoritar.size();
	}

	/**
	 * Metodo para formatar o string da data.
	 * 
	 * @return O string da data.
	 */
	public String dataFormatada() {
		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
		return dataFormatada.format(data.getTime());
	}

	/**
	 * Recupera o historico do item do sistema.
	 * 
	 * @return O string referente ao historico do item.
	 */
	public String getHistoricoItem() {
		return historicoItem;
	}

	/**
	 * Gera um historico do item de um usuario.
	 * 
	 * @param usuario
	 *            O usuario incluso no sistema.
	 */
	public void geraHistoricoItem(Usuario usuario) {
		this.historicoItem += "Nome: " + usuario.getNome() + " E-mail: "
				+ usuario.getEmail() + " Data: " + dataFormatada() + "\n";

	}

	/**
	 * Verifica se o item esta disponivel no sistema para ser emprestado.
	 * 
	 * @return Se o item estiver disponivel retorna 'true', caso contrario
	 *         retorna 'false'.
	 */
	public boolean isDisponivel() {
		return disponivel;
	}

	/**
	 * Modifica o status do item, passando a ser disponivel ou indisponivel.
	 * 
	 * @param disponivel
	 *            Indica a disponiblidade do item, se for 'false' o item nao
	 *            esta disponivel e se for 'true' esta disponivel.
	 * @param usuario
	 *            O usuario que ira modificar o status do item.
	 * @throws Exception
	 *             Se o usuario for vazio ou se o item nao estiver no dominio do
	 *             usuario.
	 */
	public void setDisponivel(boolean disponivel, Usuario usuario)
			throws Exception {
		if (usuario == null)
			throw new Exception("usuario nao pode ser vazio");
		if (!(getUsuarioAtual().equals(usuario)))
			throw new Exception("O item nao está no dominio do usuario");
		this.disponivel = disponivel;
	}

}