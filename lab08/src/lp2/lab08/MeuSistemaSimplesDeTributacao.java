package lp2.lab08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
* Aluno: Marcos Antônio Silva Nascimento
* Matrícula: 112210791
*/

public class MeuSistemaSimplesDeTributacao {
	private static List<Contribuinte> contribuintes;
	private static final int CADASTRAR = 1;
	private static final int CALCULAR_E_MOSTRAR = 2;
	private static final int MOSTRA_QUANTIDADE = 3;
	private static final int LISTAR = 4;
	private static final int SAIR = 5;
	
	private static final int CAMINHONEIRO = 6;
	private static final int TAXISTA = 7;
	private static final int ENGENHEIRO = 8;
	private static final int MEDICO = 9;
	private static final int POLITICO = 10;
	private static final int PROFESSOR = 11;
	
	private static boolean continuar = true;
	private static int opcao;
	
	public static void main(String[] args) {
		contribuintes = new ArrayList<>();

		while (continuar) {
			System.out.println("O que deseja fazer?\n1. Cadastrar contribuintes\n2. " +
					"Calcular e mostrar impostos e descontos associados a um contribuinte\n3. " +
					"Mostrar a quantidade de contribuintes por profissão\n4. " +
					"Listar os contribuintes em função dos sinais " +
					"exteriores de riqueza indicando se são excessivos ou não\n5. " +
					"Sair");
			
			opcao = LeInteiro();
			switch(opcao){
				case(CADASTRAR):
					try {
						cadastraContribuinte();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				
				case(CALCULAR_E_MOSTRAR):
					calculaMostraImpostos();
					break;
			
				case(MOSTRA_QUANTIDADE):
					mostraNumContribuintes();
					break;
				
				case(LISTAR):
					mostraSinaisExteriores();
					break;
				
				case(SAIR):
					continuar = false;
					break;
				
				default:
					break;
			}
		}
	}
	
	private static int LeInteiro() {
		Scanner entrada = new Scanner(System.in);
		while(!(entrada.hasNextInt())) {
			entrada.next();
		}
		return entrada.nextInt();
	}
	
	private static String LeString() {
		Scanner entrada = new Scanner(System.in);
		return entrada.nextLine();
	}
	
	private static double LeDouble() {
		Scanner entrada = new Scanner(System.in);
		while(!(entrada.hasNextDouble())) {
			entrada.next();
		}
		return entrada.nextDouble();
	}
	
	private static String nomeContribuinte() {
		System.out.println("Informe o nome: ");
		return LeString();
	}
	
	private static int numContribuinte() {
		System.out.println("Informe o numero de contribuinte: ");
		return LeInteiro();
	}
	
	
	private static void cadastraContribuinte() throws Exception {
		String nome;
		int numContribuinte;
		
		System.out.println("Digite 6 - CAMINHONEIRO / 7 - TAXISTA" +
				" / 8 - ENGENHEIRO / 9 - MEDICO / 10 - POLITICO / 11 - PROFESSOR");
		
		opcao = LeInteiro();
		switch(opcao) {
			case(CAMINHONEIRO):
				nome = nomeContribuinte();
				numContribuinte = numContribuinte();
				Caminhoneiro caminhoneiro = new Caminhoneiro(nome, numContribuinte);
				
				System.out.println("Quantas toneladas transportadas? ");
				caminhoneiro.setToneTransportadas(LeInteiro());
				
				System.out.println("Quantos kilometros percorridos? ");
				caminhoneiro.setKiloPercorridos(LeDouble());
				
				System.out.println("Qual o valor de bens em casas? ");
				caminhoneiro.setValorBensCasa(LeDouble());
				
				System.out.println("Qual o valor e bens em carros? ");
				caminhoneiro.setValorBensCarro(LeDouble());
				
				contribuintes.add(caminhoneiro);
				break;
			
			case(TAXISTA):
				nome = nomeContribuinte();
				numContribuinte = numContribuinte();
				Taxista taxista = new Taxista(nome, numContribuinte);
				
				System.out.println("Quantos passageiros transportados? ");
				taxista.setNumPassageiros(LeInteiro());
				
				System.out.println("Quantos kilometros percorridos? ");
				taxista.setKiloPercorridos(LeDouble());
				
				System.out.println("Qual o valor de bens em casas? ");
				taxista.setValorBensCasa(LeDouble());
				
				System.out.println("Qual o valor e bens em carros? ");
				taxista.setValorBensCarro(LeDouble());
				
				contribuintes.add(taxista);
				break;
			
			case(ENGENHEIRO):
				nome = nomeContribuinte();
				numContribuinte = numContribuinte();
				Engenheiro engenheiro = new Engenheiro(nome, numContribuinte);
				
				System.out.println("Qual o número de projetos? ");
				engenheiro.setNumProjetos(LeInteiro());
				
				System.out.println("Qual o valor das despesas? ");
				engenheiro.setDespesas(LeDouble());
				
				System.out.println("Qual o valor de bens em casas? ");
				engenheiro.setValorBensCasa(LeDouble());
				
				System.out.println("Qual o valor e bens em carros? ");
				engenheiro.setValorBensCarro(LeDouble());
				
				contribuintes.add(engenheiro);
				break;
			
			case(MEDICO):
				nome = nomeContribuinte();
				numContribuinte = numContribuinte();
				Medico medico = new Medico(nome, numContribuinte);
				
				System.out.println("Qual o número de clientes? ");
				medico.setNumClientes(LeInteiro());
				
				System.out.println("Qual o valor das despesas? ");
				medico.setDespesas(LeDouble());
				
				System.out.println("Qual o valor de bens em casas? ");
				medico.setValorBensCasa(LeDouble());
				
				System.out.println("Qual o valor e bens em carros? ");
				medico.setValorBensCarro(LeDouble());
				
				contribuintes.add(medico);
				break;
				
			case(POLITICO):
				nome = nomeContribuinte();
				numContribuinte = numContribuinte();
				Politico politico = new Politico(nome, numContribuinte);
				
				System.out.println("Qual o valor do salario? ");
				politico.setSalario(LeDouble());
				
				System.out.println("Qual o valor de bens em casas? ");
				politico.setValorBensCasa(LeDouble());
				
				System.out.println("Qual o valor e bens em carros? ");
				politico.setValorBensCarro(LeDouble());
				
				contribuintes.add(politico);
				break;
				
			case(PROFESSOR):
				nome = nomeContribuinte();
				numContribuinte = numContribuinte();
				Professor professor = new Professor(nome, numContribuinte);
				
				System.out.println("Qual o valor do salario? ");
				professor.setSalario(LeDouble());
				
				System.out.println("Qual o valor das despesas? ");
				professor.setDespesas(LeDouble());
				
				System.out.println("Qual o valor de bens em casas? ");
				professor.setValorBensCasa(LeDouble());
				
				System.out.println("Qual o valor de bens em carros? ");
				professor.setValorBensCarro(LeDouble());
				
				contribuintes.add(professor);
				break;
			
			default:
				break;
		}
	}
	
	private static void mostraNumContribuintes() {
		int contadores[] = {0, 0, 0, 0, 0, 0};
		
		for (int i = 0; i < contribuintes.size(); i++) {
			if (contribuintes.get(i) instanceof Caminhoneiro) {
				contadores[0] ++;
			}
			else if (contribuintes.get(i) instanceof Taxista) {
				contadores[1] ++;
			}
			else if (contribuintes.get(i) instanceof Engenheiro) {
				contadores[2] ++;
			}
			else if (contribuintes.get(i) instanceof Medico) {
				contadores[3] ++;
			}
			else if (contribuintes.get(i) instanceof Politico) {
				contadores[4] ++;
			}
			else if (contribuintes.get(i) instanceof Professor) {
				contadores[5] ++;
			}
		}
		System.out.println("Contribuintes Caminhoneiros: " + contadores[0]);
		System.out.println("Contribuintes Taxistas: " + contadores[1]);
		System.out.println("Contribuintes Engenheiros: " + contadores[2]);
		System.out.println("Contribuintes Medicos: " + contadores[3]);
		System.out.println("Contribuintes Politicos: " + contadores[4]);
		System.out.println("Contribuintes Professores: " + contadores[5] + "\n");
	}
	
	private static void calculaMostraImpostos() {
		for (int i = 0; i < contribuintes.size(); i++) {
			System.out.println("Contribuinte de " + contribuintes.get(i));
			System.out.println("Desconto associdado: " + contribuintes.get(i).desconto());
			System.out.println("Valor do imposto: " + contribuintes.get(i).imposto());
			System.out.println("Valor total do imposto com desconto: " + contribuintes.get(i).totalImposto() + "\n");
		}
	}
	
	private static void mostraSinaisExteriores() {
		for (int i = 0; i < contribuintes.size(); i++) {
			if (contribuintes.get(i).valorTotalBens() > contribuintes.get(i).getLimiar()) {
				System.out.println("Contribuinte de " + contribuintes.get(i));
				System.out.println("Total em bens casa: " + contribuintes.get(i).getValorBensCasa());
				System.out.println("Total em bens carro: " + contribuintes.get(i).getValorBensCarro());
				System.out.println("Total em bens: " + contribuintes.get(i).valorTotalBens());
				System.out.println("Sinal exterior de riqueza excessivo.\n");
			}
			else {
				System.out.println("Contribuinte de " + contribuintes.get(i));
				System.out.println("Total em bens casa: " + contribuintes.get(i).getValorBensCasa());
				System.out.println("Total em bens carro: " + contribuintes.get(i).getValorBensCarro());
				System.out.println("Total em bens: " + contribuintes.get(i).valorTotalBens());
				System.out.println("Sinal exterior de riqueza nao excessivo.\n");
			}
		}
	}
}