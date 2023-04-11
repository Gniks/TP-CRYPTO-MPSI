import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Scanner;

public class TestRSA {
     BigInteger p, q, n, phi, e , d;
     BigInteger chiffre;


      public BigInteger[] hashage(int taille){

           // Declaration des variables

           // Creation des entiers premiers
           p = BigInteger.probablePrime(taille/2, new SecureRandom());
           q = BigInteger.probablePrime(taille/2, new SecureRandom());

           // Calcul du modulo n et du nombre d'Euler phi
           n = p.multiply(q);
           phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

           // Generation de l'exposant public
           e = new BigInteger(taille/4, new SecureRandom());
           while(e.gcd(phi).intValue() != 1)
           {
                e = new BigInteger(taille/4, new SecureRandom());
           }
           // Calcul de l'exposant privé
           d = e.modInverse(phi);
           BigInteger[] cle = {n,e ,d};
           /*Affichage des cles
           System.out.println("Modulo n = "  +n);
           System.out.println("Exposant public e = "  +e);
           System.out.println("Exposant prive d = "  +d);*/

           return cle;
      }


     public BigInteger chiffrer(String message, BigInteger[] cle) {
          // Saisi et conversion des données BIGINTEGER
          BigInteger m = new BigInteger(message.getBytes());
          BigInteger chiff = m.modPow(cle[1], cle[0]);

          return chiff;
     }



     public String dechiffrer(BigInteger chiffre, BigInteger[] cle) {
          BigInteger dechiffre = chiffre.modPow(cle[2], cle[0]);
          String message = new String(dechiffre.toByteArray());

          return message;
     }


}
