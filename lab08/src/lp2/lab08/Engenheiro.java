package lp2.lab08;

/*
* Aluno: Marcos Antônio Silva Nascimento
* Matrícula: 112210791
*/

/**Uma classe para criar um Engenheiro
 * 
 * @version 2 de Agosto de 2013
 * @author Marcos Antônio Silva Nascimento
 *
 */
public class Engenheiro extends Contribuinte {
	private int numProjetos;
	private double despesas;
	private final int LIMIAR = 20000;
	
	/**Construtor de engenheiro
	 * 
	 * @param nome O nome do engenheiro
	 * @param numContribuinte O numero de contribuinte do engenheiro
	 * @throws Exception
	 */
	public Engenheiro(String nome, int numContribuinte) throws Exception {
		super(nome, numContribuinte);
		numContribuintes ++;
	}
	
	/**Modificador do numero de projetos
	 * 
	 * @param num O numero de projetos
	 * @throws Exception
	 */
	public void setNumProjetos(int num) throws Exception {
		if (num <= 0) {
			throw new Exception("Numero invalido.");
		}
		numProjetos = num;
	}
	
	/**Acessador do numero de projetos
	 * 
	 * @return O numero de projetos
	 */
	public int getNumProjetos() {
		return numProjetos;
	}
	
	/**Modificador do valor de despesas 
	 * 
	 * @param valor O valor das despesas
	 * @throws Exception
	 */
	public void setDespesas(double valor) throws Exception  {
		if (valor < 0) {
			throw new Exception("Valor invalido.");
		}
		despesas = valor;
	}
	
	/**Acessador do valor de despesas
	 * 
	 * @return O valor de despesas
	 */
	public double getDespesas() {
		return despesas;
	}
	
	/**Acessador de limiar
	 * 
	 * @return A limiar de engenheiro
	 */
	public int getLimiar() {
		return LIMIAR;
	}

	/**Calcula o desconto
	 * 
	 * @return O valor do desconto
	 */
	public double desconto() {
		return getDespesas() * 0.2;
	}
	
	/**Calcula o imposto
	 * 
	 * @return O valor do imposto
	 */
	public double imposto() {
		return getNumProjetos() * 1000;
	}
}
