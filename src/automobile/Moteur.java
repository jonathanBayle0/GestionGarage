package automobile;

/**
 * Classe Moteur.
 */
public class Moteur implements Automobile {

  // Num�ro de s�rie du moteur
  protected int numeroSerie;

  public Moteur(int numeroSerie) {
    this.numeroSerie = numeroSerie;
  }

  public int getNumeroSerie() {
    return numeroSerie;
  }

  public void setNumeroSerie(int numeroSerie) {
    this.numeroSerie = numeroSerie;
  }

  @Override
  public String toString() {
    return "Moteur [num�ro de s�rie=" + numeroSerie + "]";
  }

  @Override
  public String applique(VisiteurAutomobile unVisiteur) {
    return unVisiteur.visite(this);
  }

}
