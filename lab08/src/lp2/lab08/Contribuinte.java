package lp2.lab08;

/*
* Aluno: Marcos Antônio Silva Nascimento
* Matrícula: 112210791
*/

/**Uma classe para criar um Contribuinte
 * 
 * @version 2 de Agosto de 2013
 * @author Marcos Antônio Silva Nascimento
 * 
 */
public abstract class Contribuinte {
	private String nome;
	private int numContribuinte;
	private double valorBensCasa;
	private double valorBensCarro;
	protected static int numContribuintes = 0;
	private final String VAZIO = " ";
	
	/**Contrutor de contribuinte
	 * 
	 * @param nome Nome do contribuinte
	 * @param numContribuinte Numero do contribuinte
	 * @throws Exception
	 */
	public Contribuinte(String nome, int numContribuinte) throws Exception {
		setNome(nome);
		setNumContribuinte(numContribuinte);
	}
	
	/**Modificador de nome
	 * 
	 * @param nome O novo nome
	 * @throws Exception
	 */
	public void setNome(String nome) throws Exception {
		if (nome == null || nome.equals(VAZIO)) {
			throw new Exception("Nome nulo ou vazio.");
		}
		this.nome = nome;
	}
	
	/**Acessador de nome
	 * 
	 * @return O nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**Modificador do numero do contribuinte
	 * 
	 * @param num O numero do contribuinte
	 * @throws Exception
	 */
	public void setNumContribuinte(int num) throws Exception {
		if (num <= 0) {
			throw new Exception("Numero de contribuinte invalido.");
		}
		numContribuinte = num;
	}
	
	/**Acessador do numero do contribuinte
	 * 
	 * @return O numero do contribuinte
	 */
	public int getNumContribuinte() {
		return numContribuinte;
	}
	
	/**Acessador do numero de contribuintes
	 * 
	 * @return O numero de contribuintes
	 */
	public int getNumContribuintes() {
		return numContribuintes;
	}
	
	/**Modificador do valor de bens em casas
	 * 
	 * @param valor O valor de bens em casas
	 * @throws Exception
	 */
	public void setValorBensCasa(double valor) throws Exception {
		if (valor < 0) {
			throw new Exception("Valor em bens casa invalido.");
		}
		valorBensCasa = valor;
	}
	
	/**Acessador do valor de bens em casas
	 * 
	 * @return O valor de bens em casas
	 */
	public double getValorBensCasa() {
		return valorBensCasa;
	}
	
	/**Modificador do valor de bens em carros
	 * 
	 * @param valor O valor de bens em carros 
	 * @throws Exception
	 */
	public void setValorBensCarro(double valor) throws Exception {
		if (valor < 0) {
			throw new Exception("Valor em bens casa invalido.");
		}
		valorBensCarro = valor;
	}
	
	/**Acessador do valor de bens em carros
	 * 
	 * @return O valor de bens em carros
	 */
	public double getValorBensCarro() {
		return valorBensCarro;
	}
	
	/**Calcula o total de bens
	 * 
	 * @return O valor total de bens
	 */
	public double valorTotalBens() {
		return getValorBensCasa() + getValorBensCarro();
	}
	
	/**Calcula desconto
	 * 
	 * @return O desconto
	 */
	public abstract double desconto();
	
	/**Calcula o imposto
	 * 
	 * @return O imposto
	 */
	public abstract double imposto();
	
	/**Acessador de limiar
	 * 
	 * @return A limiar
	 */
	public abstract int getLimiar();
	
	/**Verificador do valor de desconto
	 * 
	 * @return O boolean correspondente a verificacao
	 */
	public boolean verificaDesconto() {
		if (desconto() > imposto() ) {
			return false;
		}
		return true;
	}
	
	/**Calcula o valor total do imposto
	 * 
	 * @return O valor total do imposto com desconto
	 */
	public double totalImposto() {
		if (verificaDesconto()) {
			return imposto() - desconto();
		}
		return 0.0;
	}
	
	/**Imprime o contribuinte
	 * 
	 * @return O nome e o numero de contribuinte
	 */
	public String toString() {
		return "nome: " + nome + "\nNumero do contribuinte: " + numContribuinte;
	}
}
