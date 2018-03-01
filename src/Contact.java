import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DufVi1731300 on 2018-02-26.
 */
public class Contact {
    public static int nbContacts = 0;
    private String prenom = "", nom = "", poste = "";
    private Occupation occ = new Occupation();
    private Adresse ad = new Adresse();

    private List<Telephone> listTelephones = new ArrayList<Telephone>();

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        if (!prenom.equals("")) this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        if (!nom.equals("")) this.nom = nom;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        if (!poste.equals("")) this.poste = poste;
    }

    public Occupation getOcc() {
        return occ;
    }

    public Adresse getAd() {
        return ad;
    }

    public List<Telephone> getListTelephones() {
        return listTelephones;
    }
}
