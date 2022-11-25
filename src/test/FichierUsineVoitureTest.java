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
       * - La premi�re est correct. 
       * - La deuxi�me est correct. 
       * - La trois�me a un num�ro de s�rie identique � la premi�re. 
       * - La quatri�me a la hauteur d'un pneu n�gative. 
       * - La cinqui�me les pneus avant ont une largeur diff�rente.
       */
      ArrayList<Voiture> listeVoiture = usine.fichierListeDeVoiture("listeDeVoitures.json");

      /*
       * Seul 2 voitures sont correct et le num�ro de la troisi�me est modifier pour ne pas avoir de
       * doublon => 3 voitures doivent �tre ajout�s.
       */
      assertTrue(listeVoiture.size() == 3);
      
      // Les num�ros de s�rie de la premi�re et de la trois�me voiture doivent �tre diff�rent
      assertTrue(listeVoiture.get(0).getMoteur().getNumeroSerie() 
                  != listeVoiture.get(2).getMoteur().getNumeroSerie());

    } catch (IOException e) {
      fail("Erreur avec le fichier");
    }
  }

}
