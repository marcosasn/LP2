package lp2.lab06;

/**Uma classe para criar um Robo
 *@version 11 de Julho de 2013
 *@author Marcos Antônio
 */
public class Robo {
	private final int ROBO = 99;
	private int linhaRobo = 0;
	private int colunaRobo = 0;
	private int linha = 0;
	private int coluna = 0;
	private int passos = 0;
	private Sala salaRobo;
	private int energiaRobo;
	
	public Robo(Sala sala, int energia) throws Exception {
		if (energia <= 0) {
			throw new Exception("Energia invalida.");
		}
		energiaRobo = energia;
		salaRobo = sala;
		salaRobo.setPosicao(linhaRobo, colunaRobo, ROBO);
	}
	
	/**Movimenta o robo para cima 
	 *@return O boolean correspondente o movimento
	 */
	public boolean andarParaCima() {
		linha --;
		if (salaRobo.posicaoValida(linha, coluna) && salaRobo.verificarPosicaoLivre(linha, coluna) && verificaEnergia()) {
			salaRobo.setPosicao(linhaRobo, colunaRobo, Sala.LIVRE);
			linhaRobo --;
			salaRobo.setPosicao(linhaRobo, colunaRobo, ROBO);
			passos ++;
			energiaRobo --;
			return true;
		}
		linha ++;
		return false;
	}
	
	/**Movimenta o robo para baixo 
	 *@return O boolean correspondente o movimento
	 */
	public boolean andarParaBaixo() {
		linha ++;
		if (salaRobo.posicaoValida(linha, coluna) && salaRobo.verificarPosicaoLivre(linha, coluna) && verificaEnergia()) {
			salaRobo.setPosicao(linhaRobo, colunaRobo, Sala.LIVRE);
			linhaRobo ++;
			salaRobo.setPosicao(linhaRobo, colunaRobo, ROBO);
			passos ++;
			energiaRobo --;
			return true;
		}
		linha -- ;
		return false;
	}
	
	/**Movimenta o robo para esquerda 
	 *@return O boolean correspondente o movimento
	 */
	public boolean andarParaEsquerda() {
		coluna --;
		if (salaRobo.posicaoValida(linha, coluna) && salaRobo.verificarPosicaoLivre(linha, coluna) && verificaEnergia()) {
			salaRobo.setPosicao(linhaRobo, colunaRobo, Sala.LIVRE);
			colunaRobo --;
			salaRobo.setPosicao(linhaRobo, colunaRobo, ROBO);
			passos ++;
			energiaRobo --;
			return true;
		}
		coluna ++;
		return false;
	}
	
	/**Movimenta o robo para direita 
	 *@return O boolean correspondente o movimento
	 */
	public boolean andarParaDireita() {
		coluna ++;
		if (salaRobo.posicaoValida(linha, coluna) && salaRobo.verificarPosicaoLivre(linha, coluna) && verificaEnergia()) {
			salaRobo.setPosicao(linhaRobo, colunaRobo, Sala.LIVRE);
			colunaRobo ++;
			salaRobo.setPosicao(linhaRobo, colunaRobo, ROBO);
			passos ++;
			energiaRobo --;
			return true;
		}
		coluna --;
		return false;
	}
	
	/**Acessa a linha do robo 
	 *@return O inteiro correspondente a linha do robo
	 */
	public int getLinhaRobo() {
		return linhaRobo;
	}
	
	/**Acessa a coluna do robo 
	 *@return O inteiro correspondente a coluna do robo
	 */
	public int getColunaRobo() {
		return colunaRobo;
	}
	
	/**Imprime a posicao do robo 
	 *@return A string da linha e da coluna do robo
	 */
	public String toString() {
		return "Linha: "+linhaRobo+", Coluna: "+colunaRobo;
	}
	
	/**Acessa a energia do robo 
	 *@return O inteiro correspondente a quantidade de energia restante
	 */
	public int getEnergiaRobo() {
		return energiaRobo;
	}
	
	/**Acessa a quantidade de passos do robo 
	 *@return O inteiro correspondente a quantidade de passos realizados
	 */
	public int getPassosRobo() {
		return passos;
	}
	
	/**Verifica se há energia disponível no robo 
	 *@return O boolean correspondente se ainda há energia disponível
	 */
	private boolean verificaEnergia() {
		if (energiaRobo > 0) {
			return true;
		}
		return false;
	}
}
