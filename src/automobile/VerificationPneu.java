package automobile;

/**
 * Classe VerificationPneu. Permet la v�rification des pneus d'une voiture.
 */
public class VerificationPneu {

  /**
   * M�thode v�rifiant les pneus avant.
   *
   * @param avg le pneu avant gauche
   * @param avd le pneu avant droit
   * @return 0 si les pneus avant ont la m�me marque, les m�mes dimension et la m�me cat�gorie
   *         d'utilisation, sinon un code erreur est renvoy� : 
   *         -1 : la marque des pneus est diff�rente 
   *         -2 : la largeur des pneus est diff�rente 
   *         -3 : la hauteur des pneus est diff�rente 
   *         -4 : la cat�gorie des pneus est diff�rente
   */
  public int verificationPneuAvant(Pneu avg, Pneu avd) {
    // Test si la marque est la m�me
    if (!(avg.marque.equals(avd.marque))) {
      return -1;
      // Test si la largeur est la m�me et positive
    } else if (avg.largeur != avd.largeur || avd.largeur < 0 || avg.largeur < 0) {
      return -2;
      // Test si la hauteur est la m�me et positive
    } else if (avg.hauteur != avd.hauteur || avd.hauteur < 0 || avg.hauteur < 0) {
      return -3;
      // Test si la cat�gorie des pneus est la m�me
    } else if (avg.hiver != avd.hiver) {
      return -4;
    }

    // Si toutes conditions sont OK :
    return 0;
  }


  /**
   * M�thode v�rifiant les pneus arri�re.
   *
   * @param arg le pneu arri�re gauche
   * @param ard le pneu arri�re droit
   * @return 0 si les pneus avant ont la m�me marque, les m�mes dimension et la m�me cat�gorie
   *         d'utilisation, sinon un code erreur est renvoy� : 
   *         -5 : la marque des pneus est diff�rente 
   *         -6 : la largeur des pneus est diff�rente 
   *         -7 : la hauteur des pneus est diff�rente 
   *         -8 : la cat�gorie des pneus est diff�rente
   */
  public int verificationPneuArriere(Pneu arg, Pneu ard) {
    // Test si la marque est la m�me
    if (!(arg.marque.equals(ard.marque))) {
      return -5;
      // Test si la largeur est la m�me et positive
    } else if (arg.largeur != ard.largeur || ard.largeur < 0 || arg.largeur < 0) {
      return -6;
      // Test si la hauteur est la m�me et positive
    } else if (arg.hauteur != ard.hauteur || ard.hauteur < 0 || arg.hauteur < 0) {
      return -7;
      // Test si la cat�gorie des pneus est la m�me
    } else if (arg.hiver != ard.hiver) {
      return -8;
    }

    // Si toutes conditions sont OK :
    return 0;
  }

  /**
   * M�thode v�rifiant si l'ensemble des pneus sont correct.
   *
   * @param avg le pneu avant gauche
   * @param avd le pneu avant droit
   * @param arg le pneu arri�re gauche
   * @param ard le pneu arri�re droit
   * @return 0 si les pneus de chaque essieu ont la m�me marque, les m�mes dimensions et la m�me
   *         cat�gorie d'utilisation, sinon, un code erreur est renvoy� : 
   *         -1 : la marque des pneus avant est diff�rente 
   *         -2 : la largeur des pneus avant est diff�rente 
   *         -3 : la hauteur des pneus avant est diff�rente 
   *         -4 : la cat�gorie des pneus avant est diff�rente 
   *         -5 : la marque des pneus arri�re est diff�rente 
   *         -6 : la largeur des pneus arri�re est diff�rente 
   *         -7 : la hauteur des pneus arri�re est diff�rente 
   *         -8 : la cat�gorie des pneus arri�re est diff�rente 
   *         -9 : les deux essieus sont erron�s
   */
  public int verificationTousLesPneus(Pneu avg, Pneu avd, Pneu arg, Pneu ard) {
    // Appel aux m�thodes de v�rification des essieus avant et arri�re
    int verificationPneuAvant = this.verificationPneuAvant(avg, avd);
    int verificationPneuArriere = this.verificationPneuArriere(arg, ard);

    // Test si les deux essieus sont correct
    if (verificationPneuAvant == 0 && verificationPneuArriere == 0) {
      return 0;
      // Test si seul l'essieu arri�re est incorrect
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
