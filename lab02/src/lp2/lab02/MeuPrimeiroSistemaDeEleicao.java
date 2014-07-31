/* Aluno: Marcos Antônio */

package lp2.lab02;
import java.util.Scanner;

public class MeuPrimeiroSistemaDeEleicao {
	public static void main(String[] args){
		Scanner entrada = new Scanner (System.in);
		System.out.println("Informe a quantidade de eleitores do sistema: ");
		int eleitores = entrada.nextInt();

		final int HOMEM_DE_FERRO = 89;
		int votosHomemDeFerro = 0;

		final int THOR = 27;
		int votosThor = 0;

		final int INCRIVEL_HULK = 68;
		int votosIncrivelHulk = 0;

		final int BRANCO = 0;
		int votosBranco = 0;

		final int NULO = 99;
		int votosNulo = 0;

		final int SAIR = -1;

		for (int i = 0; i < eleitores; i++){
			System.out.println("Informe seu voto (Homem de Ferro - 89, Thor - 27, Incrível Hulk - 68, Branco - 0, Nulo - 99) ou -1 para sair: ");
    		int voto = entrada.nextInt();
    
    		if (voto == SAIR){
    			break;
    		}
    		switch(voto){
    		case HOMEM_DE_FERRO:
    			votosHomemDeFerro ++;
    			break;
    		case THOR:
    			votosThor ++;
    			break;
    		case INCRIVEL_HULK:
    			votosIncrivelHulk ++;
    			break;
    		case BRANCO:
    			votosBranco ++;
    			break;
    		case NULO:
    			votosNulo ++;
    			break;
    		}
    	}    
		System.out.println("Relatorio da eleicao\nTotal de eleitores: "+eleitores+"\nVotos brancos: "+votosBranco+"\nVotos nulos: "+votosNulo
		+"\nVotos Homem de Ferro: "+votosHomemDeFerro+"\nVotos Hulk: "+votosIncrivelHulk+"\nVotos Thor: "+votosThor);
		
		if ((votosIncrivelHulk > votosThor) && (votosIncrivelHulk > votosHomemDeFerro)){
			System.out.println("O vencedor foi Incrivel Hulk!");
		}
		else if((votosThor > votosIncrivelHulk) && (votosThor > votosHomemDeFerro)){
			System.out.println("O vencedor foi Thor!");
		}
		else if((votosHomemDeFerro > votosThor) && (votosHomemDeFerro > votosIncrivelHulk)){
			System.out.println("O vencedor foi Homem de Ferro!");
		}
		else if ((votosThor == votosIncrivelHulk) || (votosHomemDeFerro == votosThor) || (votosIncrivelHulk == votosHomemDeFerro)){
			System.out.println("Houve empate!");
		}
	}
	
}