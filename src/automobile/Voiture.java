package automobile;

/**
 * Classe Voiture.
 *
 */
public class Voiture implements Automobile {

  // Marque de la voiture
  protected String marque;
  // Modele de la voiture
  protected String modele;
  // Pneu avant gauche
  protected Pneu avg;
  // Pneu avant droit
  protected Pneu avd;
  // Pneu arriere gauche
  protected Pneu arg;
  // Pneu arriere droit
  protected Pneu ard;
  protected Moteur moteur;

  /**
   * Constructeur de la classe Voiture.
   *
   * @param marque la marque de la voiture
   * @param modele le modele de la voiture
   * @param avg le pneu avant gauche
   * @param avd le pneu avant droit
   * @param arg le pneu arriere gauche
   * @param ard le pneu arriere droit
   * @param moteur le moteur de la voiture
   */
  public Voiture(String marque, String modele, Pneu avg, Pneu avd, Pneu arg, Pneu ard,
      Moteur moteur) {
    super();
    this.marque = marque;
    this.modele = modele;
    this.avg = avg;
    this.avd = avd;
    this.arg = arg;
    this.ard = ard;
    this.moteur = moteur;
  }

  @Override
  public String toString() {
    return "Voiture [marque=" + marque + ", modele=" + modele + ", pneu avant gauche=" + avg + ", "
        + "pneu avant droit=" + avd + ", pneu arrière gauche=" + arg + ", pneu arrière droit=" + ard
        + ", moteur=" + moteur + "]";
  }

  public String getMarque() {
    return marque;
  }

  public void setMarque(String marque) {
    this.marque = marque;
  }

  public String getModele() {
    return modele;
  }

  public void setModele(String modele) {
    this.modele = modele;
  }

  public Pneu getAvg() {
    return avg;
  }

  public void setAvg(Pneu avg) {
    this.avg = avg;
  }

  public Pneu getAvd() {
    return avd;
  }

  public void setAvd(Pneu avd) {
    this.avd = avd;
  }

  public Pneu getArg() {
    return arg;
  }

  public void setArg(Pneu arg) {
    this.arg = arg;
  }

  public Pneu getArd() {
    return ard;
  }

  public void setArd(Pneu ard) {
    this.ard = ard;
  }

  public Moteur getMoteur() {
    return moteur;
  }

  public void setMoteur(Moteur moteur) {
    this.moteur = moteur;
  }

  @Override
  public String applique(VisiteurAutomobile unVisiteur) {
    return unVisiteur.visite(this);
  }
}
