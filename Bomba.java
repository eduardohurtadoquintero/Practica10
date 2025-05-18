import java.util.ArrayList;

public class Bomba extends Elemento implements Destruible {
    int radio;

    public Bomba(int posicion, ArrayList<Escenario> escenarios, int radio) {
        super(posicion, escenarios);
        this.radio = radio;
    }

    public void explotar() {
        // Llamar a destruirElementos en cada escenario
        for (Escenario escenario : getEscenarios()) {
            escenario.destruirElementos(getPosicionInt(), radio);
        }
    }

    public void destruir() {
        // Lógica para destruir la bomba
        System.out.println("Bomba destruida en posición " + getPosicionInt());
    }
}
