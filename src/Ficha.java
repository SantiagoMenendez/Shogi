
public abstract class Ficha {

    private String nombre, abreviacion;
    protected int equipo;
    protected boolean promovida = false;

    public Ficha(String nombre, String abreviacion, int equipo) {
        this.nombre = nombre;
        this.abreviacion = abreviacion;
        this.equipo = equipo;

        if (equipo == 1) {
            this.abreviacion = abreviacion.concat("v");
        } else {
            this.abreviacion = abreviacion.concat("^");
        }
    }

    abstract public boolean posibleMover(Casilla desde, Casilla hacia, Tablero tablero);

    public void promover() {
        promovida = true;

        if (!"+".equals(abreviacion.substring(abreviacion.length() - 1))) {
            abreviacion = "+".concat(abreviacion);
        }
    }

    public void degradar() {
        promovida = false;

        abreviacion = abreviacion.replace("+", "");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbreviacion() {
        return abreviacion;
    }

    public void setAbreviacion(String abreviacion) {
        this.abreviacion = abreviacion;
    }

    public int getEquipo() {
        return equipo;
    }

    public void setEquipo(int equipo) {
        this.equipo = equipo;
    }

    public boolean isPromovida() {
        return promovida;
    }

    public void setPromovida(boolean promovida) {
        this.promovida = promovida;
    }
}
