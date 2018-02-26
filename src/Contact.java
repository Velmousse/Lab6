import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DufVi1731300 on 2018-02-26.
 */
public class Contact {
    private String prenom = "", nom = "", poste = "";
    private Occupation occ = new Occupation();
    private Adresse ad = new Adresse();

    private List<Telephone> listTelephones = new ArrayList<>();

}
