package lp2.lab08;

/*
* Aluno: Marcos Antônio Silva Nascimento
* Matrícula: 112210791
*/

/**Uma classe para criar um Caminhoneiro
 * 
 * @version 2 de Agosto de 2013
 * @author Marcos Antônio Silva Nascimento
 *
 */
public class Caminhoneiro extends Rodoviario {
	private int toneTransportadas;
	private final int LIMIAR = 10000;
	
	/**Construtor de caminhoneiro
	 * 
	 * @param nome O nome do caminhoneiro
	 * @param numContribuinte O numero de contribuinte do caminhoneiro
	 * @throws Exception
	 */
	public Caminhoneiro(String nome, int numContribuinte) throws Exception {
		super(nome, numContribuinte);
		numContribuintes ++;
	}
	
	/**Modificador de toneladas transportadas
	 * 
	 * @param num O numero de toneladas transportadas
	 * @throws Exception
	 */
	public void setToneTransportadas(int num) throws Exception {
		if (num < 0) {
			throw new Exception("Valor para toneladas invalido.");
		}
		toneTransportadas = num;
	}
	
	/**Acessador de toneladas transportadas
	 * 
	 * @return O numero de toneladas transportadas
	 */
	public int getToneTransportadas() {
		return toneTransportadas;
	}
	
	/**Acessador de limiar
	 * 
	 * @return A limiar de caminhoneiro
	 */
	public int getLimiar() {
		return LIMIAR;
	}
	
	/**Calcula o imposto 
	 * 
	 * @return O valor do imposto
	 */
	public double imposto() {
		if (getToneTransportadas() <= 10) {
			return 500.00;
		}
		return 500.00 + (100 * getToneTransportadas());
	}
}
