public class Posicion {
    protected int renglon;
    protected int columna;

    public Posicion() {
        this.renglon = 0;
        this.columna = 0;
    }

    public Posicion(int posicion) {
        this.renglon = posicion / 10;  // Assuming 10x10 grid
        this.columna = posicion % 10;
    }

    public int getRenglon() {
        return renglon;
    }

    public int getColumna() {
        return columna;
    }

    // Method to get position as a single integer
    public int getPosicion() {
        return renglon * 10 + columna;
    }

    // New method to get position as specified
    public int getposicion() {
        return renglon * 10 + columna;
    }
}
