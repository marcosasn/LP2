package listaP2.folhaPagamento;

import java.util.ArrayList;

public class Mensalistas extends Funcionario {
	private double salMensal;
	private int faltas;
	private double multaFalta;
	private ArrayList<String> diasFaltados;
	private ArrayList<String> horasTrabalhadas;
	private String dias;
	
	public Mensalistas(String nome, String sobrenome, double salMensal, int faltas) {
		super(nome, sobrenome);
		this.salMensal = salMensal;
		this.faltas = faltas;
		multaFalta = (salMensal * 0.02) * faltas;
		dias = "";
		diasFaltados = new ArrayList();
		horasTrabalhadas = new ArrayList();
		numFun ++;
	}
	
	public void registraFalta(String dia) {
		diasFaltados.add(dia);
	}
	
	public double valorSalario() {
		if (faltas > 0) {
			return salMensal - multaFalta;
		}
		return salMensal;
	}
	
	public String toString() {
		return "Nome: " + nome + "\nSobrenome: " + sobrenome + "\nSalario mensal: " + salMensal + "\nNumero de faltas: " + faltas +
				"\nDias faltados: "+ criaStringDias() + "\nValor salario: " + valorSalario(); 
	}

	public void registraHoras(String hora) {
		horasTrabalhadas.add(hora);
	}
	
	private String criaStringDias() {
		for (int i = 0; i < diasFaltados.size(); i++) {
			if (i == diasFaltados.size() - 1) {
				dias += diasFaltados.get(i);
			}
			else {
				dias += diasFaltados.get(i) + ", ";
			}
		}
		return dias;
	}
}