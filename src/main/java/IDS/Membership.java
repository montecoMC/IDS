package IDS;

import java.util.ArrayList;

public class Membership extends Campagna{
    private final double costo;
    private ArrayList<Premio> catalogoPremi;

    public Membership(int id, String dataFine, double costo, String nome, String dataInizio) {
        super(id,nome, dataFine, dataInizio);
        if (costo <= 0   ) throw new IllegalArgumentException();
        this.costo = costo;
    }

    public double getCosto() {
        return costo;
    }

}
