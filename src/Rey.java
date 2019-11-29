
public class Rey extends Ficha {

    public Rey(int equipo) {
        super("Rey", "K", equipo);
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

        if ((hacia.getJ() == desde.getJ() + 1 || hacia.getJ() == desde.getJ() - 1) && hacia.getI() == desde.getI()) {
            return true;
        } else if (((hacia.getI() == desde.getI() + 1 || hacia.getI() == desde.getI() - 1) && hacia.getJ() == desde.getJ())) {
            return true;
        } else if ((hacia.getJ() == desde.getJ() + 1 || hacia.getJ() == desde.getJ() - 1) && (hacia.getI() == desde.getI() + 1 || hacia.getI() == desde.getI() - 1)) {
            return true;
        }
        return false;
    }

    @Override
    public void promover() {
        System.out.println("El rey no puede ser promovido.");
    }

    @Override
    public void degradar() {
        System.out.println("El rey no puede ser degradado.");
    }
}
