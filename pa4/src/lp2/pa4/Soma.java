package lp2.pa4;

public class Soma {
	public static int soma( int n ){
		if ( n == 0 )
			return 0;
		else
			return n + soma( n - 1 );
	}
	
	public static void main(String[] args) {
		System.out.println(soma(5));
	}
}