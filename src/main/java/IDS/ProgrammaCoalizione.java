package IDS;

import java.util.ArrayList;

public class ProgrammaCoalizione extends Campagna{
    private ArrayList<Azienda> listaAziende;
    private ArrayList<Premio> catalogoPremi;
    private final CampagnaSconti campagnaScelta;

    public ProgrammaCoalizione(int id, String nome, String dataFine, CampagnaSconti campagnaScelta, String dataInizio) {
        super(id,nome, dataFine,dataInizio);
        this.campagnaScelta = campagnaScelta;
    }

    public ArrayList<Azienda> getListaAziende() {
        return listaAziende;
    }

    public ArrayList<Premio> getCatalogoPremi() {
        return catalogoPremi;
    }

    public CampagnaSconti getCampagnaScelta() {
        return campagnaScelta;
    }
}
