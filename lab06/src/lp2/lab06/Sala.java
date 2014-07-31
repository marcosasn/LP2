package lp2.lab06;

/**Uma classe para criar uma Sala
 *@version 11 de Julho de 2013
 *@author Marcos Antônio
 */
public class Sala {
	private int sala[][];
	private int tamanhoLinhas;
	private int tamanhoColunas;
	public static final int OCUPADO = 1;
	public static final int LIVRE = 0;
	
	public Sala(int linhas, int colunas) throws Exception {
		if ((linhas <= 0) || (colunas <= 0)) {
			throw new Exception("Mensagem errada, parametros incorretos para a criacao da sala.");
		}
		sala = new int [linhas][colunas];
		tamanhoLinhas = sala.length;
		tamanhoColunas = sala[0].length;
	}
	
	/**Verifica se a posição é válida 
	 *@param linha coluna Representam uma determinada posição que se deseja verificar
	 *@return O boolean correspondente a verificação
	 */
	public boolean posicaoValida(int linha, int coluna) {	
		if (((linha < 0) || (linha >= tamanhoLinhas)) || ((coluna < 0) || (coluna >= tamanhoColunas))) {
			return false;
		}
		return true;
	}
	
	/**Insere um obstáculo 
	 *@param linha coluna Representam a posição que se deseja inserir um obstáculo 
	 *@return O boolean correspondente a inserção do obstáculo
	 */
	public boolean inserirObstaculo(int linha, int coluna) {
		if (posicaoValida(linha, coluna)) {
			sala[linha][coluna] = OCUPADO;
			return true;
		}
		return false;
	}
	
	/**Verifica se a posição se encontra livre 
	 *@param linha coluna Representam a posição que se deseja verificar
	 *@return O boolean correspondente a verificação
	 */
	public boolean verificarPosicaoLivre(int linha, int coluna) {
		if ((posicaoValida(linha, coluna)) && (sala[linha][coluna] == LIVRE)) {
			return true;
		}
		return false;
	}
	
	/**Insere algo em determinada posição 
	 *@param linha coluna LIVREOCUPADO Correspondem a posição e a constante LIVRE ou OCUPADO 
	 *@return O boolean correspondente a inserção da constante na posição
	 */
	public boolean setPosicao(int linha, int coluna, int LIVREOCUPADO) {
		if ((posicaoValida(linha, coluna))) {
			sala[linha][coluna] = LIVREOCUPADO;
			return true;
		}
		return false;
	}
	
}