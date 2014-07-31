package lp2.lab02;

public class NumeroPalindromo {
	public static void main(String []args){
		char []valores = args[0].toCharArray();
		if (EhPalindromo(valores)) {
			System.out.println("SIM");
		}
		else {
			System.out.println("NAO");
		}
	}
	
	private static boolean EhPalindromo(char []valores){
		int somador = 0;
		int somadorDois = 0;
		for (int i = 0; i < valores.length; i++) {
			somador += Integer.valueOf(valores[i]);
		}
		for (int i = valores.length-1; i >= 0; i--) {
			somadorDois += Integer.valueOf(valores[i]);
		}
	
		if (somador == somadorDois) {
			return true;
		}
		else {
			return false;
		}
	}
}