package automobile;

/**
 * Classe AffichageSimpleAutomobile. Permet un affichage simple des éléments d'une voiture.
 */
public class AffichageSimpleAutomobile implements VisiteurAutomobile {

  @Override
  public String visite(Voiture voiture) {
    String affichage = "";
    if (voiture != null) {
      affichage += "[Voiture " + voiture.getMarque() + " " + voiture.getModele()
          + " [Moteur [numéro de série : " + voiture.getMoteur().getNumeroSerie()
          + "]], [Pneus avant [Hauteur : " + voiture.getAvd().getHauteur() + ", Largeur : "
          + voiture.getAvd().getLargeur() + ", Catégorie : "
          + (voiture.getAvd().isHiver() ? "Hiver" : "Été") + "]], " + "[Pneus avant [Hauteur : "
          + voiture.getArd().getHauteur() + ", Largeur : " + voiture.getArd().getLargeur()
          + ", Catégorie : " + (voiture.getArd().isHiver() ? "Hiver" : "Été") + "]]]";
    }
    return affichage;
  }

  @Override
  public String visite(Pneu pneu) {
    String affichage = "";
    if (pneu != null) {
      affichage += "Le pneu est de la marque " + pneu.getMarque() + ", il a une hauteur de "
          + pneu.getHauteur() + ", une largeur de " + pneu.getLargeur()
          + " et la catégorie du pneu est " + (pneu.isHiver() ? "hiver" : "été");
    }
    return affichage;
  }

  @Override
  public String visite(Moteur moteur) {
    String affichage = "";
    if (moteur != null) {
      affichage += "Le numéro de série du moteur est " + moteur.getNumeroSerie();
    }
    return affichage;
  }
}
