package lp2.lab08;

/*
* Aluno: Marcos Antônio Silva Nascimento
* Matrícula: 112210791
*/

/**Uma classe para criar um Politico
 * 
 * @version 2 de Agosto de 2013
 * @author Marcos Antônio Silva Nascimento
 *
 */
public class Politico extends Assalariado {
	private final int LIMIAR = 500000;
	
	/**Construtor de politico
	 * 
	 * @param nome O nome do politico
	 * @param numContribuinte O numero de contribuinte do politico
	 * @throws Exception
	 */
	public Politico(String nome, int numContribuinte) throws Exception {
		super(nome, numContribuinte);
		numContribuintes ++;
	}
	
	/**Acessador de limiar
	 * 
	 * @return A limiar de Politico
	 */
	public int getLimiar() {
		return LIMIAR;
	}
	
	/**Calcula o desconto
	 * 
	 * @return O valor do desconto
	 */
	public double desconto() {
		return 0.0;
	}
}
