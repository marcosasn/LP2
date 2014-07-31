/* Aluno: Marcos Antônio */

package lp2.lab04;

import java.util.Scanner;
import java.util.Scanner;
import p1.aplic.cartas.Baralho;
import p1.aplic.cartas.Carta;
import p1.aplic.cartas.Mao;

public class VinteUmJogo {
	
	private static final int VINTE_UM = 21;
	private static Mao maoJogador;
	private static Mao maoMesa;
	private static Baralho baralho;
	private static final int GANHADOR_JOGADOR = 1;
	private static final int GANHADOR_MESA = 2;
	private static final int EMPATE = 0;
	private static final int NENHUM_JOGADOR = -1;
	private static final int JOGADOR_ESTOROU = 3;
	private static final int MESA_ESTOROU = 4;
	private static int pontuacaoMesa = 0;
	private static int pontuacaoJogador = 0;
	private static final int BARALHO_VAZIO = 10; 
	
	public static void main(String [] args) {
		
		boolean novoJogo = true;
		String opcao;
		
		do {
			InicializaJogo();
			
			int ganhador = joga();

			if (ganhador == GANHADOR_JOGADOR) {
			
				System.out.println("Valor da mao do Jogador: " + maoJogador);
				System.out.println("Pontuacao Jogador: " + pontuacaoJogador);
				System.out.println("Valor da mao da Mesa: " + maoMesa);
				System.out.println("Pontuacao Mesa: " + pontuacaoMesa);
				System.out.println("Jogador e o ganhador!");
				System.out.println("Ninguem estorou!");
			
			} 
			else if (ganhador == GANHADOR_MESA) {
			
				System.out.println("Valor da mao do Jogador: " + maoJogador);
				System.out.println("Pontuacao Jogador: " + pontuacaoJogador);
				System.out.println("Valor da mao da Mesa: " + maoMesa);
				System.out.println("Pontuacao Mesa: " + pontuacaoMesa);
				System.out.println("Mesa e o ganhador!");
				System.out.println("Ninguem estorou!");
		
			} 
			else if (ganhador ==  EMPATE) {
			
				System.out.println("Valor da mao do Jogador: " + maoJogador);
				System.out.println("Pontuacao Jogador: " + pontuacaoJogador);
				System.out.println("Valor da mao da Mesa: " + maoMesa);
				System.out.println("Pontuacao Mesa: " + pontuacaoMesa);
				System.out.println("Mesa e o ganhador!");
				System.out.println("Houve empate.");
			}
			else if (ganhador == JOGADOR_ESTOROU) {
			
				System.out.println("Valor da mao do Jogador: " + maoJogador);
				System.out.println("Pontuacao Jogador: " + pontuacaoJogador);
				System.out.println("Valor da mao da Mesa: " + maoMesa);
				System.out.println("Pontuacao Mesa: " + pontuacaoMesa);
				System.out.println("Mesa e o ganhador!");
				System.out.println("Jogador estorou.");			
			}
			else if (ganhador == MESA_ESTOROU) {
			
				System.out.println("Valor da mao do Jogador: " + maoJogador);
				System.out.println("Pontuacao Jogador: " + pontuacaoJogador);
				System.out.println("Valor da mao da Mesa: " + maoMesa);
				System.out.println("Pontuacao Mesa: " + pontuacaoMesa);
				System.out.println("Jogador e o ganhador!");
				System.out.println("Mesa estorou.");
			}
			else if ( ganhador == BARALHO_VAZIO) {
				
				System.out.println("Baralho vazio. Deseja iniciar novo jogo?");
				System.out.println("Digite S se positivo ou N se negativo.");
				opcao = LeOpcao();
				if (opcao.toLowerCase().equals("n")) {
					novoJogo = false;
				}
			}
			
			System.out.println("Fim do jogo. Deseja iniciar novo jogo?");
			System.out.println("Digite S se positivo ou N se negativo.");
			opcao = LeOpcao();
			if (opcao.toLowerCase().equals("n")) {
				novoJogo = false;
			}
		} while (novoJogo == true);
	}
	
	private static void InicializaJogo() {
		pontuacaoMesa = 0;
		pontuacaoJogador = 0;
		
		maoJogador = new Mao();
		maoMesa = new Mao();
		baralho = new Baralho();
	
	}
	
	private static Carta alterarPegaCartaMesa() {
	 	Carta novaCarta = baralho.pegaCarta();
	 	if (novaCarta.getValor() == Carta.DAMA || novaCarta.getValor() == Carta.REI || novaCarta.getValor() == Carta.VALETE) {
	 	 pontuacaoMesa += 10;
	 	}
	 	else {
	 	 pontuacaoMesa += novaCarta.getValor();
	 	}
	 	return novaCarta;
	 }
	  
	private static Carta alterarPegaCartaJogador() {
	 	Carta novaCarta = baralho.pegaCarta();
	 	if (novaCarta.getValor() == Carta.DAMA || novaCarta.getValor() == Carta.REI || novaCarta.getValor() == Carta.VALETE) {
	 	 pontuacaoJogador += 10;
	 	} 
	 	else {
	 	 pontuacaoJogador += novaCarta.getValor();
	 	}
	 	return novaCarta;
	 }
	
	private static String LeOpcao() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
	
	private static int joga() {
		
		baralho.baralhar();
		maoJogador.adicionar(alterarPegaCartaJogador());
		maoMesa.adicionar(alterarPegaCartaMesa());

		int contaCartas = baralho.númeroDeCartas();
		
		while (contaCartas > 0) {
			
			System.out.println("Jogador deseja pegar uma carta? ");
			System.out.println("Digite S se positivo ou N se negativo.");
			String opcao = LeOpcao();
			if (opcao.toLowerCase().equals("s")) {
				maoJogador.adicionar(alterarPegaCartaJogador());
				contaCartas --;

				System.out.println("\nValor da mao do Jogador: " + maoJogador);
				System.out.println("Pontuacao Jogador: " + pontuacaoJogador);
				System.out.println("Quantidade de cartas da mesa: " + contaCartas + "\n");
				
				if ((pontuacaoMesa < 17) && (pontuacaoJogador < VINTE_UM)) {
					maoMesa.adicionar(alterarPegaCartaMesa());
					contaCartas --;

					System.out.println("\nMao da Mesa: "+ maoMesa );
					System.out.println("Pontuacao Mesa: " + pontuacaoMesa);
					System.out.println("Quantidade de cartas da mesa: " + contaCartas + "\n");
				}
			}
			else if (pontuacaoMesa < 17) {
					maoMesa.adicionar(alterarPegaCartaMesa());
					contaCartas --;

					System.out.println("Mao da Mesa: "+ maoMesa );
					System.out.println("Pontuacao Mesa: " + pontuacaoMesa);
					System.out.println("Quantidade de cartas da mesa: " + contaCartas + "\n");
			}
			
			if (contaCartas == 0) {
				return BARALHO_VAZIO;
			}

			if (pontuacaoJogador == VINTE_UM && pontuacaoMesa == VINTE_UM) {
				return EMPATE;
				
			} else if ((pontuacaoJogador == VINTE_UM)) {
				return GANHADOR_JOGADOR;
				
			} else if ((pontuacaoMesa == VINTE_UM)) {
				return GANHADOR_MESA;
				
			} else if (pontuacaoJogador > VINTE_UM && pontuacaoMesa < VINTE_UM) {
				return JOGADOR_ESTOROU;
				
			} else if (pontuacaoJogador < VINTE_UM && pontuacaoMesa > VINTE_UM) {
				return MESA_ESTOROU;
			}
		}
	return NENHUM_JOGADOR;
	}
}

