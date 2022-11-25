package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import automobile.UsineVoiture;
import automobile.VerificationPneu;
import automobile.Voiture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test de la classe VerificationPneu.
 */
class VerificationPneuTest {

  // Définition des paramètres généraux
  private UsineVoiture usine;
  private Voiture voitureCorrect;
  private Voiture voitureIncorrect;
  private VerificationPneu verificationPneu;
  private String marque;
  private String modele;
  private String marquePneu;
  private double largeurPneu;
  private double hauteurPneu;
  private boolean pneuHiver;


  @BeforeEach
  void setUp() throws Exception {
    // Initialisation des paramètres généraux.
    this.marque = "Peugeot";
    this.modele = "208";
    this.marquePneu = "Nokian";
    this.largeurPneu = 200.;
    this.hauteurPneu = 105.;
    this.pneuHiver = false;

    this.usine = new UsineVoiture(marque, modele);

    // Création d'une voiture avec des pneus identique
    this.voitureCorrect =
        this.usine.nouvelleVoiture(marque, modele, largeurPneu, hauteurPneu, pneuHiver, marquePneu);

    this.voitureIncorrect =
        this.usine.nouvelleVoiture(marque, modele, largeurPneu, hauteurPneu, pneuHiver, marquePneu);

    this.verificationPneu = new VerificationPneu();
  }

  @Test
  void test_verificationPneuAvantCorrect() {
    // Test si les pneus avant sont correct
    assertTrue(this.verificationPneu.verificationPneuAvant(this.voitureCorrect.getAvg(),
        this.voitureCorrect.getAvd()) == 0);

  }

  @Test
  void test_verificationPneuArriereCorrect() {
    // Test si les pneus arrière sont correct
    assertTrue(this.verificationPneu.verificationPneuAvant(this.voitureCorrect.getArg(),
        this.voitureCorrect.getArd()) == 0);
  }

  @Test
  void test_verificationPneuAvantIncorrect() {
    // Changement de la marque d'un pneu
    String marqueDifferente = "Renault";
    this.voitureIncorrect.getAvd().setMarque(marqueDifferente);

    assertTrue(this.verificationPneu.verificationPneuAvant(this.voitureIncorrect.getAvg(),
        this.voitureIncorrect.getAvd()) == -1);

    this.voitureIncorrect.getAvd().setMarque(this.marquePneu);

    // Changement de la largeur d'un pneu
    double largeurDifferente = 205.;
    this.voitureIncorrect.getAvg().setLargeur(largeurDifferente);

    assertTrue(this.verificationPneu.verificationPneuAvant(this.voitureIncorrect.getAvg(),
        this.voitureIncorrect.getAvd()) == -2);

    this.voitureIncorrect.getAvg().setLargeur(this.largeurPneu);

    // Changement de la hauteur d'un pneu
    double hauteurDifferente = 110.;
    this.voitureIncorrect.getAvd().setHauteur(hauteurDifferente);

    assertTrue(this.verificationPneu.verificationPneuAvant(this.voitureIncorrect.getAvg(),
        this.voitureIncorrect.getAvd()) == -3);

    this.voitureIncorrect.getAvd().setHauteur(this.hauteurPneu);

    // Changement de la catégorie d'un pneu
    boolean pneuHiverDifferent = true;
    this.voitureIncorrect.getAvg().setHiver(pneuHiverDifferent);

    assertTrue(this.verificationPneu.verificationPneuAvant(this.voitureIncorrect.getAvg(),
        this.voitureIncorrect.getAvd()) == -4);

    this.voitureIncorrect.getAvg().setHiver(this.pneuHiver);
  }

  @Test
  void test_verificationPneuArriereIncorrect() {
    // Changement de la marque d'un pneu
    String marqueDifferente = "Renault";
    this.voitureIncorrect.getArd().setMarque(marqueDifferente);

    assertTrue(this.verificationPneu.verificationPneuArriere(this.voitureIncorrect.getArg(),
        this.voitureIncorrect.getArd()) == -5);

    this.voitureIncorrect.getArd().setMarque(this.marquePneu);

    // Changement de la largeur d'un pneu
    double largeurDifferente = 205.;
    this.voitureIncorrect.getArg().setLargeur(largeurDifferente);

    assertTrue(this.verificationPneu.verificationPneuArriere(this.voitureIncorrect.getArg(),
        this.voitureIncorrect.getArd()) == -6);

    this.voitureIncorrect.getArg().setLargeur(this.largeurPneu);

    // Changement de la hauteur d'un pneu
    double hauteurDifferente = 110.;
    this.voitureIncorrect.getArd().setHauteur(hauteurDifferente);

    assertTrue(this.verificationPneu.verificationPneuArriere(this.voitureIncorrect.getArg(),
        this.voitureIncorrect.getArd()) == -7);

    this.voitureIncorrect.getArd().setHauteur(this.hauteurPneu);

    // Changement de la catégorie d'un pneu
    boolean pneuHiverDifferent = true;
    this.voitureIncorrect.getArg().setHiver(pneuHiverDifferent);

    assertTrue(this.verificationPneu.verificationPneuArriere(this.voitureIncorrect.getArg(),
        this.voitureIncorrect.getArd()) == -8);

    this.voitureIncorrect.getArg().setHiver(this.pneuHiver);
  }

  @Test
  void test_verificationTousLesPneusCorrect() {
    // Test si l'ensemble des pneus sont correct
    assertTrue(this.verificationPneu.verificationTousLesPneus(this.voitureCorrect.getAvg(),
        this.voitureCorrect.getAvd(), this.voitureCorrect.getArg(),
        this.voitureCorrect.getArd()) == 0);
  }

  @Test
  void test_verificationTousLesPneusIncorrect() {
    // Changement de la largeur d'un pneu avant
    double largeurDifferente = 205.;
    this.voitureIncorrect.getAvg().setLargeur(largeurDifferente);

    // Erreur de largeur sur l'essieu avant
    assertTrue(this.verificationPneu.verificationTousLesPneus(this.voitureIncorrect.getAvg(),
        this.voitureIncorrect.getAvd(), this.voitureIncorrect.getArg(),
        this.voitureIncorrect.getArd()) == -2);

    // Changement de la hauteur d'un pneu arrière
    double hauteurDifferente = 110.;
    this.voitureIncorrect.getArd().setHauteur(hauteurDifferente);
    // Erreur sur les deux essieus
    assertTrue(this.verificationPneu.verificationTousLesPneus(this.voitureIncorrect.getAvg(),
        this.voitureIncorrect.getAvd(), this.voitureIncorrect.getArg(),
        this.voitureIncorrect.getArd()) == -9);

    // On remet la même largeur pour les pneus de l'essieu avant
    this.voitureIncorrect.getAvg().setLargeur(this.largeurPneu);

    // Erreur de largeur sur l'essieu arrière
    assertTrue(this.verificationPneu.verificationTousLesPneus(this.voitureIncorrect.getAvg(),
        this.voitureIncorrect.getAvd(), this.voitureIncorrect.getArg(),
        this.voitureIncorrect.getArd()) == -7);
  }

}
