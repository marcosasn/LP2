package lp2.lab05;

/**Uma classe para criar e/ou manipular objetos do tipo PA (Progressão Aritmética)
 *@version 25 de Junho de 2013
 *@author Marcos Antônio
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
	
	/**Acessador da razão da PA
	 *
	 *@return A razão da PA
	 */
	public int getRazao() {
		return razao;
	}
	
	/**Método que calcula o próximo termo da PA
	 * 
	 *@return O próximo termo da PA
	 */
	public int proximo() {
		termoAtual += razao;
		return termoAtual;
	}
	
	/**Método que reinicia o termo atual da PA
	 * 
	 *@return O primeiro termo da PA
	 */
	public int primeiro() {
		termoAtual = primeiro;
		return primeiro;
	}	
	
	/**Método que calcula o termo n da PA
	 * 
	 *@param n A posição do termo
	 *@return O termo correspondente a posição
	 */
	public int termo(int n) {
		if (n <= 0) {
			return primeiro;
		}
		termoAtual = primeiro + (n - 1) * razao;
		return termoAtual;	
	}
	
	/**Gera a sequência de termos da PA
	 * 
	 *@param n O número de termos
	 *@return A String formatada que detém a sequência
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