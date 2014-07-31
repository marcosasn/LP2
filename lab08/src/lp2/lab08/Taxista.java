package lp2.lab08;

/*
* Aluno: Marcos Antônio Silva Nascimento
* Matrícula: 112210791
*/

/**Uma classe para criar um Taxista
 * 
 * @version 2 de Agosto de 2013
 * @author Marcos Antônio Silva Nascimento
 *
 */
public class Taxista extends Rodoviario {
	private int numPassageiros;
	private final int LIMIAR = 5000;
	
	/**Construtor de taxista
	 * 
	 * @param nome O nome do taxista
	 * @param numContribuinte O numero de contribuinte do taxista
	 * @throws Exception
	 */
	public Taxista(String nome, int numContribuinte) throws Exception {
		super(nome, numContribuinte);
		numContribuintes ++;
	}
	
	/**Modificador de numero de passageiros
	 * 
	 * @param num O numero de passageiros
	 * @throws Exception
	 */
	public void setNumPassageiros(int num) throws Exception {
		if (num < 0) {
			throw new Exception("Numero de passageiros ivalido.");
		}
		numPassageiros = num;
	}
	
	/**Acessador de numero de passageiros
	 * 
	 * @return O numero de passageiros
	 */
	public int getNumPassageiros() {
		return numPassageiros;
	}
	
	/**Acessador de limiar
	 * 
	 * @return A limiar de taxista
	 */
	public int getLimiar() {
		return LIMIAR;
	}
	
	/**Calcula o imposto
	 * 
	 * @return O valor do imposto
	 */
	public double imposto() {
		return numPassageiros * 0.5;
	}
}
