package lp2.lab08;

/*
* Aluno: Marcos Antônio Silva Nascimento
* Matrícula: 112210791
*/

/**Uma classe para criar um Assalariado
 * 
 * @version 2 de Agosto de 2013
 * @author Marcos Antônio Silva Nascimento
 *
 */
public abstract class Assalariado extends Contribuinte {
	private double salario;
	
	/**Construtor de assalariado
	 * 
	 * @param nome O nome do assalariado
	 * @param numContribuinte O numero de contribuinte do assalariado
	 * @throws Exception
	 */
	public Assalariado(String nome, int numContribuinte) throws Exception {
		super(nome, numContribuinte);
	}
	
	/**Modificador de salario
	 * 
	 * @param valor O valor do salario
	 * @throws Exception
	 */
	public void setSalario(double valor) throws Exception {
		if (valor < 0) {
			throw new Exception("Valor invalido.");
		}
		salario = valor;
	}
	
	/**Acessador de salario
	 * 
	 * @return O salario
	 */
	public double getSalario() {
		return salario;
	}
	
	/**Calcula o imposto
	 * 
	 * @return O valor do imposto
	 */
	public double imposto() {
		return getSalario() * 0.1;
	}
}
