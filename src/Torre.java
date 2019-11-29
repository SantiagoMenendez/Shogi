
public class Torre extends Ficha {

    public Torre(int equipo) {
        super("Torre", "R", equipo);
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
            if ((hacia.getJ() == desde.getJ() + 1 || hacia.getJ() == desde.getJ() - 1) && (hacia.getI() == desde.getI() + 1 || hacia.getI() == desde.getI() - 1)) {
                return true;
            }
        }

        if (desde.getI() != hacia.getI() && desde.getJ() != hacia.getJ()) {
            return false;
        }

        if (desde.getI() - hacia.getI() > 0) {
            for (int i = desde.getI() - 1; i > hacia.getI(); i--) {
                if (tablero.getCasilla(i, desde.getJ()).getFicha() != null) {
                    return false;
                }
            }
        }

        if (desde.getI() - hacia.getI() < 0) {
            for (int i = desde.getI() + 1; i < hacia.getI(); i++) {
                if (tablero.getCasilla(i, desde.getJ()).getFicha() != null) {
                    return false;
                }
            }
        }

        if (desde.getJ() - hacia.getJ() > 0) {
            for (int i = desde.getJ() - 1; i > hacia.getJ(); i--) {
                if (tablero.getCasilla(desde.getI(), i).getFicha() != null) {
                    return false;
                }
            }
        }

        if (desde.getJ() - hacia.getJ() < 0) {
            for (int i = desde.getJ() + 1; i < hacia.getJ(); i++) {
                if (tablero.getCasilla(desde.getI(), i).getFicha() != null) {
                    return false;
                }
            }
        }

        return true;
    }
}
