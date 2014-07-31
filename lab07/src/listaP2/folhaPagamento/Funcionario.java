package listaP2.folhaPagamento;

public abstract class Funcionario {
	protected String nome;
	protected String sobrenome;
	protected static int numFun = 0;
	
	public Funcionario(String nome, String sobrenome) {
		this.nome = nome;
		this.sobrenome = sobrenome;
	}
	
	public abstract void registraHoras(String hora);
	
	public abstract void registraFalta(String dia);
	
	public abstract double valorSalario();
	
	public int getNumFun() {
		return numFun;
	}
	
	public String toString() {
		return "nome: "+ nome + ", sobrenome: " + sobrenome; 
	}
}