package listaP2.folhaPagamento;

public class Testando {

	public static void main(String[] args) {
		Mensalistas tecnico = new Mensalistas("Marcos", "Antônio", 650.00, 2);
		tecnico.registraFalta("25/07/2013");
		tecnico.registraFalta("26/07/2013");
		
		System.out.println(tecnico + "\n");
		
		System.out.println(tecnico.getNumFun());
		
		Horistas servente = new Horistas("Jose", "Pinheiro", 20.00, 8);
		servente.registraHoras("08:00 as 12:00");
		servente.registraHoras("14:00 as 16:00");
		
		System.out.println(servente);
		
		System.out.println(servente.getNumFun());
		
	}
}
