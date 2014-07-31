package listaP2.folhaPagamento;

import java.util.ArrayList;

public class Horistas extends Funcionario {
	private double salarioPorHora;
	private int numeroHoras;
	private ArrayList<String> horasTrabalhadas;
	private ArrayList<String> faltas;
	private String stringHoras;
	
	public Horistas(String nome, String sobrenome, double salarioPorHora, int numeroHoras) {
		super(nome, sobrenome);
		this.salarioPorHora = salarioPorHora;
		this.numeroHoras = numeroHoras;
		stringHoras = "";
		faltas = new ArrayList();
		horasTrabalhadas = new ArrayList();
		numFun ++;
	}
	
	public void registraFalta(String dia) {
		faltas.add(dia);
	}
	
	public void registraHoras(String hora) {
		horasTrabalhadas.add(hora);
	}
	
	public double valorSalario() {
		return numeroHoras * salarioPorHora;
	}
	
	public String toString() {	
		return "Nome: " + nome + "\nSobrenome: " + sobrenome + "\nSalario por hora: "
				+ salarioPorHora + "\nNumero de horas: " + numeroHoras + "\nNoras trabalhadas: "
		+ criaStringHoras()+ "\nValor salario: " + valorSalario(); 
	}
	
	private String criaStringHoras() {
		for (int i = 0; i < horasTrabalhadas.size(); i++) {
			if (i == horasTrabalhadas.size() - 1) {
				stringHoras += horasTrabalhadas.get(i);
			}
			else {
				stringHoras += horasTrabalhadas.get(i) + ", ";
			}
		}
		return stringHoras;
	}
}