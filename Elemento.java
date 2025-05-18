import java.util.ArrayList;

public class Elemento {
    private Posicion posicion;
    protected ArrayList<Escenario> escenarios = new ArrayList<>();

    // Constructor for integer position
    public Elemento(int posicionInt, ArrayList<Escenario> escenarios) {
        this.posicion = new Posicion(posicionInt);
        this.escenarios = escenarios;
    }

    // Getter for Posicion object
    public Posicion getPosicion() {
        return posicion;
    }

    // Getter for integer position
    public int getPosicionInt() {
        return posicion.getPosicion();
    }

    // Setter for position
    public void setPosicion(int posicionInt) {
        this.posicion = new Posicion(posicionInt);
    }

    // Getter for escenarios
    public ArrayList<Escenario> getEscenarios() {
        return escenarios;
    }
}
