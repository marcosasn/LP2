package lp2.lab08;

/*
* Aluno: Marcos Antônio Silva Nascimento
* Matrícula: 112210791
*/

/**Uma classe para criar um Medico
 * 
 * @version 2 de Agosto de 2013
 * @author Marcos Antônio Silva Nascimento
 *
 */
public class Medico extends Contribuinte {
	private int numClientes;
	private double despesas;
	private final int LIMIAR = 100000;
	
	/**Construtor de medico
	 * 
	 * @param nome O nome do medico
	 * @param numContribuinte O numero do contribuinte do medico
	 * @throws Exception
	 */
	public Medico(String nome, int numContribuinte) throws Exception {
		super(nome, numContribuinte);
		numContribuintes ++;
	}
	
	/**Modificador do numero de clientes
	 * 
	 * @param num O numero de clientes
	 * @throws Exception
	 */
	public void setNumClientes(int num) throws Exception {
		if (num < 0) {
			throw new Exception("Numero invalido.");
		}
		numClientes = num;
	}
	
	/**Acessador do numero de clientes
	 * 
	 * @return O numero de clientes
	 */
	public int getNumClientes() {
		return numClientes;
	}
	
	/**Modificador do valor de despesas
	 * 
	 * @param valor O valor das despesas
	 * @throws Exception
	 */
	public void setDespesas(double valor) throws Exception {
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
	 * @return A limiar de Medico
	 */
	public int getLimiar() {
		return LIMIAR;
	}
	
	/**Calcula o desconto
	 * 
	 * @return O valor do desconto
	 */
	public double desconto() {
		return getDespesas();
	}
	
	/**Calcula o imposto
	 * 
	 * @return O valor do imposto
	 */
	public double imposto() {
		return getNumClientes() * 10.0;
	}
}
