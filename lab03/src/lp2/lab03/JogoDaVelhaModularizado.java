/* Aluno: Marcos Antônio */

package lp2.lab03;

import java.util.Scanner;

public class JogoDaVelhaModularizado {
	public static void main(String args[]){
		char tabuleiro[][] = new char[3][3];
		int comeco = 0;
		final int TORNEIOS = 9;
		final char O ='O';
		final char X ='X';
	    
	    InicializaTabuleiro(tabuleiro);

	    while (true) {
	    	
	    	ImprimeTabuleiro(tabuleiro);
	    	
	        System.out.println("\nINSIRA AS COORDENADAS");
	        if((comeco % 2) == 1)System.out.print("PLAYER 2\nLINHA: ");
	        
	        else System.out.print("PLAYER 1\nLINHA: ");
	        int linha = LeInteiro();
	        System.out.print("COLUNA: ");
	        int coluna = LeInteiro();

	        if(tabuleiro[linha-1][coluna-1] == ' ') {
	            if ((comeco % 2)==1) {
	            	tabuleiro[linha-1][coluna-1] = X;
	            }
	            else {	
	            	tabuleiro[linha-1][coluna-1] = O;
	            }
	            comeco ++;
	            
	            if (VerificaVencedor(comeco, TORNEIOS, tabuleiro, O, X)) {
	            	System.out.println("Deseja continuar? ");
	            	System.out.println("Digite sim para continuar ou nao para sair do jogo.");
	            	String opcao = LeString();
	            	if (opcao.toLowerCase().equals("nao")) {
	            		break;
	            	}
	            	InicializaTabuleiro(tabuleiro);
	            	comeco = 0;
	            }
	        }
	    }
	}
	private static int LeInteiro() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	
	private static String LeString() {
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}

	private static void InicializaTabuleiro(char tabuleiro[][]) {
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				tabuleiro[i][j]=' ';
	}
	
	private static void ImprimeTabuleiro(char tabuleiro[][]){
		System.out.print("  JOGO DA VELHA \n");
		for(int i = 0; i < 3; i++) {
			System.out.print(tabuleiro[i][0]+"|"+tabuleiro[i][1]+"|"+tabuleiro[i][2]);
			if(i < 3-1) {
				System.out.print("\n------\n");
			}
		}
	}
	
	private static boolean VerificaVencedor(int comeco, final int TORNEIOS, char tabuleiro[][], final char O, final char X){
		if((tabuleiro[0][0]==O && tabuleiro[0][1]==O && tabuleiro[0][2]==O)||
			(tabuleiro[1][0]==O && tabuleiro[1][1]==O && tabuleiro[1][2]==O)||
			(tabuleiro[2][0]==O && tabuleiro[2][1]==O && tabuleiro[2][2]==O)||
			(tabuleiro[0][0]==O && tabuleiro[1][0]==O && tabuleiro[2][0]==O)||
			(tabuleiro[0][1]==O && tabuleiro[1][1]==O && tabuleiro[2][1]==O)||
			(tabuleiro[0][2]==O && tabuleiro[1][2]==O && tabuleiro[2][2]==O)||
			(tabuleiro[0][0]==O && tabuleiro[1][1]==O && tabuleiro[2][2]==O)||
			(tabuleiro[0][2]==O && tabuleiro[1][1]==O && tabuleiro[2][0]==O)){
			for(int i = 0 ; i < 3; i++) {
				System.out.print(tabuleiro[i][0]+"|"+tabuleiro[i][1]+"|"+tabuleiro[i][2]);
				if(i < 3-1) {
					System.out.print("\n------\n");
				}
			}
			System.out.print("\nJogador 1, VOCE VENCEU!!!");
			return true;
		}	        
		if((tabuleiro[0][0]==X && tabuleiro[0][1]==X && tabuleiro[0][2]==X)||
			(tabuleiro[1][0]==X && tabuleiro[1][1]==X && tabuleiro[1][2]==X)||
			(tabuleiro[2][0]==X && tabuleiro[2][1]==X && tabuleiro[2][2]==X)||
			(tabuleiro[0][0]==X && tabuleiro[1][0]==X && tabuleiro[2][0]==X)||
			(tabuleiro[0][1]==X && tabuleiro[1][1]==X && tabuleiro[2][1]==X)||
			(tabuleiro[0][2]==X && tabuleiro[1][2]==X && tabuleiro[2][2]==X)||
			(tabuleiro[0][0]==X && tabuleiro[1][1]==X && tabuleiro[2][2]==X)||
			(tabuleiro[0][2]==X && tabuleiro[1][1]==X && tabuleiro[2][0]==X)){
			for(int i = 0; i < 3; i++) {
				System.out.print(tabuleiro[i][0]+"|"+tabuleiro[i][1]+"|"+tabuleiro[i][2]);
				if(i < 3-1) {
					System.out.print("\n------\n");
				}
			}
			System.out.print("\nJogador 2, VOCE VENCEU!!!");
			return true;
		}

		if(comeco == TORNEIOS) {
			for(int i = 0; i < 3; i++) {
				System.out.print(tabuleiro[i][0]+"|"+tabuleiro[i][1]+"|"+tabuleiro[i][2]);
				if(i <3-1) {
					System.out.print("\n------\n");
				}
			}
			System.out.print("\nPARTIDA EMPATADA");
			return true;
		}
		return false;
	}
}