package automobile;

/**
 * Classe UsineVoiture. Permet la cr�ation de voiture.
 */
public class UsineVoiture {
  private int numeroSerie = 0;

  // Donn�es de cr�ation de voiture par d�faut
  private String marqueVoiture;
  private String modele;
  private double largeurPneu = 195.0;
  private double hauteurPneu = 100.0;
  private boolean pneuHiver = false;
  private String marquePneu = "Michelin";
  private int nombreVoiture = 0;

  /**
   * Constructeur de la classe UsineVoiture.
   *
   * @param marque la marque de voiture par d�faut
   * @param modele le modele de voiture par d�faut
   */
  public UsineVoiture(String marque, String modele) {
    this.marqueVoiture = marque;
    this.modele = modele;
  }

  public Voiture nouvelleVoiture() {
    return this.nouvelleVoiture(this.getMarqueVoiture(), this.getModele(), this.getLargeurPneu(),
        this.getHauteurPneu(), this.isPneuHiver(), this.getMarquePneu());
  }

  public Voiture nouvelleVoiture(String marque, String modele) {
    return this.nouvelleVoiture(marque, modele, this.getLargeurPneu(), this.getHauteurPneu(),
        this.isPneuHiver(), this.getMarquePneu());
  }

  /**
   * M�thode de construction d'une nouvelle voiture.
   *
   * @param marque la marque de la voiture cree
   * @param modele le modele de la voiture cree
   * @param largeurPneu la largeur des pneus
   * @param hauteurPneu la hauteur des pneus
   * @param pneuHiver si le pneu est un pneu hiver
   * @param marquePneu la marque du pneu
   * @return une nouvelle voiture ou null si les param�tres sont incorrects
   */
  public Voiture nouvelleVoiture(String marque, String modele, double largeurPneu,
      double hauteurPneu, boolean pneuHiver, String marquePneu) {

    if (marque == null || modele == null || largeurPneu < 0. || hauteurPneu < 0.
        || marquePneu == null) {
      return null;
    }
    Moteur moteur = new Moteur(numeroSerie);
    numeroSerie++;

    Pneu avg = new Pneu(largeurPneu, pneuHiver, hauteurPneu, marquePneu);
    Pneu avd = new Pneu(largeurPneu, pneuHiver, hauteurPneu, marquePneu);
    Pneu arg = new Pneu(largeurPneu, pneuHiver, hauteurPneu, marquePneu);
    Pneu ard = new Pneu(largeurPneu, pneuHiver, hauteurPneu, marquePneu);

    Voiture voiture = new Voiture(marque, modele, avg, avd, arg, ard, moteur);
    nombreVoiture++;
    return voiture;
  }

  public int nombreVoitureCree() {
    return nombreVoiture;
  }

  public String getMarqueVoiture() {
    return marqueVoiture;
  }

  public void setMarqueVoiture(String marqueVoiture) {
    this.marqueVoiture = marqueVoiture;
  }

  public String getModele() {
    return modele;
  }

  public void setModele(String modele) {
    this.modele = modele;
  }

  public double getLargeurPneu() {
    return largeurPneu;
  }

  public void setLargeurPneu(double largeurPneu) {
    this.largeurPneu = largeurPneu;
  }

  public double getHauteurPneu() {
    return hauteurPneu;
  }

  public void setHauteurPneu(double hauteurPneu) {
    this.hauteurPneu = hauteurPneu;
  }

  public boolean isPneuHiver() {
    return pneuHiver;
  }

  public void setPneuHiver(boolean pneuHiver) {
    this.pneuHiver = pneuHiver;
  }

  public String getMarquePneu() {
    return marquePneu;
  }

  public void setMarquePneu(String marquePneu) {
    this.marquePneu = marquePneu;
  }
}
