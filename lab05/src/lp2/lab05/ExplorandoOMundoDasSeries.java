package lp2.lab05;

import java.util.Scanner;

/* Aluno: Marcos Antônio */

public class ExplorandoOMundoDasSeries {
	
	private static final int CRIA_PA = 1;
	private static final int CRIA_FIBONACCI = 2;
	private static final int VER_TERMO_PA = 3;
	private static final int VER_TERMO_FIBONACCI = 4;
	private static final int MOSTRA_TERMOS = 5;
	private static final int SAIR = 6;
	private static ProgressaoAritmetica pa;
	private static Fibonacci fibonacci;
	private static int opcao;
	
	public static void main(String[] args) {
		boolean continuar = true;
		
		while (continuar) {
			ImprimeOpcoes();					
			opcao = LeOpcao();
			
			if (opcao == SAIR) {
				continuar = false;
			}
			
			switch(opcao) {
			case(CRIA_PA):
				CriaPA();
				break;
				
			case(CRIA_FIBONACCI):
				CriaFibonacci();
				break;
			
			case(VER_TERMO_PA):
				if (VerificaVariavel()) {
					MostraTermoPA();
					break;
				}
				else {
					break;
				}
			
			case(VER_TERMO_FIBONACCI):
				if (VerificaVariavel()) {
					MostraTermoFibonacci();
					break;
				}
				else {
					break;
				}
			
			case(MOSTRA_TERMOS):
				if (VerificaVariavel()) {
					MostraTermos();
					break;	
				}
				else {
					break;
				}
			}	
		}
	}
	
	private static int LeOpcao() {
		Scanner entrada = new Scanner(System.in);
		return entrada.nextInt();	
	}
	
	private static ProgressaoAritmetica CriaPA() {
		System.out.println("Informe o primeiro termo da PA: ");
		int primeiro = LeOpcao();
		System.out.println("Informe a razao da PA: ");
		int razao = LeOpcao();
		pa = new ProgressaoAritmetica(primeiro, razao);
		return pa;
	}
	
	private static Fibonacci CriaFibonacci() {
		fibonacci = new Fibonacci();
		return fibonacci;
	}
	
	private static void MostraTermoPA() {
		System.out.println("Informe um termo que deseja obter da PA: ");
		opcao = LeOpcao();
		System.out.println("Termo da PA: " + pa.termo(opcao));
	}
	
	private static void MostraTermoFibonacci() {
		System.out.println("Informe um termo que deseja obter de Fibonacci: ");
		opcao = LeOpcao();
		System.out.println("Termo Fibonacci: " + fibonacci.geraTermo(opcao));
	}
	
	private static void MostraTermos() {
		System.out.println("Quantos termos da PA e de Fibonacci deseja gerar? ");
		opcao = LeOpcao();
		System.out.println("\nTermos da PA: " + pa.geraTermos(opcao));
		System.out.println("Sequência de Fibonacci: " + fibonacci.geraSequencia(opcao) + "\n");
	}
	
	private static boolean VerificaVariavel() {
		if (pa == null) {
			System.out.println("Voce nao criou a sequencia de PA. Crie agora.\n");
			return false;
		}
		else if (fibonacci == null) {
			System.out.println("Voce nao criou a sequencia de Fibonacci. Crie agora.\n");
			return false;
		}
		return true;
	}
	
	private static void ImprimeOpcoes() {
		System.out.println("Escolha a opcao desejada.");
		System.out.println("1. Para criar uma progressao aritmetica");
		System.out.println("2. Para criar uma serie de Fibonacci");
		System.out.println("3. Para ver o termo n da sua PA");
		System.out.println("4. Para ver o termo n da serie de Fibonacci");
		System.out.println("5. Para mostrar os n primeiros termos da sua PA e da serie de Fibonacci");
		System.out.println("6. Para sair.\n");
		System.out.println("Digite sua escolha: ");
	}
}