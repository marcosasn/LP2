package lp2.lab05;

/**Uma classe para criar e/ou manipular objetos do tipo PA (Progress�o Aritm�tica)
 *@version 25 de Junho de 2013
 *@author Marcos Ant�nio
 */
public class ProgressaoAritmetica {
	private int primeiro; 
	private int razao;
	private int termoAtual;
	
	public ProgressaoAritmetica (int primeiro, int razao) {
		this.primeiro = primeiro;
		this.razao = razao;
		termoAtual = primeiro;
	}
	
	/**Acessador da raz�o da PA
	 *
	 *@return A raz�o da PA
	 */
	public int getRazao() {
		return razao;
	}
	
	/**M�todo que calcula o pr�ximo termo da PA
	 * 
	 *@return O pr�ximo termo da PA
	 */
	public int proximo() {
		termoAtual += razao;
		return termoAtual;
	}
	
	/**M�todo que reinicia o termo atual da PA
	 * 
	 *@return O primeiro termo da PA
	 */
	public int primeiro() {
		termoAtual = primeiro;
		return primeiro;
	}	
	
	/**M�todo que calcula o termo n da PA
	 * 
	 *@param n A posi��o do termo
	 *@return O termo correspondente a posi��o
	 */
	public int termo(int n) {
		if (n <= 0) {
			return primeiro;
		}
		termoAtual = primeiro + (n - 1) * razao;
		return termoAtual;	
	}
	
	/**Gera a sequ�ncia de termos da PA
	 * 
	 *@param n O n�mero de termos
	 *@return A String formatada que det�m a sequ�ncia
	 */
	public String geraTermos(int n) {
		if (n <= 0) {
			termoAtual = primeiro;
			return "[" + primeiro + "]";
		}
		String termos = "[";
		for (int i = 1; i <= n; i++) {
			if (i == n) {
				termos += termo(i);
			}
			else {
				termos += termo(i) + ",";
			}
		}
		termos += "]";
		return termos;
	}		
}