
public class Caballo extends Ficha {

    public Caballo(int equipo) {
        super("Caballo", "N", equipo);
    }

    @Override
    public boolean posibleMover(Casilla desde, Casilla hacia, Tablero tablero) {

        if (hacia.getFicha() != null) {
            if (desde.getFicha().getEquipo() == hacia.getFicha().getEquipo()) {
                return false;
            }
        }

        if (desde.getI() == hacia.getI() && desde.getJ() == hacia.getJ()) {
            return false;
        }

        if (promovida) {
            if ((Math.abs(desde.getI() - hacia.getI()) <= 1 && (Math.abs(desde.getJ() - hacia.getJ()) <= 1))) {
                if (equipo == 1) {
                    if (desde.getI() - hacia.getI() == 1) {
                        if (desde.getJ() != hacia.getJ()) {
                            return false;
                        }
                    }
                } else if (equipo == 2) {
                    if (desde.getI() - hacia.getI() == -1) {
                        if (desde.getJ() != hacia.getJ()) {
                            return false;
                        }
                    }
                }
            }
            return true;
        } else {
            if (equipo == 1) {
                if (desde.getI() - hacia.getI() != -2 || Math.abs(desde.getJ() - hacia.getJ()) != 1) {
                    return false;
                }
            }
            if (equipo == 2) {
                if (desde.getI() - hacia.getI() != 2 || Math.abs(desde.getJ() - hacia.getJ()) != 1) {
                    return false;
                }
            }
            return true;
        }
    }
}
