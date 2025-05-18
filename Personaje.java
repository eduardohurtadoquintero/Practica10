import java.util.ArrayList;

public class Personaje extends Elemento implements Destruible {
    protected String nombre;
    protected int puntosdeVida;

    public Personaje(int posicion, ArrayList<Escenario> escenarios, String nombre, int puntosdeVida) {
        super(posicion, escenarios);
        this.nombre = nombre;
        this.puntosdeVida = puntosdeVida;
    }

    @Override
    public void destruir() {
        // Reducir puntos de vida y verificar si el personaje muere
        puntosdeVida -= 10; // Daño por defecto
        if (puntosdeVida <= 0) {
            System.out.println("Personaje " + nombre + " ha sido destruido en posición " + getPosicionInt());
        } else {
            System.out.println("Personaje " + nombre + " ha recibido daño. Puntos de vida restantes: " + puntosdeVida);
        }
    }
}
