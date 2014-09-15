package classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Classe desenvolvida para gerar os relatorios referentes as informacoes dos
 * usuarios e dos itens do sistema.
 * 
 * @author Icaro Forte, Marcos Antonio, Rayssa Naianny, Wandson Allys
 * 
 */
public class Relatorios {

	/**
	 * Construtor dos relatorios.
	 */
	public Relatorios() {

	}

	/**
	 * Mostra os 5 primeiros itens favoritos do sistema.
	 */
	public List<String> imprimeTop5ItensFavoritos(HashMap<String, Item> itens) {
		List<Item> lista = new ArrayList<>(itens.values());
		Collections.sort(lista);
		Collections.reverse(lista);
		List<String> saida = new ArrayList<String>();
		if (lista.size() >= 5) {
			for (int i = 0; i < 5; i++) {
				saida.add("Nome = " + lista.get(i).getNome() + ", Estrelas = "
						+ lista.get(i).getEstrelas());
			}
		} else {
			for (int i = 0; i < lista.size(); i++) {
				saida.add("Nome = " + lista.get(i).getNome() + ", Estrelas = "
						+ lista.get(i).getEstrelas());
			}
		}
		return saida;

	}

	/**
	 * Mostra o ranking dos itens emprestados, ordenados de acordo com a
	 * quantidade de emprestimos.
	 */
	public List<String> imprimeRankingDeEmprestimos(HashMap<String, Item> itens) {
		List<Item> lista = new ArrayList<Item>();

		lista.addAll(itens.values());
		Collections.sort(lista, new ComparadorItemMaisEmprestado());
		Collections.reverse(lista);
		List<String> saida = new ArrayList<String>();

		for (Item item : lista) {
			saida.add("Nome = " + item.getNome() + ", Numero de Emprestimos = "
					+ item.getNumDeEmprestimos());
		}
		return saida;
	}

	/**
	 * Mostra os 5 primeiros usuarios que pegaram mais itens.
	 */
	public List<String> imprimeTop5Usuarios(HashMap<String, Usuario> usuarios) {
		List<Usuario> lista = new ArrayList<>(usuarios.values());
		Collections.sort(lista);
		Collections.reverse(lista);
		List<String> saida = new ArrayList<String>();

		if (lista.size() >= 5) {
			for (int i = 0; i < 5; i++) {
				saida.add("Nome = " + lista.get(i).getNome() + ", Email = "
						+ lista.get(i).getEmail() + ", com "
						+ lista.get(i).getQtdDeItens() + " itens no historico.");
			}
		} else {
			for (int i = 0; i < lista.size(); i++) {
				saida.add("Nome = " + lista.get(i).getNome() + ", Email = "
						+ lista.get(i).getEmail() + ", com "
						+ lista.get(i).getQtdDeItens() + " itens no historico.");
			}
		}
		return saida;
	}

}
