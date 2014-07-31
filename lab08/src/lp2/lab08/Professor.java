package lp2.lab08;

/*
* Aluno: Marcos Antônio Silva Nascimento
* Matrícula: 112210791
*/

/**Uma classe para criar um Professor
 * 
 * @version 2 de Agosto de 2013
 * @author Marcos Antônio Silva Nascimento
 *
 */
public class Professor extends Assalariado {
	private double despesas;
	private final int LIMIAR = 10000;
	
	/**Construtor de professor
	 * 
	 * @param nome O nome do professor
	 * @param numContribuinte O numero de contribuinte do professor
	 * @throws Exception
	 */
	public Professor(String nome, int numContribuinte) throws Exception {
		super(nome, numContribuinte);
		numContribuintes ++;
	}
	
	/**Modificador de despesas
	 * 
	 * @param valor O valor de despesas
	 * @throws Exception
	 */
	public void setDespesas(double valor) throws Exception {
		if (valor < 0) {
			throw new Exception("Valor invalido.");
		}
		despesas = valor;
	}
	
	/**Acessador de despesas
	 * 
	 * @return O valor de despesas
	 */
	public double getDespesas() {
		return despesas;
	}
	
	/**Acessador de limiar
	 * 
	 * @return A limiar de professor
	 */
	public int getLimiar() {
		return LIMIAR;
	}
	
	/**Calcula o desconto
	 * 
	 * @return O valor do desconto
	 */
	public double desconto() {
		return 0.5 * getDespesas();
	}
}
