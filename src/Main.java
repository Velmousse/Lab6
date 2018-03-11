import java.util.*;

/**
 * Created by DufVi1731300 on 2018-02-26.
 */

public class Main {
    final static Scanner sc = new Scanner(System.in);
    static int entree = 0;
    static char entreeChar = ' ';

    public static void main(String[] args) {
        Map<Integer, Contact> mapContacts = new HashMap<>();
        Queue<Contact> fileRappels = new LinkedList<>();

        System.out.print("Bienvenue dans la liste de contacts!");
        while (menu(mapContacts, fileRappels)) {}
    }

    public static boolean menu(Map map, Queue file) {
        System.out.print("\n1- Ajouter un contact\n" +
                "2- Modifier un contact\n" +
                "3- Afficher les contacts\n" +
                "4- Liste de rappels\n" +
                "5- Supprimer un contact\n" +
                "6- Quitter\n" +
                "> ");

        switch (sc.nextInt()) {
            case 1: ajouterContact(map, 0, false); return true;
            case 2: modifierContact(map); return true;
            case 3: afficherContact(map, false, null); return true;
            case 4: afficherRappels(file, map); return true;
            case 5: supprimerContact(map); return true;
            case 6: default: System.out.print("\nAu revoir."); return false;
        }
    }

    public static void ajouterContact(Map map, int position, boolean modification) {
        Contact ct = new Contact();
        if (!modification) position = map.size();
        else ct = (Contact) map.get(position);
        System.out.print("\nVeuillez entrer les informations suivantes (laisser vide si correct)\n" +
                "Prénom (" + ct.getPrenom() + "): ");
        sc.nextLine();
        ct.setPrenom(sc.nextLine());
        System.out.print("Nom (" + ct.getNom() + "): ");
        ct.setNom(sc.nextLine());
        System.out.print("Adresse\n" +
                " Numéro civique (" + ct.getAd().getNumeroCivique() + "): ");
        ct.getAd().setNumeroCivique(sc.nextLine());
        System.out.print(" Rue (" + ct.getAd().getRue() + "): ");
        ct.getAd().setRue(sc.nextLine());
        System.out.print(" Appartement (" + ct.getAd().getAppartement() + "): ");
        ct.getAd().setAppartement(sc.nextLine());
        System.out.print(" Ville (" + ct.getAd().getVille() + "): ");
        ct.getAd().setVille(sc.nextLine());
        System.out.print(" Province (" + ct.getAd().getProvince() + "): ");
        ct.getAd().setProvince(sc.nextLine());
        System.out.print(" Pays (" + ct.getAd().getPays() + "): ");
        ct.getAd().setPays(sc.nextLine());
        System.out.print("Occupation\n" +
                " Poste (" + ct.getOcc().getPoste() + "): ");
        ct.getOcc().setPoste(sc.nextLine());
        System.out.print(" Entreprise\n" +
                "  Nom (" + ct.getOcc().getEnt().getNom() + "): ");
        ct.getOcc().getEnt().setNom(sc.nextLine());
        System.out.print("  Adresse\n" +
                "   Numéro civique (" + ct.getOcc().getEnt().getAd().getNumeroCivique() + "): ");
        ct.getOcc().getEnt().getAd().setNumeroCivique(sc.nextLine());
        System.out.print("   Rue (" + ct.getOcc().getEnt().getAd().getRue() + "): ");
        ct.getOcc().getEnt().getAd().setRue(sc.nextLine());
        System.out.print("   Appartement (" + ct.getOcc().getEnt().getAd().getAppartement() + "): ");
        ct.getOcc().getEnt().getAd().setAppartement(sc.nextLine());
        System.out.print("   Ville (" + ct.getOcc().getEnt().getAd().getVille() + "): ");
        ct.getOcc().getEnt().getAd().setVille(sc.nextLine());
        System.out.print("   Province (" + ct.getOcc().getEnt().getAd().getProvince() + "): ");
        ct.getOcc().getEnt().getAd().setProvince(sc.nextLine());
        System.out.print("   Pays (" + ct.getOcc().getEnt().getAd().getPays() + "): ");
        ct.getOcc().getEnt().getAd().setPays(sc.nextLine());
        System.out.print("Voulez-vous entrer un numéro de téléphone (o/n)?\n" +
                "> ");
        entreeChar =sc.nextLine().toLowerCase().charAt(0);

        while (entreeChar == 'o') {
            Telephone tt = new Telephone();
            if (modification && ct.getListTelephones().size() > 0) tt = ct.getListTelephones().get(0);
            System.out.print(" Information (cellulaire, maison, travail) (" + tt.getInfos() + "): ");
            tt.setInfos(sc.nextLine());
            System.out.print(" Numéro (" + tt.getNumero() + "): ");
            tt.setNumero(sc.nextLine());

            ct.getListTelephones().add(tt);
            System.out.print("Voulez-vous entrer un autre numéro de téléphone (o/n)?\n" +
                    "> ");
            entreeChar = sc.nextLine().toLowerCase().charAt(0);
        }

        map.put(position, ct);
    }

    public static void modifierContact(Map map) {
        System.out.print("\nVous avez " + map.size() + " contacts, lequel voulez-vous modifer?\n" +
                "> ");
        entree = sc.nextInt();
        if (entree >= 0 && entree <= map.size()) ajouterContact(map, entree - 1, true);
    }

    public static void afficherContact(Map map, boolean rappel, Contact contactRappel) {
        if (map.size() > 0 && !rappel) {
            System.out.print("\nVous avez " + map.size() + " contacts disponibles.\n" +
                    "Lequel voulez-vous afficher (sa position)?\n" +
                    "> ");
            entree = sc.nextInt();
        }
        Contact ct = new Contact();

        if (entree <= map.size() && entree >= 0) ct = (Contact) map.get(entree - 1);
        else if (rappel) ct = contactRappel;

        if (rappel || map.size() > 0) {
            System.out.println("Prénom: " + ct.getPrenom());
            System.out.println("Nom: " + ct.getNom());
            System.out.println("Adresse\n" +
                    " Numéro civique: " + ct.getAd().getNumeroCivique());
            System.out.println(" Rue: " + ct.getAd().getRue());
            System.out.println(" Appartement: " + ct.getAd().getAppartement());
            System.out.println(" Ville: " + ct.getAd().getVille());
            System.out.println(" Province: " + ct.getAd().getProvince());
            System.out.println(" Pays: " + ct.getAd().getPays());
            System.out.println("Occupation\n" +
                    " Poste: " + ct.getOcc().getPoste());
            System.out.println(" Entreprise\n" +
                    "  Nom: " + ct.getOcc().getEnt().getNom());
            System.out.println("  Adresse\n" +
                    "   Numéro civique: " + ct.getOcc().getEnt().getAd().getNumeroCivique());
            System.out.println("   Rue: " + ct.getOcc().getEnt().getAd().getRue());
            System.out.println("   Appartement: " + ct.getOcc().getEnt().getAd().getAppartement());
            System.out.println("   Ville: " + ct.getOcc().getEnt().getAd().getVille());
            System.out.println("   Province: " + ct.getOcc().getEnt().getAd().getProvince());
            System.out.println("   Pays: " + ct.getOcc().getEnt().getAd().getPays());
            for (Telephone telephone : ct.getListTelephones()) {
                System.out.println("Téléphones:");
                System.out.println(" Information: " + telephone.getInfos());
                System.out.println(" Numéro: " + telephone.getNumero());
            }
        }
    }

    public static void afficherRappels(Queue file, Map map) {
        System.out.print("\n1- Ajouter un contact à la liste\n" +
                "2- Afficher la liste de rappels\n" +
                "3- Quitter\n" +
                "> ");
        entree = sc.nextInt();

        switch (entree) {
            case 1:
                if (map.size() > 0) {
                    System.out.print("\nVous avez " + map.size() + " contacts, lequel voulez-vous ajouter (sa position)?\n" +
                            "> ");
                    entree = sc.nextInt() - 1;
                    if (entree >= 0 && entree < map.size()) {
                        file.add(map.get(entree));
                        System.out.print("Ce contact a été ajouté à la liste avec succès.\n");
                    }
                    else System.out.print("Ce contact n'a pas pu être ajouté à la liste.\n");
                }
                break;
            case 2:
                if (file.size() > 0) {
                    Contact contactTemp = (Contact) file.poll();
                    System.out.println("\nVoici le contact à rappeler, il est maintenant supprimé de la liste:");
                    afficherContact(map, true, contactTemp);
                }
                else System.out.println("Vous n'avez pas de contacts dans la liste de rappels.\n");
                break;
            case 3: default:
        }

    }

    public static void supprimerContact(Map map) {
        System.out.print("\nVous avez " + map.size() + "contacts, lequel contact voulez-vous supprimer (position)?" +
                "> ");
        entree = sc.nextInt() - 1;
        if (entree >= 0 && entree < map.size()) map.remove(entree);
        else System.out.print("Cette entree est invalide.");
    }
}
