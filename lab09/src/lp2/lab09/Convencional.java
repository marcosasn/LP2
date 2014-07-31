package lp2.lab09;

import java.util.List;

public class Convencional extends Disciplina {
	
	
	public Convencional(String nome, List<String> preRequisitos) throws Exception {
		super(nome, preRequisitos);
	}
		
	public double calculaMedia() {
		double soma = 0; 
		for(int i = 0; i < super.notas.size(); i++) {
			soma += super.notas.get(i);
		}
		return soma/super.notas.size();
	}

}
