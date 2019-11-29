
import java.util.ArrayList;
import java.util.Scanner;

public class Jugador {

    Scanner leer = new Scanner(System.in);
    private ArrayList<Ficha> mano = new ArrayList<>();
    private int equipo;

    public Jugador(int equipo) {
        this.equipo = equipo;
    }

    public void agregarFicha(Ficha ficha) {
        mano.add(ficha);
    }

    public void eliminarFicha(Ficha ficha) {
        for (int i = 0; i < mano.size(); i++) {
            if (mano.get(i).getAbreviacion().equals(ficha.getAbreviacion())) {
                mano.remove(i);
                break;
            }
        }
    }

    public void reingresarFicha(Tablero tablero, int turno) {

        if (mano == null || mano.isEmpty()) {
            System.out.println("No tiene ninguna ficha para reingresar."
                    + "\nPuede mover una ficha.");
            moverFicha(tablero, turno);
        } else {

            boolean baux = false;
            Ficha faux = null;

            do {
                System.out.println("¿Qué pieza desea reingresar?");
                String aux = leer.next();

                for (Ficha fichaf : mano) {
                    if (fichaf.getAbreviacion().equalsIgnoreCase(aux)) {
                        faux = fichaf;
                        baux = true;
                        break;
                    }
                }

                if (baux == false) {
                    System.out.println("No se encontro la ficha, intente de nuevo.");
                } else {
                    boolean err = true;
                    do {
                        int dy, dx;
                        do {
                            System.out.println("Ingrese la casilla donde desea colocar la ficha. (Y-X Una coordenada a la vez)");
                            dy = leer.nextInt();
                            dx = leer.nextInt();
                            if (dy < 0 || dy > 8 || dx < 0 || dx > 8) {
                                System.out.println("Los valores deben estar entre 0 y 8.");
                            }
                        } while (dy < 0 || dy > 8 || dx < 0 || dx > 8);
                        Casilla caux = tablero.getCasilla(dy, dx);

                        if (caux.getFicha() != null) {
                            System.out.println("No puede ingresar la ficha en esa casilla.");
                        } else if ("Peón".equals(faux.getNombre()) && (faux.getEquipo() == 1 && caux.getI() == 8) || (faux.getEquipo() == 2 && caux.getI() == 0)) {
                            System.out.println("Los peónes no se pueden reintroducir en la última fila.");
                        } else if ("Lancero".equals(faux.getNombre()) && (faux.getEquipo() == 1 && caux.getI() == 8) || (faux.getEquipo() == 2 && caux.getI() == 0)) {
                            System.out.println("Los peónes no se pueden reintroducir en la última fila.");
                        } else if ("Caballo".equals(faux.getNombre()) && ((faux.getEquipo() == 1 && (caux.getI() == 8 || caux.getI() == 9)) || (faux.getEquipo() == 2 && (caux.getI() == 0 || caux.getI() == 1)))) {
                            System.out.println("Los caballos no se pueden reintroducir en las últimas dos filas.");         
                        } else {
                            caux.setFicha(faux);
                            err = false;
                            mano.remove(faux);
                        }
                    } while (err == true);
                }
            } while (baux == false);
        }
    }

    public void moverFicha(Tablero tablero, int turno) {
        Casilla desde = null, hacia = null;
        int dx, dy, hx, hy;
        Ficha fichaDesde;

        do {

            do {
                do {
                    System.out.println("Ingrese la casilla de la ficha que desea mover. (Y-X Una coordenada a la vez)");
                    dy = leer.nextInt();
                    dx = leer.nextInt();
                    if (dy < 0 || dy > 8 || dx < 0 || dx > 8) {
                        System.out.println("Los valores deben estar entre 0 y 8.");
                    }
                } while (dy < 0 || dy > 8 || dx < 0 || dx > 8);
                if (tablero.getCasilla(dy, dx).getFicha() == null || tablero.getCasilla(dy, dx).getFicha().getEquipo() != turno) {
                    System.out.println("No hay una ficha válida para mover.");
                }
            } while (tablero.getCasilla(dy, dx).getFicha() == null || tablero.getCasilla(dy, dx).getFicha().getEquipo() != turno);
            desde = tablero.getCasilla(dy, dx);
            do {
                System.out.println("Ingrese la casilla a la que desea mover la ficha. (Y-X Una coordenada a la vez)");
                hy = leer.nextInt();
                hx = leer.nextInt();
                if (hy < 0 || hy > 8 || hx < 0 || hx > 8) {
                    System.out.println("Los valores deben estar entre 0 y 8.");
                }
            } while (hy < 0 || hy > 8 || hx < 0 || hx > 8);
            hacia = tablero.getCasilla(hy, hx);

            fichaDesde = desde.getFicha();

            if (fichaDesde.posibleMover(desde, hacia, tablero)) {
                if (desde.getFicha().isPromovida() == false) {

                    if (hacia.getI() <= 2 && desde.getFicha().getEquipo() == 2 || hacia.getI() <= 2 && desde.getFicha().getEquipo() == 2) {
                            desde.getFicha().promover();
                        }

                        if ((hacia.getI() >= 6 && desde.getFicha().getEquipo() == 1) || hacia.getI() >= 6 && desde.getFicha().getEquipo() == 1) {
                            desde.getFicha().promover();
                        }
                }
       
                if (hacia.getFicha() != null) {
                    if ("Rey".equalsIgnoreCase(hacia.getFicha().getNombre())) {
                        System.out.println("¡El jugador " + desde.getFicha().getEquipo() + " capturo al rey enemigo y ganó!"
                                + "\nFin del juego.");
                        System.exit(0);
                    } else {

                        hacia.getFicha().degradar();
                        if (hacia.getFicha().getEquipo() == 1) {
                            hacia.getFicha().setAbreviacion(hacia.getFicha().getAbreviacion().replace("v", "^"));
                            hacia.getFicha().setEquipo(2);
                        } else {
                            hacia.getFicha().setAbreviacion(hacia.getFicha().getAbreviacion().replace("^", "v"));
                            hacia.getFicha().setEquipo(1);
                        }
                        mano.add(hacia.getFicha());
                    }
                }
                break;
            } else {
                System.err.println("Movimiento no válido.");
            }
        } while (fichaDesde.posibleMover(desde, hacia, tablero) == false);
        System.out.println("Ficha movida con éxito.");
        desde.setFicha(null);
        hacia.setFicha(null);
        hacia.setFicha(fichaDesde);
    }

    public void mostrarMano() {
        System.out.println("Fichas capturadas:");
        for (Ficha ficha : mano) {
            System.out.print(ficha.getAbreviacion() + "  ");
        }
        System.out.println("\n");
    }

    public ArrayList<Ficha> getMano() {
        return mano;
    }

    public void setMano(ArrayList<Ficha> mano) {
        this.mano = mano;
    }

    public int getEquipo() {
        return equipo;
    }

    public void setEquipo(int equipo) {
        this.equipo = equipo;
    }
}
