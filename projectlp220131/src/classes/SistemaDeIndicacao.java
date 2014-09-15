package classes;

import java.io.Serializable;

/**
 * Sistema de indicação de itens, que proporciona iteracao entre usuarios da
 * biblioteca.
 * 
 * @author Icaro Forte, Marcos Antonio, Rayssa Naianny, Wandson Allys
 */

public class SistemaDeIndicacao implements Serializable {

	private static final long serialVersionUID = 1L;

	private final Item ITEM;
	private final String MENSAGEM;
	private final Usuario INDICADOR;

	/**
	 * Construtor de uma indicacao
	 * 
	 * @param indicador
	 *            - Eh o usuario que esta enviando a indicacao do item.
	 * @param item
	 *            - Objeto do tipo Item a ser indicado.
	 * @param mensagem
	 *            - Mensagem opcional para a indicao.
	 * @throws Exception
	 *             Se o usuario que ira indicar o item for vazio ou nulo e se o
	 *             item a ser indicado for nulo.
	 */
	public SistemaDeIndicacao(Usuario indicador, Item item, String mensagem)
			throws Exception {
		if (indicador == null)
			throw new Exception("usuario nao pode ser nulo");
		if (item == null)
			throw new Exception("item nao pode ser nulo");
		this.INDICADOR = indicador;
		this.ITEM = item;
		this.MENSAGEM = mensagem;
	}

	/**
	 * Recupera o usuario que indicou o item.
	 * 
	 * @return O usuario que fez a indicacao do item.
	 */
	public Usuario getINDICADOR() {
		return INDICADOR;
	}

	/**
	 * Recupera o item que sera indicado.
	 * 
	 * @return O item a ser indicado.
	 */
	public Item getITEM() {
		return ITEM;
	}

	/**
	 * Recupera a mensagem de indicacao.
	 * 
	 * @return O string referente a mensagem de indicacao.
	 */
	public String getMENSAGEM() {
		return MENSAGEM;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Sr(a) " + INDICADOR + ", indicou o item " + ITEM
				+ " para voce.\n" + "Mensagem : " + MENSAGEM;
	}

}