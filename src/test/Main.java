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
   * M�thode main, tests du syst�me.
   *
   * @param args : argument de la m�thode main
   */
  public static void main(String[] args) {

    // Cr�ation d'une usine Renault clio
    System.out.println("--------------------- Cr�ation d'une usine Renault "
        + "(mod�le Clio par d�faut) ---------------------");

    UsineVoiture usine = new UsineVoiture("Renault", "Clio");
    System.out.println("Nombre de voiture cr�e : " + usine.nombreVoitureCree());

    // Cr�ation d'une nouvelle voiture avec les param�tres par d�faut de l'usine
    Voiture voiture1 = usine.nouvelleVoiture();
    System.out
        .println("--------------------- Cr�ation d'une nouvelle voiture ---------------------");

    System.out.println("Nombre de voiture cr�e : " + usine.nombreVoitureCree());

    // V�rification de la marque et du mod�le
    if (voiture1.getMarque().equals("Renault") && voiture1.getModele().equals("Clio")) {
      System.out.println("Correct : c'est bien la marque et le mod�le par d�faut");
    } else {
      System.out.println("Erreur : ce n'est pas la marque et/ou le mod�le par d�faut");
    }

    // V�rification des pneus
    Pneu avd = voiture1.getAvd();
    Pneu avg = voiture1.getAvg();
    Pneu ard = voiture1.getArd();
    Pneu arg = voiture1.getArg();
    if (avd.getHauteur() == avg.getHauteur() && avd.getLargeur() == avg.getLargeur()
        && avd.isHiver() == avg.isHiver() && avd.getHauteur() == ard.getHauteur()
        && avd.getLargeur() == ard.getLargeur() && avd.isHiver() == ard.isHiver()
        && avd.getHauteur() == arg.getHauteur() && avd.getLargeur() == arg.getLargeur()
        && avd.isHiver() == arg.isHiver()) {
      System.out.println("Les 4 pneus ont les m�mes caract�ristiques");
    } else {
      System.out.println("Les 4 pneus n'ont pas les m�mes caract�ristiques");
    }

    System.out
        .println("--------------------- Cr�ation d'une seconde voiture ---------------------");

    Voiture voiture2 = usine.nouvelleVoiture("Peugeot", "208", 120, 60, false, "Michelin");

    System.out.println("Nombre de voiture cr�e : " + usine.nombreVoitureCree());

    // V�rification de la marque et du mod�le
    if (voiture2.getMarque().equals("Peugeot") && voiture2.getModele().equals("208")) {
      System.out.println("Correct : la marque et le mod�le sont correcte");
    } else {
      System.out.println("Erreur : la marque et/ou le mod�le sont incorrect");
    }

    // V�rification des pneus
    avd = voiture2.getAvd();
    avg = voiture2.getAvg();
    ard = voiture2.getArd();
    arg = voiture2.getArg();
    if (avd.getHauteur() == avg.getHauteur() && avd.getLargeur() == avg.getLargeur()
        && avd.isHiver() == avg.isHiver() && avd.getHauteur() == ard.getHauteur()
        && avd.getLargeur() == ard.getLargeur() && avd.isHiver() == ard.isHiver()
        && avd.getHauteur() == arg.getHauteur() && avd.getLargeur() == arg.getLargeur()
        && avd.isHiver() == arg.isHiver()) {
      System.out.println("Les 4 pneus ont les m�mes caract�ristiques");
    } else {
      System.out.println("Les 4 pneus n'ont pas les m�mes caract�ristiques");
    }

    System.out
        .println("--------------------- Cr�ation d'une troisi�me voiture ---------------------");
    System.out.println("On change les param�tres par d�faut des pneus de l'usine :\n"
        + "     - La marque par d�faut est \"Nokian\"\n"
        + "     - La largeur par d�faut est 195.0\n" + "     - La hauteur par d�faut est 97.0\n"
        + "     - Les pneus sont en mode hiver");

    // Modification des param�tres par d�faut des pneus
    usine.setMarquePneu("Nokian");
    usine.setHauteurPneu(97.0);
    usine.setLargeurPneu(195.0);
    usine.setPneuHiver(true);

    Voiture voiture3 = usine.nouvelleVoiture();

    System.out.println("Nombre de voiture cr�e : " + usine.nombreVoitureCree());

    // V�rification des pneus
    avd = voiture3.getAvd();
    avg = voiture3.getAvg();
    ard = voiture3.getArd();
    arg = voiture3.getArg();
    if (avd.getHauteur() == avg.getHauteur() && avd.getLargeur() == avg.getLargeur()
        && avd.isHiver() == avg.isHiver() && avd.getHauteur() == ard.getHauteur()
        && avd.getLargeur() == ard.getLargeur() && avd.isHiver() == ard.isHiver()
        && avd.getHauteur() == arg.getHauteur() && avd.getLargeur() == arg.getLargeur()
        && avd.isHiver() == arg.isHiver()) {
      System.out.println("Les 4 pneus ont les m�mes caract�ristiques");
    } else {
      System.out.println("Les 4 pneus n'ont pas les m�mes caract�ristiques");
    }

    if (avd.getLargeur() == 195.0 && avd.getHauteur() == 97.0 && avd.getMarque().equals("Nokian")
        && avd.isHiver()) {
      System.out.println("Les pneus ont bien les nouvelles caract�ristiques par d�faut de l'usine");
    } else {
      System.out.println(
          "Erreur : Les pneus n'ont pas les nouvelles " + "caract�ristique par d�faut de l'usine");
    }

    System.out.println(
        "--------------------- Cr�ation d'un garage Renault Clio " + "---------------------");
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

    System.out.println("--------------------- V�rification des pneus ---------------------");
    Voiture voitureSucces = garage.getVoiture(0);
    Voiture voitureErreur = garage.getVoiture(1);

    // Modification de la hauteur du pneu avant droit
    voitureErreur.getAvd().setHauteur(-20.);

    System.out.print("Voiture sans probl�me");
    System.out.println(
        garage.verifierPneus(voitureSucces) == 0 ? " : Tous les pneus de la voiture sont correct"
            : " : Erreur, r�sultat innatendu");

    System.out.print("Voiture avec une hauteur de pneu avant modifi�");
    System.out.println(
        garage.verifierPneus(voitureErreur) == -3 ? " : Les pneus avant ont un probl�me de hauteur."
            : " : Erreur, r�sultat innatendu");


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

    System.out.println("--------------------- Suppression des voitures avec les num�ros"
        + " de s�rie \"2\" et \"4\" ---------------------");
    garage.supprimerVoiture(garage.getVoiture(2));
    garage.supprimerVoiture(garage.getVoiture(4));
    for (Voiture voiture : garage.getLesVoitures()) {
      System.out.println(garage.afficherSimpleVoiture(voiture));
    }
  }
}
