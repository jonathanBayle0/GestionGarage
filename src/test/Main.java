package test;

import automobile.Garage;
import automobile.Pneu;
import automobile.UsineVoiture;
import automobile.Voiture;
import java.io.IOException;

/**
 * Classe Main. Simule une utilisation de l'application.
 */
public class Main {

  /**
   * Méthode main, tests du système.
   *
   * @param args : argument de la méthode main
   */
  public static void main(String[] args) {

    // Création d'une usine Renault clio
    System.out.println("--------------------- Création d'une usine Renault "
        + "(modèle Clio par défaut) ---------------------");

    UsineVoiture usine = new UsineVoiture("Renault", "Clio");
    System.out.println("Nombre de voiture crée : " + usine.nombreVoitureCree());

    // Création d'une nouvelle voiture avec les paramètres par défaut de l'usine
    Voiture voiture1 = usine.nouvelleVoiture();
    System.out
        .println("--------------------- Création d'une nouvelle voiture ---------------------");

    System.out.println("Nombre de voiture crée : " + usine.nombreVoitureCree());

    // Vérification de la marque et du modèle
    if (voiture1.getMarque().equals("Renault") && voiture1.getModele().equals("Clio")) {
      System.out.println("Correct : c'est bien la marque et le modèle par défaut");
    } else {
      System.out.println("Erreur : ce n'est pas la marque et/ou le modèle par défaut");
    }

    // Vérification des pneus
    Pneu avd = voiture1.getAvd();
    Pneu avg = voiture1.getAvg();
    Pneu ard = voiture1.getArd();
    Pneu arg = voiture1.getArg();
    if (avd.getHauteur() == avg.getHauteur() && avd.getLargeur() == avg.getLargeur()
        && avd.isHiver() == avg.isHiver() && avd.getHauteur() == ard.getHauteur()
        && avd.getLargeur() == ard.getLargeur() && avd.isHiver() == ard.isHiver()
        && avd.getHauteur() == arg.getHauteur() && avd.getLargeur() == arg.getLargeur()
        && avd.isHiver() == arg.isHiver()) {
      System.out.println("Les 4 pneus ont les mêmes caractéristiques");
    } else {
      System.out.println("Les 4 pneus n'ont pas les mêmes caractéristiques");
    }

    System.out
        .println("--------------------- Création d'une seconde voiture ---------------------");

    Voiture voiture2 = usine.nouvelleVoiture("Peugeot", "208", 120, 60, false, "Michelin");

    System.out.println("Nombre de voiture crée : " + usine.nombreVoitureCree());

    // Vérification de la marque et du modèle
    if (voiture2.getMarque().equals("Peugeot") && voiture2.getModele().equals("208")) {
      System.out.println("Correct : la marque et le modèle sont correcte");
    } else {
      System.out.println("Erreur : la marque et/ou le modèle sont incorrect");
    }

    // Vérification des pneus
    avd = voiture2.getAvd();
    avg = voiture2.getAvg();
    ard = voiture2.getArd();
    arg = voiture2.getArg();
    if (avd.getHauteur() == avg.getHauteur() && avd.getLargeur() == avg.getLargeur()
        && avd.isHiver() == avg.isHiver() && avd.getHauteur() == ard.getHauteur()
        && avd.getLargeur() == ard.getLargeur() && avd.isHiver() == ard.isHiver()
        && avd.getHauteur() == arg.getHauteur() && avd.getLargeur() == arg.getLargeur()
        && avd.isHiver() == arg.isHiver()) {
      System.out.println("Les 4 pneus ont les mêmes caractéristiques");
    } else {
      System.out.println("Les 4 pneus n'ont pas les mêmes caractéristiques");
    }

    System.out
        .println("--------------------- Création d'une troisième voiture ---------------------");
    System.out.println("On change les paramètres par défaut des pneus de l'usine :\n"
        + "     - La marque par défaut est \"Nokian\"\n"
        + "     - La largeur par défaut est 195.0\n" + "     - La hauteur par défaut est 97.0\n"
        + "     - Les pneus sont en mode hiver");

    // Modification des paramètres par défaut des pneus
    usine.setMarquePneu("Nokian");
    usine.setHauteurPneu(97.0);
    usine.setLargeurPneu(195.0);
    usine.setPneuHiver(true);

    Voiture voiture3 = usine.nouvelleVoiture();

    System.out.println("Nombre de voiture crée : " + usine.nombreVoitureCree());

    // Vérification des pneus
    avd = voiture3.getAvd();
    avg = voiture3.getAvg();
    ard = voiture3.getArd();
    arg = voiture3.getArg();
    if (avd.getHauteur() == avg.getHauteur() && avd.getLargeur() == avg.getLargeur()
        && avd.isHiver() == avg.isHiver() && avd.getHauteur() == ard.getHauteur()
        && avd.getLargeur() == ard.getLargeur() && avd.isHiver() == ard.isHiver()
        && avd.getHauteur() == arg.getHauteur() && avd.getLargeur() == arg.getLargeur()
        && avd.isHiver() == arg.isHiver()) {
      System.out.println("Les 4 pneus ont les mêmes caractéristiques");
    } else {
      System.out.println("Les 4 pneus n'ont pas les mêmes caractéristiques");
    }

    if (avd.getLargeur() == 195.0 && avd.getHauteur() == 97.0 && avd.getMarque().equals("Nokian")
        && avd.isHiver()) {
      System.out.println("Les pneus ont bien les nouvelles caractéristiques par défaut de l'usine");
    } else {
      System.out.println(
          "Erreur : Les pneus n'ont pas les nouvelles " + "caractéristique par défaut de l'usine");
    }

    System.out.println(
        "--------------------- Création d'un garage Renault Clio " + "---------------------");
    Garage garage = new Garage("Renault", "Clio");
    System.out.println("--------------------- Ajout de 3 voitures au garage ---------------------");
    String autreMarque = "Peugeot";
    String autreModele = "208";
    String marquePneu = "Nokian";
    double largeurPneu = 200.;
    double hauteurPneu = 105.;
    boolean pneuHiver = false;

    garage.ajoutVoiture();
    garage.ajoutVoiture();
    garage.ajoutVoiture(autreMarque, autreModele, largeurPneu, hauteurPneu, pneuHiver, marquePneu);

    for (Voiture voiture : garage.getLesVoitures()) {
      System.out.println(garage.afficherSimpleVoiture(voiture));
    }

    System.out.println("--------------------- Vérification des pneus ---------------------");
    Voiture voitureSucces = garage.getVoiture(0);
    Voiture voitureErreur = garage.getVoiture(1);

    // Modification de la hauteur du pneu avant droit
    voitureErreur.getAvd().setHauteur(-20.);

    System.out.print("Voiture sans problème");
    System.out.println(
        garage.verifierPneus(voitureSucces) == 0 ? " : Tous les pneus de la voiture sont correct"
            : " : Erreur, résultat innatendu");

    System.out.print("Voiture avec une hauteur de pneu avant modifié");
    System.out.println(
        garage.verifierPneus(voitureErreur) == -3 ? " : Les pneus avant ont un problème de hauteur."
            : " : Erreur, résultat innatendu");


    System.out.println("--------------------- Insertion de 3 voitures"
        + " via un fichier JSON ---------------------");
    try {
      garage.ajouterListeVoiture("listeDeVoitures.json");
    } catch (IOException e) {
      e.printStackTrace();
    }
    for (Voiture voiture : garage.getLesVoitures()) {
      System.out.println(garage.afficherSimpleVoiture(voiture));
    }

    System.out.println("--------------------- Suppression des voitures avec les numéros"
        + " de série \"2\" et \"4\" ---------------------");
    garage.supprimerVoiture(garage.getVoiture(2));
    garage.supprimerVoiture(garage.getVoiture(4));
    for (Voiture voiture : garage.getLesVoitures()) {
      System.out.println(garage.afficherSimpleVoiture(voiture));
    }
  }
}
