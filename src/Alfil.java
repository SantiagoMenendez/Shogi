
public class Alfil extends Ficha {

    public Alfil(int equipo) {
        super("Alfil", "B", equipo);
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
            if ((hacia.getJ() == desde.getJ() + 1 || hacia.getJ() == desde.getJ() - 1) && hacia.getI() == desde.getI()) {
                return true;
            } else if (((hacia.getI() == desde.getI() + 1 || hacia.getI() == desde.getI() - 1) && hacia.getJ() == desde.getJ())) {
                return true;
            }
        }

        int dirJ = desde.getJ() > hacia.getJ() ? 1 : -1;
        int dirI = desde.getI() > hacia.getI() ? 1 : -1;

        for (int i = 1; i < Math.abs(hacia.getJ() - desde.getJ()); i++) {
            if (tablero.getCasilla(desde.getI() + i * dirI, desde.getJ() + i * dirJ).getFicha() != null) {
                return false;
            }
        }
        return true;
    }
}
