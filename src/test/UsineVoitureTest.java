package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import automobile.UsineVoiture;
import automobile.Voiture;
import org.junit.jupiter.api.Test;

/**
 * Test de la classe UsineVoiture.
 */
class UsineVoitureTest {

  @Test
  void test_nouvelleVoitureSansParametre() {
    String marqueUsine = "Renault";
    String modeleUsine = "Clio";
    UsineVoiture usineRenault = new UsineVoiture(marqueUsine, modeleUsine);

    Voiture voitureRenault = usineRenault.nouvelleVoiture();

    assertTrue(voitureRenault.getMarque().equals("Renault"));
    assertTrue(voitureRenault.getModele().equals("Clio"));

    // Test si tous les pneus sont identique
    assertTrue(voitureRenault.getArd().equals(voitureRenault.getArg()));
    assertTrue(voitureRenault.getArd().equals(voitureRenault.getAvd()));
    assertTrue(voitureRenault.getArd().equals(voitureRenault.getAvg()));
  }

  @Test
  void test_nouvelleVoitureAvecParametre() {
    String marqueUsine = "Renault";
    String modeleUsine = "Clio";

    String autreMarque = "Peugeot";
    String autreModele = "208";
    String marquePneu = "Nokian";
    double largeurPneu = 200.;
    double hauteurPneu = 105.;
    boolean pneuHiver = false;

    UsineVoiture usineRenault = new UsineVoiture(marqueUsine, modeleUsine);
    Voiture voiturePeugeot = usineRenault.nouvelleVoiture(autreMarque, autreModele, largeurPneu,
        hauteurPneu, pneuHiver, marquePneu);

    assertTrue(voiturePeugeot.getMarque().equals("Peugeot"));
    assertTrue(voiturePeugeot.getModele().equals("208"));

    // Test si tous les pneus sont identique
    assertTrue(voiturePeugeot.getArd().equals(voiturePeugeot.getArg()));
    assertTrue(voiturePeugeot.getArd().equals(voiturePeugeot.getAvd()));
    assertTrue(voiturePeugeot.getArd().equals(voiturePeugeot.getAvg()));

    // Test que les pneus correspondent bien aux paramètres
    assertTrue(voiturePeugeot.getArd().getHauteur() == hauteurPneu);
    assertTrue(voiturePeugeot.getArd().getLargeur() == largeurPneu);
    assertTrue(voiturePeugeot.getArd().getMarque().equals(marquePneu));
    assertTrue(voiturePeugeot.getArd().isHiver() == pneuHiver);
  }

  @Test
  void test_nouvelleVoitureParametreFaux() {
    String marqueUsine = "Renault";
    String modeleUsine = "Clio";
    String marquePneu = "Nokian";
    double largeurPneu = 200.;
    double hauteurPneu = 105.;
    boolean pneuHiver = false;

    double largeurPneuIncorrect = -2.;
    double hauteurPneuIncorrect = -100.;
    UsineVoiture usineRenault = new UsineVoiture(marqueUsine, modeleUsine);

    assertTrue(usineRenault.nouvelleVoiture(marqueUsine, modeleUsine, largeurPneuIncorrect,
        hauteurPneu, pneuHiver, marquePneu) == null);
    assertTrue(usineRenault.nouvelleVoiture(marqueUsine, modeleUsine, largeurPneu,
        hauteurPneuIncorrect, pneuHiver, marquePneu) == null);
    assertTrue(usineRenault.nouvelleVoiture(null, modeleUsine, largeurPneu, hauteurPneu, pneuHiver,
        marquePneu) == null);
    assertTrue(usineRenault.nouvelleVoiture(marqueUsine, null, largeurPneu, hauteurPneu, pneuHiver,
        marquePneu) == null);
    assertTrue(usineRenault.nouvelleVoiture(marqueUsine, modeleUsine, largeurPneu, hauteurPneu,
        pneuHiver, null) == null);
  }
  
  @Test
  void test_nombreVoiture() {
    String marqueUsine = "Renault";
    String modeleUsine = "Clio";
    UsineVoiture usine = new UsineVoiture(marqueUsine, modeleUsine);

    assertTrue(usine.nombreVoitureCree() == 0);
    
    // Création d'une voiture
    usine.nouvelleVoiture();
    
    assertTrue(usine.nombreVoitureCree() == 1);
    
    // Création de 3 voitures supplémentaires
    usine.nouvelleVoiture();
    usine.nouvelleVoiture();
    usine.nouvelleVoiture();
    
    assertTrue(usine.nombreVoitureCree() == 4);
  }

}
