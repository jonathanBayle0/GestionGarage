package automobile;

/**
 * Classe VerificationPneu. Permet la vérification des pneus d'une voiture.
 */
public class VerificationPneu {

  /**
   * Méthode vérifiant les pneus avant.
   *
   * @param avg le pneu avant gauche
   * @param avd le pneu avant droit
   * @return 0 si les pneus avant ont la même marque, les mêmes dimension et la même catégorie
   *         d'utilisation, sinon un code erreur est renvoyé : 
   *         -1 : la marque des pneus est différente 
   *         -2 : la largeur des pneus est différente 
   *         -3 : la hauteur des pneus est différente 
   *         -4 : la catégorie des pneus est différente
   */
  public int verificationPneuAvant(Pneu avg, Pneu avd) {
    // Test si la marque est la même
    if (!(avg.marque.equals(avd.marque))) {
      return -1;
      // Test si la largeur est la même et positive
    } else if (avg.largeur != avd.largeur || avd.largeur < 0 || avg.largeur < 0) {
      return -2;
      // Test si la hauteur est la même et positive
    } else if (avg.hauteur != avd.hauteur || avd.hauteur < 0 || avg.hauteur < 0) {
      return -3;
      // Test si la catégorie des pneus est la même
    } else if (avg.hiver != avd.hiver) {
      return -4;
    }

    // Si toutes conditions sont OK :
    return 0;
  }


  /**
   * Méthode vérifiant les pneus arrière.
   *
   * @param arg le pneu arrière gauche
   * @param ard le pneu arrière droit
   * @return 0 si les pneus avant ont la même marque, les mêmes dimension et la même catégorie
   *         d'utilisation, sinon un code erreur est renvoyé : 
   *         -5 : la marque des pneus est différente 
   *         -6 : la largeur des pneus est différente 
   *         -7 : la hauteur des pneus est différente 
   *         -8 : la catégorie des pneus est différente
   */
  public int verificationPneuArriere(Pneu arg, Pneu ard) {
    // Test si la marque est la même
    if (!(arg.marque.equals(ard.marque))) {
      return -5;
      // Test si la largeur est la même et positive
    } else if (arg.largeur != ard.largeur || ard.largeur < 0 || arg.largeur < 0) {
      return -6;
      // Test si la hauteur est la même et positive
    } else if (arg.hauteur != ard.hauteur || ard.hauteur < 0 || arg.hauteur < 0) {
      return -7;
      // Test si la catégorie des pneus est la même
    } else if (arg.hiver != ard.hiver) {
      return -8;
    }

    // Si toutes conditions sont OK :
    return 0;
  }

  /**
   * Méthode vérifiant si l'ensemble des pneus sont correct.
   *
   * @param avg le pneu avant gauche
   * @param avd le pneu avant droit
   * @param arg le pneu arrière gauche
   * @param ard le pneu arrière droit
   * @return 0 si les pneus de chaque essieu ont la même marque, les mêmes dimensions et la même
   *         catégorie d'utilisation, sinon, un code erreur est renvoyé : 
   *         -1 : la marque des pneus avant est différente 
   *         -2 : la largeur des pneus avant est différente 
   *         -3 : la hauteur des pneus avant est différente 
   *         -4 : la catégorie des pneus avant est différente 
   *         -5 : la marque des pneus arrière est différente 
   *         -6 : la largeur des pneus arrière est différente 
   *         -7 : la hauteur des pneus arrière est différente 
   *         -8 : la catégorie des pneus arrière est différente 
   *         -9 : les deux essieus sont erronés
   */
  public int verificationTousLesPneus(Pneu avg, Pneu avd, Pneu arg, Pneu ard) {
    // Appel aux méthodes de vérification des essieus avant et arrière
    int verificationPneuAvant = this.verificationPneuAvant(avg, avd);
    int verificationPneuArriere = this.verificationPneuArriere(arg, ard);

    // Test si les deux essieus sont correct
    if (verificationPneuAvant == 0 && verificationPneuArriere == 0) {
      return 0;
      // Test si seul l'essieu arrière est incorrect
    } else if (verificationPneuAvant == 0 && verificationPneuArriere != 0) {
      return verificationPneuArriere;
      // Test si seul l'essieu avant est incorrect
    } else if (verificationPneuAvant != 0 && verificationPneuArriere == 0) {
      return verificationPneuAvant;
      // Sinon les deux essieus sont incorrect
    } else {
      return -9;
    }
  }

}
