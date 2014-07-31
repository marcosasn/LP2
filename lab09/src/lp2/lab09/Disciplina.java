package lp2.lab09;

import java.util.ArrayList;
import java.util.List;

public abstract class Disciplina {
	private List<String> preRequisitos;
	private String nome;
	private final String VAZIO = " ";
	private int numProvas;
	protected List<Double> notas;
	
	public Disciplina(String nome, List<String> preRequisitos) throws Exception {
		if ((nome == null) || nome.equals(VAZIO)) {
			throw new Exception("Nome nao pode ser nulo ou vazio.");
		}
		if (preRequisitos == null) {
			throw new Exception("Pre requisitos nao pode ser null.");
		}
		this.nome = nome;
		this.preRequisitos = preRequisitos;
		notas = new ArrayList<>();
	}
	
	public void setNome(String nome) throws Exception {
		if ((nome == null) || nome.equals(VAZIO)) {
			throw new Exception("Nome nao pode ser nulo ou vazio.");
		}
		this.nome = nome;
	}
		
	public String getNome() {
		return nome;
	}
	
	public void setNumProvas(int num) throws Exception {
		if (num < 0) {
			throw new Exception("Numero invalido.");
		}
		numProvas = num;
	}
	
	public int getNumProvas() {
		return numProvas;
	}
	
	public void adicionaNota(double nota) throws Exception {
		if(nota < 0) {
			throw new Exception("Nota nao pode ser negativa.");
		}
		if (verificaNumNotas()) {
			notas.add(nota);
		}
	}
	
	protected boolean verificaNumNotas() {
		if (notas.size() == numProvas) {
			return false;
		}
		return true;
	}
	
	public abstract double calculaMedia();
}
