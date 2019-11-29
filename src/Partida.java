
import java.util.Scanner;

public class Partida {

    Scanner leer = new Scanner(System.in);
    private Jugador j1, j2;
    private Tablero tablero;
    private int turno;

    public Partida() {
        this.j1 = new Jugador(1);
        this.j2 = new Jugador(2);
        this.tablero = new Tablero();
        this.turno = 1;

        mostrarPartida();

        System.out.println("Colocando fichas...");
        tablero.llenar();

        mostrarPartida();
    }

    public void mostrarPartida() {
        System.out.println("\n "
                + "\n "
                + "-------------- EQUIPO 1 (v) --------------");
        j1.mostrarMano();

        tablero.mostrar();

        j2.mostrarMano();
        System.out.println("-------------- EQUIPO 2 (^) --------------"
                + "\n "
                + "\n ");
    }

    public void turnoJ1() {
        int opc;
        System.out.println("-- Turno equipo 1 --"
                + "\n   ¿Qué desea hacer?"
                + "\n 1.- Mover una ficha."
                + "\n 2.- Reingresar una ficha."
                + "\n "
                + "\n Ingrese una opción: ");
        do {
            opc = leer.nextInt();
            if (opc != 1 && opc != 2) {
                System.err.println("Opción incorrecta, intente nuevamente.");
            }
        } while (opc != 1 && opc != 2);

        switch (opc) {
            case 1:
                j1.moverFicha(tablero, 1);
                break;
            case 2:
                j1.reingresarFicha(tablero, 1);
                break;
        }
        setTurno(2);
    }

    public void turnoJ2() {
        int opc;
        System.out.println("-- Turno equipo 2 --"
                + "\n   ¿Qué desea hacer?"
                + "\n 1.- Mover una ficha."
                + "\n 2.- Reingresar una ficha."
                + "\n "
                + "\n Ingrese una opción: ");
        do {
            opc = leer.nextInt();
            if (opc != 1 && opc != 2) {
                System.err.println("Opción incorrecta, intente nuevamente.");
            }
        } while (opc != 1 && opc != 2);

        switch (opc) {
            case 1:
                j2.moverFicha(tablero, 2);
                break;
            case 2:
                j2.reingresarFicha(tablero, 2);
                break;
        }
        setTurno(1);
    }

    public Jugador getJ1() {
        return j1;
    }

    public void setJ1(Jugador j1) {
        this.j1 = j1;
    }

    public Jugador getJ2() {
        return j2;
    }

    public void setJ2(Jugador j2) {
        this.j2 = j2;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }
    
    

}
