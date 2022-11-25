package test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import automobile.FichierUsineVoiture;
import automobile.Voiture;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class FichierUsineVoitureTest {

  @Test
  void test_ajoutViaUnFichier() {
    FichierUsineVoiture usine = new FichierUsineVoiture();

    try {
      /*
       * Test avec un fichier contenant 5 instances de Voiture : 
       * - La première est correct. 
       * - La deuxième est correct. 
       * - La troisème a un numéro de série identique à la première. 
       * - La quatrième a la hauteur d'un pneu négative. 
       * - La cinquième les pneus avant ont une largeur différente.
       */
      ArrayList<Voiture> listeVoiture = usine.fichierListeDeVoiture("listeDeVoitures.json");

      /*
       * Seul 2 voitures sont correct et le numéro de la troisième est modifier pour ne pas avoir de
       * doublon => 3 voitures doivent être ajoutés.
       */
      assertTrue(listeVoiture.size() == 3);
      
      // Les numéros de série de la première et de la troisème voiture doivent être différent
      assertTrue(listeVoiture.get(0).getMoteur().getNumeroSerie() 
                  != listeVoiture.get(2).getMoteur().getNumeroSerie());

    } catch (IOException e) {
      fail("Erreur avec le fichier");
    }
  }

}
