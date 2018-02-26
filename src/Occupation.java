/**
 * Created by DufVi1731300 on 2018-02-26.
 */
public class Occupation {
    private String poste = "";
    private Entreprise ent = new Entreprise();

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        if (!poste.equals("")) this.poste = poste;
    }

    public Entreprise getEnt() {
        return ent;
    }
}
