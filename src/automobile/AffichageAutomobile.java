package automobile;

/**
 * Classe AffichageAutomobile.
 * Permet l'affichage des �l�ments d'une voiture.
 */
public class AffichageAutomobile implements VisiteurAutomobile {

  @Override
  public String visite(Voiture voiture) {
    String affichage = "";

    if (voiture != null) {
      affichage += "Voiture :\n" + "    Marque : " + voiture.getMarque() + ",\n" + "    Mod�le : "
          + voiture.getModele() + ",\n" + voiture.getMoteur().applique(this)
          + "    Pneu avant gauche :\n" + voiture.getAvg().applique(this)
          + "    Pneu avant droit :\n" + voiture.getAvd().applique(this)
          + "    Pneu arri�re gauche :\n" + voiture.getArg().applique(this)
          + "    Pneu arri�re droit :\n" + voiture.getArd().applique(this);
    }

    return affichage;
  }

  @Override
  public String visite(Pneu pneu) {
    String affichage = "";
    if (pneu != null) {
      affichage += "        Marque : " + pneu.getMarque() + ",\n" + "        Largeur : "
          + pneu.getLargeur() + ",\n" + "        Hauteur : " + pneu.getHauteur() + ",\n"
          + "        La cat�gorie du pneu est " + (pneu.hiver ? "hiver\n" : "�t�\n");
    }

    return affichage;
  }

  @Override
  public String visite(Moteur moteur) {
    String affichage = "";
    if (moteur != null) {
      affichage += "    Num�ro de s�rie du moteur : " + moteur.getNumeroSerie();
    }
    return affichage;
  }

}
