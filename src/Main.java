import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        TestRSA testRSA = new TestRSA();

        BigInteger[] cle = testRSA.hashage(512);
        BigInteger modulo, expoPub,expoPriv;
        modulo = cle[0]; expoPub = cle[1]; expoPriv = cle[2];
        System.out.println("Modulo n = "  +modulo);
        System.out.println("Exposant public e = "  +expoPub);
        System.out.println("Exposant prive d = "  +expoPriv);

        Scanner s = new Scanner(System.in);
        System.out.println("Saisir un message");
        String message = s.nextLine();

        // Chiffrement
        BigInteger chiffre = testRSA.chiffrer(message,cle);
        System.out.println("Chiffré = " + new String(chiffre.toByteArray()));



        // Dechiffrement
        String dechiffre = testRSA.dechiffrer(chiffre,cle);
        System.out.println("Dechiffré = " + dechiffre);

    }
}
