
public class GeneralDorado extends Ficha {

    public GeneralDorado(int equipo) {
            super("General Dorado", "G", equipo);
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
    }

    @Override
    public void promover() {
        System.out.println("El general dorado no puede ser promovido.");
    }

    @Override
    public void degradar() {
        System.out.println("El general dorado no puede ser degradado.");
    }
}
