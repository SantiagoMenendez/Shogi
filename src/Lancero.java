
public class Lancero extends Ficha {

    public Lancero(int equipo) {
        super("Lancero", "L", equipo);
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
                if (desde.getI() - hacia.getI() < 0 && desde.getJ() == hacia.getJ()) {
                    for (int i = desde.getI() + 1; i < hacia.getI(); i++) {
                        if (tablero.getCasilla(i, desde.getJ()).getFicha() != null) {
                            return false;
                        }
                    }
                }
                return true;
            } else {
                if (desde.getI() - hacia.getI() > 0 && desde.getJ() == hacia.getJ()) {
                    for (int i = desde.getI() - 1; i < hacia.getI(); i++) {
                        if (tablero.getCasilla(i, desde.getJ()).getFicha() != null) {
                            return false;
                        }
                    }
                }
                return true;
            }

        }
    }
}
