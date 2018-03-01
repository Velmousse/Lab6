import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by DufVi1731300 on 2018-02-26.
 */

public class Main {
    final static Scanner sc = new Scanner(System.in);
    static int entree = 0;
    static char entreeChar = ' ';

    public static void main(String[] args) {
        Map<Integer, Contact> mapContacts = new HashMap<Integer, Contact>();

        System.out.print("Bienvenue dans la liste de contacts!\n");
        while (menu(mapContacts)) {

        }
    }

    public static boolean menu(Map map) {
        System.out.print("1- Ajouter un contact\n" +
                "2- Modifier un contact\n" +
                "3- Afficher les contacts\n" +
                "4- Afficher les rappels\n" +
                "5- Quitter\n" +
                "> ");

        switch (sc.nextInt()) {
            case 1: ajouterContact(map); return true;
            case 2: modifierContact(map); return true;
            case 3: afficherContact(map); return true;
            case 4: afficherRappels(map); return true;
            case 5: default: return false;
        }
    }

    public static void ajouterContact(Map map) {
        Contact ct = new Contact();
        System.out.print("Veuillez entrer les informations suivantes (laisser vide si correct)\n" +
                "Prénom: ");
        sc.nextLine();
        ct.setPrenom(sc.nextLine());
        System.out.print("Nom: ");
        ct.setNom(sc.nextLine());
        System.out.print("Adresse\n" +
                " Numéro civique: ");
        ct.getAd().setNumeroCivique(sc.nextLine());
        System.out.print(" Rue: ");
        ct.getAd().setRue(sc.nextLine());
        System.out.print(" Appartement: ");
        ct.getAd().setAppartement(sc.nextLine());
        System.out.print(" Ville: ");
        ct.getAd().setVille(sc.nextLine());
        System.out.print(" Province: ");
        ct.getAd().setProvince(sc.nextLine());
        System.out.print(" Pays: ");
        ct.getAd().setPays(sc.nextLine());
        System.out.print("Occupation\n" +
                " Poste: ");
        ct.getOcc().setPoste(sc.nextLine());
        System.out.print(" Entreprise\n" +
                "  Nom: ");
        ct.getOcc().getEnt().setNom(sc.nextLine());
        System.out.print("  Adresse\n" +
                "   Numéro civique: ");
        ct.getOcc().getEnt().getAd().setNumeroCivique(sc.nextLine());
        System.out.print("   Rue: ");
        ct.getOcc().getEnt().getAd().setRue(sc.nextLine());
        System.out.print("   Appartement: ");
        ct.getOcc().getEnt().getAd().setAppartement(sc.nextLine());
        System.out.print("   Ville: ");
        ct.getOcc().getEnt().getAd().setVille(sc.nextLine());
        System.out.print("   Province: ");
        ct.getOcc().getEnt().getAd().setProvince(sc.nextLine());
        System.out.print("   Pays: ");
        ct.getOcc().getEnt().getAd().setPays(sc.nextLine());
        System.out.print("Voulez-vous entrer un numéro de téléphone (o/u)?\n" +
                "> ");

        while (entreeChar == 'o') {
            Telephone tt = new Telephone();
            System.out.print(" Information (cellulaire, maison, travail): ");
            tt.setInfos(sc.nextLine());
            System.out.print(" Numéro: ");
            tt.setNumero(sc.nextLine());

            ct.getListTelephones().add(tt);
            System.out.print("Voulez-vous entrer un autre numéro de téléphone (o/u)?\n" +
                    "> ");
            entreeChar = sc.nextLine().toLowerCase().charAt(0);
        }

        map.put(Contact.nbContacts++, ct);
    }

    public static void modifierContact(Map map) {

    }

    public static void afficherContact(Map map) {
        System.out.print("Vous avez " + Contact.nbContacts + " contacts disponibles.\n" +
                "Lequel voulez-vous afficher (sa position)?\n" +
                "> ");
        entree = sc.nextInt();
        if (entree < Contact.nbContacts && entree >= 0) {
            Contact ct = (Contact) map.get(entree - 1);
        }
    }

    public static void afficherRappels(Map map) {

    }
}
