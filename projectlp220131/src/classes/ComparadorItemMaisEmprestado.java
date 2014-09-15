package classes;

import java.util.Comparator;

/**
 * Classe responsavel por verificar o item mais emprestado e que implementa a
 * interface Comparator.
 * 
 * @author Icaro Forte, Marcos Antonio, Rayssa Naianny, Wandson Allys
 */
public class ComparadorItemMaisEmprestado implements Comparator<Item> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Item item1, Item item2) {
		return item2.getNumDeEmprestimos() - item1.getNumDeEmprestimos();
	}

}