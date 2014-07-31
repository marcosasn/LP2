package lp2.lab08;

/*
* Aluno: Marcos Antônio Silva Nascimento
* Matrícula: 112210791
*/

/**Uma classe para criar um Rodoviario
 * 
 * @version 2 de Agosto de 2013
 * @author Marcos Antônio Silva Nascimento
 *
 */
public abstract class Rodoviario extends Contribuinte {
	private double kiloPercorridos;
	
	/**Construtor de rodoviario
	 * 
	 * @param nome O nome do rodoviario
	 * @param numContribuinte O numero de contribuinte do rodoviario
	 * @throws Exception
	 */
	public Rodoviario(String nome, int numContribuinte) throws Exception {
		super(nome, numContribuinte);
	}
	
	/**Modificador de kilometros percorridos
	 * 
	 * @param kilometros Os kilometros percorridos
	 * @throws Exception
	 */
	public void setKiloPercorridos(double kilometros) throws Exception {
		if (kilometros < 0) {
			throw new Exception("Numero em kilometros invalido.");
		}
		kiloPercorridos = kilometros;
	}
	
	/**Acessador de kilometros percorridos
	 * 
	 * @return Os kilometros percorridos
	 */
	public double getKiloPercorridos() {
		return kiloPercorridos;
	}
	
	/**Calcula o desconto
	 * 
	 * @return O valor do desconto
	 */
	public double desconto() {
		return getKiloPercorridos() * 0.01;
	}
}