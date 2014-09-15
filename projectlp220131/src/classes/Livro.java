package classes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import javax.imageio.ImageIO;

/**
 * Classe desenvolvida para criacao de um livro, que extende a classe Item e
 * implementa a interface Serializable.
 * 
 * @author Icaro Forte, Marcos Antonio, Rayssa Naianny, Wandson Allys
 */
public class Livro extends Item implements Serializable {

	private static final long serialVersionUID = 1L;

	private String autor;
	private String editora;
	private String versao;
	private String genero;
	private BufferedImage capa;

	/**
	 * Cria um livro a partir de informacoes como: nome, autor, editora, genero,
	 * versao.
	 * 
	 * @param nome
	 *            O nome do livro.
	 * @param autor
	 *            O autor do livro.
	 * @param editora
	 *            A editora do livro.
	 * @param genero
	 *            O genero do livro.
	 * @param versao
	 *            A versao do livro.
	 * @throws Exception
	 *             Se o autor, genero, editora ou a versao forem iguais a null
	 *             ou vazio.
	 */
	public Livro(String nome, String autor, String editora, String genero,
			String versao) throws Exception {
		super(nome);
		isAutorValido(autor);
		isEditoraValida(editora);
		isGeneroValido(genero);
		isVersaoValida(versao);
	}

	/**
	 * Cria um livro a partir de um nome, autor, editora, genero, versao e capa.
	 * 
	 * @param nome
	 *            O nome do livro.
	 * @param autor
	 *            O nome do autor.
	 * @param editora
	 *            A editora do livro.
	 * @param genero
	 *            O genero do livro.
	 * @param versao
	 *            A versao do livro.
	 * @param capa
	 *            O string correspondente a capa do livro.
	 * @throws Exception
	 *             Se o autor, genero, editora, versao ou a capa forem iguais a
	 *             null ou vazio.
	 */
	public Livro(String nome, String autor, String editora, String genero,
			String versao, String capa) throws Exception {
		this(nome, autor, editora, genero, versao);
		isCapaValida(capa);
	}

	/**
	 * Verifica se o nome do autor eh valido.
	 * 
	 * @param autor
	 *            O nome do autor.
	 * @throws Exception
	 *             Se o nome for igual a null ou vazio.
	 */
	private void isAutorValido(String autor) throws Exception {
		if (autor == null || autor.trim().equals(""))
			throw new Exception("autor nao pode ser vazio ou nulo");
		this.autor = autor;
	}

	/**
	 * Verifica se o nome da editora do livro eh valido.
	 * 
	 * @param editora
	 *            A editora do livro.
	 * @throws Exception
	 *             Se o nome da editora for null ou vazio.
	 */
	private void isEditoraValida(String editora) throws Exception {
		if (editora == null || editora.trim().equals(""))
			throw new Exception("editora nao pode ser vazio ou nulo");
		this.editora = editora;
	}

	/**
	 * Verifica se a versao do livro eh um nome valido.
	 * 
	 * @param versao
	 *            A versao do livro.
	 * @throws Exception
	 *             Se a versao for igual a null ou vazio.
	 */
	private void isVersaoValida(String versao) throws Exception {
		if (versao == null || versao.trim().equals(""))
			throw new Exception("versao nao pode ser vazio ou nulo");

		this.versao = versao;
	}

	/**
	 * Verifica se o nome do genero do livro eh valido.
	 * 
	 * @param genero
	 *            O genero do livro.
	 * @throws Exception
	 *             Se o nome do genero for igual a null ou vazio.
	 */
	private void isGeneroValido(String genero) throws Exception {
		if (genero == null || genero.trim().equals(""))
			throw new Exception("genero nao pode ser vazio ou nulo");
		this.genero = genero;
	}

	/**
	 * Se o nome da capa eh valido.
	 * 
	 * @param capa
	 *           O string correspondente a capa do livro.
	 * @throws FileNotFoundException
	 *             Se o arquivo nao existir.
	 * @throws IOException
	 *             Ocorrer uma falha ou interrupcao de entrada entrada ou saida.
	 */
	private void isCapaValida(String capa) throws FileNotFoundException,
			IOException {
		if (capa == null || capa.trim().equals(""))
			throw new FileNotFoundException("Arquivo inexistente");
		this.capa = ImageIO.read(new File(capa));
	}

	/**
	 * Recupera o genero do livro.
	 * 
	 * @return O string referente ao genero do livro.
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * Recupera o autor do livro.
	 * 
	 * @return O string referente ao autor do livro.
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * Recupera a editora do livro.
	 * 
	 * @return O string referente a editora do livro.
	 */
	public String getEditora() {
		return editora;
	}

	/**
	 * Recupera a versao do livro.
	 * 
	 * @return O string da versao do livro.
	 */
	public String getVersao() {
		return versao;
	}

	/**
	 * Recupera a capa do livro.
	 * 
	 * @return A imagem da capa do livro.
	 */
	public BufferedImage getCapa() {
		return capa;
	}

	/**
	 * Modifica a capa do livro.
	 * 
	 * @param capa
	 *            O string correspondente a capa do livro.
	 * @throws IOException
	 *             Ocorrer uma falha ou interrupcao de entrada ou saida.
	 * 
	 */
	public void setCapa(String capa) throws IOException {
		isCapaValida(capa);
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Livro [Titulo=" + getNome() + ", Autor=" + getAutor()
				+ ", Editora=" + getEditora() + ", Versao=" + getVersao()
				+ ", Genero=" + getGenero() + "]";
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((getAutor() == null) ? 0 : getAutor().hashCode());
		result = prime * result
				+ ((getNome() == null) ? 0 : getNome().hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Livro) {
			Livro objeto = (Livro) obj;
			return getNome().equals(objeto.getNome())
					&& getAutor().equals(objeto.getAutor());
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Item item) {
		if (getEstrelas() > item.getEstrelas())
			return 1;
		else if (getEstrelas() < item.getEstrelas())
			return -1;
		return 0;
	}

}
