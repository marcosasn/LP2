package refactoring.exercicio.versao1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class Cliente {
	private String nome;
	private List<Aluguel> dvdsAlugados = new ArrayList<Aluguel>();

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
		final String fimDeLinha = System.getProperty("line.separator");
		double valorTotal = 0.0;
		int pontosDeAlugadorFrequente = 0;
		Iterator<Aluguel> alugueis = dvdsAlugados.iterator();
		String resultado = "Registro de Alugueis de " + getNome() + fimDeLinha;
		while (alugueis.hasNext()) {
			double valorCorrente = 0.0;
			Aluguel cada = alugueis.next();

			// determina valores para cada linha
			switch (cada.getDVD().getCodigoDePreco()) {
			case DVD.NORMAL:
				valorCorrente += 2;
				if (cada.getDiasAlugado() > 2) {
					valorCorrente += (cada.getDiasAlugado() - 2) * 1.5;
				}
				break;
			case DVD.LANCAMENTO:
				valorCorrente += cada.getDiasAlugado() * 3;
				break;
			case DVD.INFANTIL:
				valorCorrente += 1.5;
				if (cada.getDiasAlugado() > 3) {
					valorCorrente += (cada.getDiasAlugado() - 3) * 1.5;
				}
				break;
			} // switch
				// trata de pontos de alugador frequente
			pontosDeAlugadorFrequente++;
			// adiciona bonus para aluguel de um lan�amento por pelo menos 2
			// dias
			if (cada.getDVD().getCodigoDePreco() == DVD.LANCAMENTO
					&& cada.getDiasAlugado() > 1) {
				pontosDeAlugadorFrequente++;
			}

			// mostra valores para este aluguel
			resultado += "\t" + cada.getDVD().getTitulo() + "\t"
					+ valorCorrente + fimDeLinha;
			valorTotal += valorCorrente;
		} // while
			// adiciona rodap�
		resultado += "Valor total devido: " + valorTotal + fimDeLinha;
		resultado += "Voce acumulou " + pontosDeAlugadorFrequente
				+ " pontos de alugador frequente";
		return resultado;
	}
}