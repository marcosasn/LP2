package lp2.lab02;

public class SomaPalindromos {
	public static void main(String []args){
		long somador = 0;
		for (int i = 1000000; i <= 9999999; i++) {
			if ((EhPalindromo(i)) && (VerificaPrimo(i))) {
				somador += i;
			}
		}
		System.out.println(somador);
	
	}
	private static boolean EhPalindromo(int valor){
		int somador = 0;
		int somadorDois = 0;
		char []novoValor = Integer.toString(valor).toCharArray();
		for (int i = 0; i < novoValor.length; i++) {
			somador += Integer.valueOf(novoValor[i]);
		}
		for (int i = novoValor.length-1; i >= 0; i--) {
			somadorDois += Integer.valueOf(novoValor[i]);
		}
	
		if (somador == somadorDois) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private static boolean VerificaPrimo(int num){
		for (int j = 2; j < num; j++){
			if (num % j == 0){
				return false;
			}
		}
		return true;
	}
}
