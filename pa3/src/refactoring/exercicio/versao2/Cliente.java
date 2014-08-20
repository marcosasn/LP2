package refactoring.exercicio.versao2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cliente {
	private String nome;
	private List<Aluguel> dvdsAlugados = new ArrayList<Aluguel>();
	public final String fimDeLinha = System.getProperty("line.separator");
	private double valorTotal;
	public double valorCorrente;
	public int pontosDeAlugadorFrequente;
	public String resultado;

	public Cliente(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void adicionaAluguel(Aluguel aluguel) {
		dvdsAlugados.add(aluguel);
	}

	public String extrato() {		
		Iterator<Aluguel> alugueis = dvdsAlugados.iterator();
		resultado = "Registro de Alugueis de " + getNome() + fimDeLinha;
		
		while (alugueis.hasNext()) {
			Aluguel cada = alugueis.next();
			calculos(cada);
		}
		
		adicionaRodape();
		return resultado;
	}
	
	public String extratoDiferente() {
		resultado = extrato();
		
		String novo = "Voce acumulou " + pontosDeAlugadorFrequente
				+ " pontos de alugador frequente" + fimDeLinha + 
				"Valor total devido: " + valorTotal;
		return novo;
	}

	private void calculos(Aluguel cada) {
		switch (cada.getDVD().getCodigoDePreco()) {
		case DVD.NORMAL:
			dvdNormal(cada);
			break;
			
		case DVD.LANCAMENTO:
			dvdLancamento(cada);
			break;
			
		case DVD.INFANTIL:
			dvdInfantil(cada);
			break;
		}
		pontosDeAlugadorFrequente = cada.trataPontos(this);
		
		cada.valorParaAluguel(this);
		valorTotal += valorCorrente;
	}

	private void dvdLancamento(Aluguel cada) {
		valorCorrente += cada.getDiasAlugado() * 3;
	}

	private void dvdNormal(Aluguel cada) {
		valorCorrente += 2;
		if (cada.getDiasAlugado() > 2) {
			valorCorrente += (cada.getDiasAlugado() - 2) * 1.5;
		}
	}

	private void dvdInfantil(Aluguel cada) {
		valorCorrente += 1.5;
		if (cada.getDiasAlugado() > 3) {
			valorCorrente += (cada.getDiasAlugado() - 3) * 1.5;
		}
	}

	int adicionaBonus(Aluguel cada) {
		if (cada.getDVD().getCodigoDePreco() == DVD.LANCAMENTO
				&& cada.getDiasAlugado() > 1) {
			pontosDeAlugadorFrequente++;
		}
		return pontosDeAlugadorFrequente;
	}

	private void adicionaRodape() {
		resultado += "Valor total devido: " + valorTotal + fimDeLinha;
		resultado += "Voce acumulou " + pontosDeAlugadorFrequente
				+ " pontos de alugador frequente";
	}
}