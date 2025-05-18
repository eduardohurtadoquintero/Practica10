import javax.swing.*;
import java.util.ArrayList;

public class Roca extends Elemento{
    private int radio;

    public Roca(int radio,String nombre){
        super(0, new ArrayList<>()); // Default position 0, empty escenarios list
        this.radio = radio;
    }

    public Roca(int posicion, ArrayList<Escenario> escenarios, int radio){
        super(posicion, escenarios);
        this.radio = radio;
    }

    public int getRadio(){
        return radio;
    }
}
