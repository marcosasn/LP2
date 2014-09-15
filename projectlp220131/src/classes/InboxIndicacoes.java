package classes;

import java.util.ArrayList;
import java.util.List;

public class InboxIndicacoes {
	
	private List<SistemaDeIndicacao> inbox;
	
	public InboxIndicacoes() {
		inbox = new ArrayList<SistemaDeIndicacao>();
	}
	
	public void recebeIndicacao(SistemaDeIndicacao indicacao) throws Exception {
		isIndicacaoValida(indicacao);
		inbox.add(indicacao);
	}
	
	public void removeIndicacao(SistemaDeIndicacao indicacao) throws Exception {
		isIndicacaoValida(indicacao);
		inbox.remove(indicacao);
	}
	
	private void isIndicacaoValida(SistemaDeIndicacao indicacao) throws Exception {
		if (indicacao == null)
			throw new Exception("Indicacao nao pode ser vazia o nula");
	}
	
	private String relatorioDeIndicacoes() {
		String relatorio = "";
		for (SistemaDeIndicacao indicacao : inbox) {
			relatorio += indicacao.getINDICADOR() + " indicou o item " + indicacao.getITEM().getNome() + "\n";
		}
		return relatorio;
	}
	
	@Override
	public String toString() {
		return relatorioDeIndicacoes();
	}

}
