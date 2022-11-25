package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import automobile.Garage;
import org.junit.jupiter.api.Test;

/**
 * Tests de la classe Garage.
 */
class GarageTest {

  @Test
  void test_ajoutVoiture() {
    Garage garage = new Garage("Renault", "Clio");

    // Ajout d'une voiture sans param�tre
    garage.ajoutVoiture();

    assertTrue(garage.size() == 1);
    assertTrue(garage.verifierPneus(garage.getVoiture(0)) == 0);

    // Ajout d'une voiture avec param�tre
    garage.ajoutVoiture("Peugeot", "208", 120, 60, false, "Michelin");

    assertTrue(garage.size() == 2);
    assertTrue(garage.verifierPneus(garage.getVoiture(1)) == 0);

    // Ajout d'une voiture avec un param�tre null
    garage.ajoutVoiture("Peugeot", "208", 120, 60, false, null);
    assertTrue(garage.size() == 2);
  }

  @Test
  void test_supprimerVoiture() {
    Garage garage = new Garage("Renault", "Clio");

    // Ajout de 3 voitures sans param�tre
    garage.ajoutVoiture();
    garage.ajoutVoiture();
    garage.ajoutVoiture();

    assertTrue(garage.size() == 3);

    // On supprime une voiture existante
    assertTrue(garage.supprimerVoiture(garage.getVoiture(2)));
    assertTrue(garage.size() == 2);

    assertTrue(garage.supprimerVoiture(garage.getVoiture(20)) == false);
    assertTrue(garage.size() == 2);
  }

}
