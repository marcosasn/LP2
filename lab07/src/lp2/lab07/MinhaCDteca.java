package lp2.lab07;

import java.util.ArrayList;

/*

 * Aluno: Marcos Antônio Silva Nascimento

 * Matricula: 112210791

 */

/**Uma classe para criar um objeto do tipo CD teca
 * 
 * @version 20 de Julho de 2013
 * @author Marcos Antônio Silva Nascimento
 *
 */
public class MinhaCDteca {
	private ArrayList<CD> cds;
	private String stringCds; 
	
	/**Construtor de MinhaCDteca
	 * 
	 */
	public MinhaCDteca() {
		cds = new ArrayList();
	}
	
	/**Metodo que adiciona um CD a colecao
	 * 
	 * @param cd O CD a ser adicionado
	 */
	public void adicionaCD(CD cd) {
		cds.add(cd);
	}
	
	/**Metodo que remove um CD da colecao
	 * 
	 * @param titulo Representa o titulo do CD que se deseja remover
	 * @return O CD removido
	 */
	public CD removeCD(String titulo) {
		for (int i = 0; i < cds.size(); i ++) {
			if (cds.get(i).getTitulo().toLowerCase().equals(titulo.toLowerCase())) {
				return cds.remove(i);
			}
		}
		return null;
	}
	
	/**Metodo que pesquisa um CD na colecao
	 * 
	 * @param titulo O titulo do CD que se deseja
	 * @return O CD respectivo
	 */
	public CD pesquisaCD(String titulo) {
		for (int i = 0; i < cds.size(); i++) {
			if (cds.get(i).getTitulo().toLowerCase().equals(titulo.toLowerCase())) {
				return cds.get(i);
			}
		}
		return null;
	}
	
	/**Metodo que retorna o numero de CDs da colecao
	 * 
	 * @return O numero de CDs
	 */
	public int numeroDeCDs() {
		return cds.size();
	}
	
	/**Metodo que imprime a colecao de CDs
	 * 
	 */
	public String toString() {
		stringCds = "";
		for (int i = 0; i < cds.size(); i++) {
			if (i == cds.size()-1) {
				stringCds += cds.get(i).toString(); 
			}
			else {
				stringCds += cds.get(i).toString() + "\n";
			}
		}
		return stringCds;
	}
	
	/**Metodo que verifica se uma colecao de CDs e igual a outra colecao de CDs
	 * 
	 */
	public boolean equals(Object colecao) {
		if (!(colecao instanceof MinhaCDteca)) {
			return false;
		}
		MinhaCDteca cds_dois = (MinhaCDteca) colecao;
		if (cds_dois.numeroDeCDs() != cds.size()) {
			return false;
		}
		else{
			for(int i = 0; i < cds.size(); i++) {
				if (!(cds.contains(cds_dois.getCD(i)))) {
					return false;	
				}	
			}
		}
		return true;
	}
	
	private CD getCD(int indice) {
		return cds.get(indice);
	}
}