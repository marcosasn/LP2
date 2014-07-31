package lp2.lab05;

import java.util.Scanner;

public class TestaPonto {
	
	private static Ponto ponto;
	private static int opcao;
	private static final int CRIA_PONTO = 1;
	private static final int MOSTRA_PONTO = 2;
	private static final int SAIR = 3;
	
	public static void main(String[] args) {
		boolean programa = true;
		
		while (programa) {
			ImprimeOpcoes();
			opcao = LeOpcao();
			
			switch(opcao) {
			case(CRIA_PONTO):
				CriaPonto();
				break;
			case(MOSTRA_PONTO):
				System.out.println(ponto);
				break;
			case(SAIR):
				System.out.println("Até mais.");
				programa = false;
				break;
			default:
				break;
			}
		}
		
		
		
	}
	
	public static void ImprimeOpcoes() {
		System.out.println("Faça sua escolha.");
		System.out.println("1 - Cria um ponto no plano cartesiano.");
		System.out.println("2 - Imprime o ponto e suas cordenadas.");
		System.out.println("3 - Sai do programa.");
	}
	
	public static int LeOpcao() {
		Scanner entrada = new Scanner(System.in);
		while (!(entrada.hasNextInt())) {
			entrada.next();
			System.out.println("Digite um numero inteiro!");
		}
		return entrada.nextInt();
		
	}
	
	public static void CriaPonto() {
		System.out.println("Informe o valor de x: ");
		int x = LeOpcao();
		System.out.println("Informe o valor de y: ");
		int y = LeOpcao();
		System.out.println("Informe o valor de z: ");
		int z = LeOpcao();
		ponto = new Ponto(x, y, z);
	}
}
