package lp2.pa4;

import java.util.Scanner;

public class Misterio {
  	public static int misterio(int a, int b) {
        	if (b == 1)
              	return a;
        	else
              	return a + misterio(a, b - 1);
  	}
  	
  	public static int pedeIntAoUsuario() {
  		Scanner entrada = new Scanner(System.in);
  		return entrada.nextInt();
  	}
  	
  	public static int pedeIntPositivoDiferenteDeZeroAoUsuario() {
  		int num = pedeIntAoUsuario();
  		if (num != 0) {
  			return num;
  		}
  		else {
  			return pedeIntPositivoDiferenteDeZeroAoUsuario();
  		}
  	}
 
  	public static void main(String[] args) {
        	int a = pedeIntAoUsuario();
        	int b = pedeIntPositivoDiferenteDeZeroAoUsuario();
        	System.out.println(misterio(a, b));
  	}
}
