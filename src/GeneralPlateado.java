
public class GeneralPlateado extends Ficha {

    public GeneralPlateado(int equipo) {
        super("General Plateado", "S", equipo);
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
            if ((Math.abs(desde.getI() - hacia.getI()) <= 1 && (Math.abs(desde.getJ() - hacia.getJ()) <= 1))) {
                if (equipo == 1) {
                    if (desde.getI() - hacia.getI() == 1) {
                        if (desde.getJ() == hacia.getJ()) {
                            return false;
                        }
                    }
                } else if (equipo == 2) {
                    if (desde.getI() - hacia.getI() == -1) {
                        if (desde.getJ() == hacia.getJ()) {
                            return false;
                        }
                    }
                }

                if ((hacia.getJ() == desde.getJ() + 1 || hacia.getJ() == desde.getJ() - 1) && (hacia.getI() == desde.getI() + 1 || hacia.getI() == desde.getI() - 1)) {
                    return true;
                }
            }
            return true;
        }
    }

}
