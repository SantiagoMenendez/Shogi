
import java.util.Scanner;


public class NewMain {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        System.out.println("- -- - -- - Shōgi - -- - -- -");
        System.out.println(" "
                + "\nIngrese 1 para comenzar."
                + "\nIngrese cualquier otro caracter para salir.");
        String opc = leer.next();

        if ("1".equals(opc)) {
            Partida p = new Partida();
            
            do {
                p.mostrarPartida();
                if (p.getTurno() == 1) {
                    p.turnoJ1();
                } else {
                    p.turnoJ2();
                }
            } while (1 > 0);
        } else {
            System.out.println("Fin del programa.");
            System.exit(0);
        }
    }
}
