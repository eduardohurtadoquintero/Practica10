import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Create an ArrayList of Escenario for constructor calls
        ArrayList<Escenario> escenarios = new ArrayList<>();

        // Create the scenario
        Escenario e = new Escenario("Nostromo");
        escenarios.add(e);

        // Create and add elements with correct constructor calls
        Terricola terricola = new Terricola(5, escenarios, "Ripley", 100);
        e.agregarElemento(terricola);

        Extraterrestre extraterrestre = new Extraterrestre(10, escenarios, "Alien", 100);
        e.agregarElemento(extraterrestre);

        Roca roca = new Roca(1, "Roca");
        e.agregarElemento(roca);

        Bomba b = new Bomba(15, escenarios, 2);
        e.agregarElemento(b);

        // Print scenario and explode bomb
        System.out.println(e);
        b.explotar();
    }
}