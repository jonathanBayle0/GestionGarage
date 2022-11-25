package ihm;

import automobile.Garage;

/**
 * Classe permettant le lancement de l'IHM de Gestion de voiture.
 */
public class Application {

  public static void main(String[] args) {
    Garage garage = new Garage("Renault", "Clio");
    new Controleur(garage);
  }

}
