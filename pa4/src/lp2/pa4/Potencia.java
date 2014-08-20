package lp2.pa4;

public class Potencia {
	
	public static int potencia(int base, int expoente) {
		if (expoente == 1) {
			return base;
		}
		else {
			return base * potencia(base, expoente - 1);
		}
	}
	
	public static void main(String [] args) {
		System.out.println(potencia(2, 5));
	}
}
