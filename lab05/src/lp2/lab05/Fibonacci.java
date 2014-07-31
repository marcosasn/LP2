package lp2.lab05;

/**Uma classe para criar e/ou manipular objetos do tipo Fibonacci
 *@version 25 de Junho de 2013
 *@author Marcos Ant�nio
 */
public class Fibonacci {
	
	public Fibonacci() {
		
	}
	
	/**Gera termo de Fibonacci 
	 *@param n A posi��o do termo
	 *@return O termo correspondente a posi��o
	 */
	public long geraTermo(int n) {
		if (n < 2) {
			return n;
		}
		else {
			return geraTermo(n-1) + geraTermo(n-2);
		}
	}
	
	/**Gera a sequ�ncia de Fibonacci
	 *@param n O n�mero de valores da sequ�ncia
	 *@return A string formatada que det�m a sequ�ncia
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