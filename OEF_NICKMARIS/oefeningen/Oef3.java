//Nick Maris 
public class Oef3 {

  public static void main(String[] args) {

      double b = 1.0;

      double c = 0.0;

      for(int a = 1; a <= 10000; a++){

          if(a%2 == 1){

              c = c + 1/b;

          } else {

              c = c - 1/b;

          } 

          b+=2;

      }

      System.out.print(4*c);

      }

  }