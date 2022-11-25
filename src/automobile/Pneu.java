package automobile;

/**
 * Classe Pneu.
 */
public class Pneu implements Automobile {

  protected double largeur = 0.0;
  protected boolean hiver = false;
  protected double hauteur = 0.0;
  protected String marque;

  public Pneu(String marque) {
    this.marque = marque;
  }

  /**
   * Constructeur de la classe Pneu.
   *
   * @param largeur la largeur du pneu
   * @param hiver vrai si le pneu est un pneu hiver, false sinon
   * @param hauteur la hauteur du pneu
   * @param marque la marque du pneu
   */
  public Pneu(double largeur, boolean hiver, double hauteur, String marque) {
    this(marque);
    this.largeur = largeur;
    this.hiver = hiver;
    this.hauteur = hauteur;
  }


  @Override
  public String toString() {
    return "Pneu [largeur=" + largeur + ", " + (hiver ? "pneu hiver" : "pneu été") + ", "
        + "hauteur=" + hauteur + ", marque=" + marque + "]";
  }

  public double getLargeur() {
    return largeur;
  }

  public void setLargeur(double largeur) {
    this.largeur = largeur;
  }

  public boolean isHiver() {
    return hiver;
  }

  public void setHiver(boolean hiver) {
    this.hiver = hiver;
  }

  public double getHauteur() {
    return hauteur;
  }

  public void setHauteur(double hauteur) {
    this.hauteur = hauteur;
  }

  public String getMarque() {
    return marque;
  }

  public void setMarque(String marque) {
    this.marque = marque;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Pneu other = (Pneu) obj;
    if (Double.doubleToLongBits(hauteur) != Double.doubleToLongBits(other.hauteur)) {
      return false;
    }
    if (hiver != other.hiver) {
      return false;
    }
    if (Double.doubleToLongBits(largeur) != Double.doubleToLongBits(other.largeur)) {
      return false;
    }
    if (marque == null) {
      if (other.marque != null) {
        return false;
      }
    } else if (!marque.equals(other.marque)) {
      return false;
    }
    return true;
  }

  @Override
  public String applique(VisiteurAutomobile unVisiteur) {
    return unVisiteur.visite(this);
  }

}
