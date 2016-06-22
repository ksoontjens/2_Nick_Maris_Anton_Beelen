//Nick Maris 
public class Oef2 {

   public static void main(String[] args) {

  

   String a[] = {"zondag","maandag", "dinsdag", "woensdag", "donderdag", "vrijdag", "zaterdag"};

   int c = 0;

   for(int b = 1; b < 29; b++){

   System.out.println(a[c] + " " + b + " " + "februari");

   c++;

   if(c==7){

   c=0;

   }

   }

   }

}