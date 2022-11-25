package automobile;

/**
 * Classe AffichageSimpleAutomobile. Permet un affichage simple des �l�ments d'une voiture.
 */
public class AffichageSimpleAutomobile implements VisiteurAutomobile {

  @Override
  public String visite(Voiture voiture) {
    String affichage = "";
    if (voiture != null) {
      affichage += "[Voiture " + voiture.getMarque() + " " + voiture.getModele()
          + " [Moteur [num�ro de s�rie : " + voiture.getMoteur().getNumeroSerie()
          + "]], [Pneus avant [Hauteur : " + voiture.getAvd().getHauteur() + ", Largeur : "
          + voiture.getAvd().getLargeur() + ", Cat�gorie : "
          + (voiture.getAvd().isHiver() ? "Hiver" : "�t�") + "]], " + "[Pneus avant [Hauteur : "
          + voiture.getArd().getHauteur() + ", Largeur : " + voiture.getArd().getLargeur()
          + ", Cat�gorie : " + (voiture.getArd().isHiver() ? "Hiver" : "�t�") + "]]]";
    }
    return affichage;
  }

  @Override
  public String visite(Pneu pneu) {
    String affichage = "";
    if (pneu != null) {
      affichage += "Le pneu est de la marque " + pneu.getMarque() + ", il a une hauteur de "
          + pneu.getHauteur() + ", une largeur de " + pneu.getLargeur()
          + " et la cat�gorie du pneu est " + (pneu.isHiver() ? "hiver" : "�t�");
    }
    return affichage;
  }

  @Override
  public String visite(Moteur moteur) {
    String affichage = "";
    if (moteur != null) {
      affichage += "Le num�ro de s�rie du moteur est " + moteur.getNumeroSerie();
    }
    return affichage;
  }
}
