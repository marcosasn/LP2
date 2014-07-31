package lp2.lab02;

public class NumeroPrimo {
	public static void main(String []args){
		int contador = 0;
		int valor;
		for (int i = 0; i < args.length; i++){
			valor = Integer.valueOf(args[i]);
			if (VerificaPrimo(valor)){
				contador++;
			}	
		}
		System.out.println(contador);
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