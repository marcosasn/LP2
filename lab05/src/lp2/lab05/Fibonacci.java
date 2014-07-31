package lp2.lab05;

/**Uma classe para criar e/ou manipular objetos do tipo Fibonacci
 *@version 25 de Junho de 2013
 *@author Marcos Antônio
 */
public class Fibonacci {
	
	public Fibonacci() {
		
	}
	
	/**Gera termo de Fibonacci 
	 *@param n A posição do termo
	 *@return O termo correspondente a posição
	 */
	public long geraTermo(int n) {
		if (n < 2) {
			return n;
		}
		else {
			return geraTermo(n-1) + geraTermo(n-2);
		}
	}
	
	/**Gera a sequência de Fibonacci
	 *@param n O número de valores da sequência
	 *@return A string formatada que detém a sequência
	 */
	public String geraSequencia(int n) {
		String sequencia = "[";
		for (int i = 0; i < n; i++) {
			if (i == n-1) {
				sequencia += geraTermo(i);
			}
			else {
				sequencia += geraTermo(i) + ",";
			}
		}
		sequencia += "]";
		return sequencia;
	}	
}