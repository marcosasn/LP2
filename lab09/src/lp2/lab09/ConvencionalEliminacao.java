package lp2.lab09;

import java.util.List;

public class ConvencionalEliminacao extends Disciplina {
	private int eliminaNumNotas;
	private int numProvas;
	private int contador;
	
	public ConvencionalEliminacao(String nome, List<String> preRequisitos) throws Exception {
		super(nome, preRequisitos);
		contador = 0;
	}
	
	public double calculaMedia() {
		double soma = 0;
		for(int i = 0; i < super.notas.size(); i++) {
			if (super.notas.get(i) < 7.0 && contador <= eliminaNumNotas) {
				super.notas.remove(i);
				contador ++;
			}
			else {
				soma += super.notas.get(i);
			}
		}
		return soma / super.notas.size();
	}

}
