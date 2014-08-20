package refactoring.exercicio.versao2;

public class Locadora {
   public static void main(String[] args) {
      Cliente c1 = new Cliente("Guilherme Lopes");
 
      c1.adicionaAluguel(new Aluguel(new DVD(
            "Batman                        ", DVD.NORMAL), 10));
      c1.adicionaAluguel(new Aluguel(new DVD(
            "George, o curioso             ", DVD.INFANTIL), 2));
      c1.adicionaAluguel(new Aluguel(new DVD(
            "O espetacular homem aranha    ", DVD.LANCAMENTO), 30));
      c1.adicionaAluguel(new Aluguel(new DVD(
            "Power Rangers Mistic Force    ", DVD.LANCAMENTO), 4));
      c1.adicionaAluguel(new Aluguel(new DVD(
            "Charlie e Lola                ", DVD.INFANTIL), 10));
      c1.adicionaAluguel(new Aluguel(new DVD(
            "Uma noite no museu            ", DVD.NORMAL), 3));
 
      System.out.println(c1.extratoDiferente());
      }
}