
public class Tablero {

    private Casilla[][] tablero;
    private String[][] borde;

    public Tablero() {
        this.tablero = new Casilla[10][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                tablero[i][j] = new Casilla(i, j);
            }
        }
    }
    
    public void llenar() {
        tablero[0][4].setFicha(new Rey(1));
        tablero[8][4].setFicha(new Rey(2));

        tablero[0][3].setFicha(new GeneralDorado(1));
        tablero[0][5].setFicha(new GeneralDorado(1));
        tablero[8][3].setFicha(new GeneralDorado(2));
        tablero[8][5].setFicha(new GeneralDorado(2));

        tablero[0][2].setFicha(new GeneralPlateado(1));
        tablero[0][6].setFicha(new GeneralPlateado(1));
        tablero[8][2].setFicha(new GeneralPlateado(2));
        tablero[8][6].setFicha(new GeneralPlateado(2));

        tablero[0][1].setFicha(new Caballo(1));
        tablero[0][7].setFicha(new Caballo(1));
        tablero[8][1].setFicha(new Caballo(2));
        tablero[8][7].setFicha(new Caballo(2));

        tablero[0][0].setFicha(new Lancero(1));
        tablero[0][8].setFicha(new Lancero(1));
        tablero[8][0].setFicha(new Lancero(2));
        tablero[8][8].setFicha(new Lancero(2));

        tablero[1][1].setFicha(new Torre(1));
        tablero[7][7].setFicha(new Torre(2));

        tablero[1][7].setFicha(new Alfil(1));
        tablero[7][1].setFicha(new Alfil(2));

        for (int i = 0; i < 9; i++) {
            tablero[2][i].setFicha(new Peon(1));
            tablero[6][i].setFicha(new Peon(2));
        }
    }

    public void mostrar() {

        String aux = "";
        int cont = 0;
        System.out.println("    0   1   2   3   4   5   6   7   8");
        System.out.println("  +------------------------------------+");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (j == 0) {
                    aux += cont + " |";
                }
                if (tablero[i][j].getFicha() == null) {
                    aux += "    ";
                } else {
                    aux += " " + tablero[i][j].getFicha().getAbreviacion() + " ";
                }
                if (j == 8) {
                    aux += "|";
                }
            }
            if (i != 8) {
            aux += "\n";
            }
            cont++;
        }
        System.out.println(aux);
        System.out.println("  +------------------------------------+");
    }

    public Casilla getCasilla(int i, int j) {
        return tablero[i][j];
    }

    public Casilla[][] getTablero() {
        return tablero;
    }

    public void setTablero(Casilla[][] tablero) {
        this.tablero = tablero;
    }

}
