import java.util.ArrayList;
import java.util.stream.Collectors;

public class Escenario {
    protected String nombre;
    private static final int TAMANO_MATRIZ = 10; // Tamaño predeterminado de la matriz
    ArrayList<Elemento> campoDeBatalla = new ArrayList<>();

    public Escenario(String nombre) {
        this.nombre = nombre;
    }

    public void agregarElemento(Elemento elemento) {
        campoDeBatalla.add(elemento);
    }

    public void destruirElementos(int posicion, int radio) {
        // Filtrar elementos dentro del radio de la explosión
        ArrayList<Elemento> elementosEnRadio = new ArrayList<>();
        for (Elemento elemento : campoDeBatalla) {
            // Lógica para determinar si el elemento está dentro del radio
            if (Math.abs(elemento.getPosicionInt() - posicion) <= radio) {
                elementosEnRadio.add(elemento);
            }
        }

        // Filtrar solo elementos Destruibles y destruirlos
        ArrayList<Destruible> elementosDestruibles = elementosEnRadio.stream()
            .filter(e -> e instanceof Destruible)
            .map(e -> (Destruible) e)
            .collect(Collectors.toCollection(ArrayList::new));

        for (Destruible destruible : elementosDestruibles) {
            destruible.destruir();
            System.out.println("Elemento destruido: " + destruible);
        }

        // Remover elementos destruidos del campo de batalla
        campoDeBatalla.removeAll(elementosDestruibles);
    }

    @Override
    public String toString() {
        char[][] matriz = new char[TAMANO_MATRIZ][TAMANO_MATRIZ];
        
        // Inicializar matriz con espacios vacíos
        for (int i = 0; i < TAMANO_MATRIZ; i++) {
            for (int j = 0; j < TAMANO_MATRIZ; j++) {
                matriz[i][j] = '.';
            }
        }

        // Colocar elementos en la matriz
        for (Elemento elemento : campoDeBatalla) {
            int pos = elemento.getPosicionInt();
            char simbolo;
            
            if (elemento.getClass() == Bomba.class) simbolo = 'B';
            else if (elemento.getClass() == Roca.class) simbolo = 'R';
            else if (elemento.getClass() == Extraterrestre.class) simbolo = 'E';
            else if (elemento.getClass() == Terricola.class) simbolo = 'T';
            else simbolo = 'X';

            int fila = pos / TAMANO_MATRIZ;
            int columna = pos % TAMANO_MATRIZ;
            
            if (fila < TAMANO_MATRIZ && columna < TAMANO_MATRIZ) {
                matriz[fila][columna] = simbolo;
            }
        }

        // Convertir matriz a cadena
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < TAMANO_MATRIZ; i++) {
            for (int j = 0; j < TAMANO_MATRIZ; j++) {
                sb.append(matriz[i][j]).append(" ");
            }
            sb.append("\n");
        }
        
        return sb.toString();
    }
}
