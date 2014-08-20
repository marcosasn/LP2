package refactoring.exercicio.versao2;


public class Aluguel {
	private DVD dvd;
	private int diasAlugado;

	public Aluguel(DVD dvd, int diasAlugado) {
		this.dvd = dvd;
		this.diasAlugado = diasAlugado;
	}

	public DVD getDVD() {
		return dvd;
	}

	public int getDiasAlugado() {
		return diasAlugado;
	}

	void valorParaAluguel(Cliente cliente) {
		cliente.resultado += "\t" + getDVD().getTitulo() + "\t"
				+ cliente.valorCorrente + cliente.fimDeLinha;
	}

	int trataPontos(Cliente cliente) {
		cliente.pontosDeAlugadorFrequente++;
		cliente.pontosDeAlugadorFrequente = cliente.adicionaBonus(this);
		return cliente.pontosDeAlugadorFrequente;
	}
}