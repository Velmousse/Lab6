/**
 * Created by DufVi1731300 on 2018-02-26.
 */
public class Entreprise {
    private String nom = "";
    private Adresse ad = new Adresse();

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        if (!nom.equals("")) this.nom = nom;
    }

    public Adresse getAd() {
        return ad;
    }
}
