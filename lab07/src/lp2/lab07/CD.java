package lp2.lab07;

import java.util.ArrayList;

/*

 * Aluno: Marcos Antônio Silva Nascimento

 * Matrícula: 112210791

 */

/** Uma classe para criar um objeto do tipo CD
 * 
 * @version 20 de Julho de 2013
 * @author Marcos Antônio Silva Nascimento
 * 
 */
public class CD {
	private String titulo;
	private String autor;
	private int musicas;
	private String carroChefe;
	private final String VAZIO = " ";
	private ArrayList<String> faixas;
	private int contadorCadastraFaixa;
	private String stringFaixas;
	
	/**Construtor de CD
	 * 
	 * @param titulo O titulo do CD
	 * @param autor O autor do CD
	 * @param musicas A quantidade de musicas do CD
	 * @throws Exception
	 */
	public CD(String titulo, String autor, int musicas) throws Exception {
		if (titulo.equals(VAZIO)) {
			throw new Exception("Titulo nao pode ser vazio.");
		}
		if (autor.equals(VAZIO)) {
			throw new Exception("Autor nao pode ser vazio.");
		}
		if (musicas <= 0) {
			throw new Exception("Valor invalido para quantidade de musicas.");
		}
		this.titulo = titulo;
		this.autor = autor;
		this.musicas = musicas;
		faixas = new ArrayList();
		contadorCadastraFaixa = 0;
	}
	
	/**Construtor de CD
	 * 
	 * @param titulo O titulo de CD
	 * @param autor O autor de CD
	 * @param musicas A quantidade de musicas do CD
	 * @param carroChefe A musica de carro chefe
	 * @throws Exception
	 */
	public CD(String titulo, String autor, int musicas, String carroChefe) throws Exception {
		this(titulo, autor, musicas);
		this.carroChefe = carroChefe;
	}
	
	/**Metodo que altera o carro chefe do CD
	 * 
	 * @param nome A faixa de carro chefe
	 */
	public void setCarroChefe(String nome) {
		carroChefe = nome;
	}
	
	/**Metodo que retorna o titulo do CD
	 * 
	 * @return O titulo do CD
	 */
	public String getTitulo() {
		return titulo;
	}
	
	/**Metodo que retorna o autor do CD
	 * 
	 * @return O autor do CD
	 */
	public String getAutor() {
		return autor;
	}
	
	/**Metodo que retorna a quantidade de musicas do CD
	 * 
	 * @return A quantidade de musicas do CD
	 */
	public int getMusicas() {
		return musicas;
	}
	
	/**Metodo que retorna o carro chefe do CD 
	 * 
	 * @return O carro chefe do CD
	 */
	public String getCarroChefe() {
		return carroChefe;
	}
	
	/**Metodo que retorna uma faixa do CD
	 * 
	 * @param indice Representa o indice da faixa
	 * @return A faixa do CD
	 */
	public String getFaixa(int indice) {
		indice --;
		if (indice > faixas.size()-1 || indice < 0) {
			return null;
		}
		return faixas.get(indice);
	}
	
	/**Metodo que cadastra uma faixa do CD
	 * 
	 * @param faixa A faixa do CD
	 * @return O boolean relativo ao cadastro da faixa
	 */
	public boolean cadastraFaixa(String faixa) {
		if (contadorCadastraFaixa >= musicas) {
			return false;
		}
		faixas.add(faixa);
		contadorCadastraFaixa ++;
		return true;
	}
	
	/**Metodo que imprime o CD
	 * 
	 */
	public String toString() {
		return ""+autor+", "+titulo+", "+carroChefe+", "+criaStringFaixas();
	}
	
	/**Metodo que verifica se um CD e igual a outro CD
	 * 
	 */
	public boolean equals(Object outro) {
		if (!(outro instanceof CD)) {
			return false;
		}
		CD outroCD = (CD) outro;
		return getTitulo().toLowerCase().equals(outroCD.getTitulo().toLowerCase()) && 
				getAutor().toLowerCase().equals(outroCD.getAutor().toLowerCase());
	}
	
	private String criaStringFaixas() {
		stringFaixas = "";
		for(int i = 0; i < faixas.size(); i++) {
			if (i == faixas.size()-1) {
				stringFaixas += i + 1 + " - " + faixas.get(i);
			}
			else {
				stringFaixas += i + 1 + " - " + faixas.get(i) + "/";
			}
		}
		return stringFaixas;
	}
}