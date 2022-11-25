package automobile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Classe Garage. Facade de l'application, permet la gestion CRUD de voiture.
 */
public class Garage implements Observable {

  protected ArrayList<Voiture> lesVoitures;
  protected Voiture voitureCourante;
  protected UsineVoiture usine;
  public FichierUsineVoiture fichierUsine;
  protected VerificationPneu verificationPneu;
  protected AffichageAutomobile affichage;
  protected AffichageSimpleAutomobile affichageSimple;

  /**
   * Constructeur de la classe Garage.
   *
   * @param marque la marque par défaut des voitures du garage
   * @param modele le modèle par défaut des voitures du garage
   */
  public Garage(String marque, String modele) {
    lesVoitures = new ArrayList<>();
    voitureCourante = null;
    usine = new UsineVoiture(marque, modele);
    verificationPneu = new VerificationPneu();
    fichierUsine = new FichierUsineVoiture();
    affichage = new AffichageAutomobile();
    affichageSimple = new AffichageSimpleAutomobile();
  }

  /**
   * Méthode d'ajout d'une nouvelle voiture.
   *
   * @return true si la voiture a bien été ajouté, false sinon
   */
  public boolean ajoutVoiture() {
    Voiture v = usine.nouvelleVoiture();

    if (v != null) {
      lesVoitures.add(v);
      if (lesVoitures.size() == 1) {
        voitureCourante = v;
      }
      notifier();
      return true;
    }

    return false;
  }

  /**
   * Méthode d'ajout d'une nouvelle voiture avec une marque et un modèle définit.
   *
   * @param marque la marque de la nouvelle voiture.
   * @param modele le modèle de la nouvelle voiture.
   * @return true si la voiture a bien été ajouté, false sinon.
   */
  public boolean ajoutVoiture(String marque, String modele) {
    Voiture v = usine.nouvelleVoiture(marque, modele);

    if (v != null) {
      lesVoitures.add(v);
      if (lesVoitures.size() == 1) {
        voitureCourante = v;
      }
      notifier();
      return true;
    }

    return false;
  }

  /**
   * Méthode d'ajout d'une voiture.
   *
   * @param marque la marque de la voiture
   * @param modele le modèle de la voiture
   * @param largeurPneu la largeur d'un pneu
   * @param hauteurPneu la hauteur d'un pneu
   * @param pneuHiver si le pneu est d'hiver ou non
   * @param marquePneu la marque d'un pneu
   * @return true si la voiture a bien été ajouté, false sinon
   */
  public boolean ajoutVoiture(String marque, String modele, double largeurPneu, double hauteurPneu,
      boolean pneuHiver, String marquePneu) {

    Voiture v =
        usine.nouvelleVoiture(marque, modele, largeurPneu, hauteurPneu, pneuHiver, marquePneu);

    if (v != null) {
      lesVoitures.add(v);
      notifier();
      return true;
    }

    return false;
  }

  /**
   * Méthode supprimant une voiture si elle existe.
   *
   * @param voiture la voiture à supprimer
   * @return true si l'élément existe et a bien été supprimé, false sinon
   */
  public boolean supprimerVoiture(Voiture voiture) {
    if (!lesVoitures.contains(voiture)) {
      return false;
    }

    lesVoitures.remove(voiture);

    // Modification de la voiture courante si c'est l'élément supprimé
    if (voiture == this.voitureCourante) {
      // La voiture courante devient le premier élément de la liste s'il existe
      if (this.lesVoitures.size() == 0) {
        this.voitureCourante = null;
      } else {
        this.voitureCourante = this.lesVoitures.get(0);
      }
    }
    notifier();
    return true;
  }

  /**
   * Modification des pneus d'une voiture.
   *
   * @param voiture la voiture à modifier
   * @param largeur la nouvelle largeur de pneu
   * @param hiver si le pneu est un pneu hiver ou non
   * @param hauteur la nouvelle hauteur de pneu
   * @param marque la nouvelle marque du pneu
   * @return true si la voiture existe dans la liste et que les pneus sont correct, false sinon
   */
  public boolean modifierPneu(Voiture voiture, double largeur, boolean hiver, double hauteur,
      String marque) {
    if (!this.lesVoitures.contains(voiture)) {
      return false;
    }

    Pneu nouveauPneu = new Pneu(largeur, hiver, hauteur, marque);

    if (this.verificationPneu.verificationPneuAvant(nouveauPneu, nouveauPneu) != 0) {
      return false;
    }

    voiture.setAvg(nouveauPneu);
    voiture.setAvd(nouveauPneu);
    voiture.setArg(nouveauPneu);
    voiture.setArd(nouveauPneu);

    notifier();
    return true;
  }


  /**
   * Méthode de vérification de l'ensemble des pneus d'une voiture.
   *
   * @param voiture la voiture pour laquelle on vérifie les pneus
   * @return 0 si les pneus de chaque essieu ont la même marque, les mêmes dimensions et la même
   *         catégorie d'utilisation, sinon, un code erreur est renvoyé : 
   *         -1 : la marque des pneus avant est différente 
   *         -2 : la largeur des pneus avant est différente 
   *         -3 : la hauteur des pneus avant est différente 
   *         -4 : la catégorie des pneus avant est différente 
   *         -5 : la marque des pneus arrière est différente 
   *         -6 : la largeur des pneus arrière est différente 
   *         -7 : la hauteur des pneus arrière est différente 
   *         -8 : la catégorie des pneus arrière est différente 
   *         -9 : les deux essieus sont erronés
   */
  public int verifierPneus(Voiture voiture) {
    return verificationPneu.verificationTousLesPneus(voiture.avg, voiture.avd, voiture.arg,
        voiture.ard);
  }

  /**
   * Méthode de récuperation d'une voiture à partir de son numéro de série.
   *
   * @param numeroSerie numéro de série du moteur de la voiture à retourner
   * @return une voiture si le numéro de série correspond à une voiture du garage, null sinon.
   */
  public Voiture getVoiture(int numeroSerie) {
    ArrayList<Voiture> voitures = this.getLesVoitures();

    Iterator<Voiture> it = voitures.iterator();

    while (it.hasNext()) {
      Voiture voiture = it.next();
      if (voiture != null) {
        if (voiture.getMoteur().getNumeroSerie() == numeroSerie) {
          return voiture;
        }
      }
    }
    return null;
  }

  /**
   * Méthode ajoutant une liste de voiture à partir d'un fichier.
   *
   * @param nomFichier nom du fichier contenant les voitures à ajouter
   * @return true si au moins une voiture a été ajoutée, false sinon
   * @throws IOException Si le fichier source n'existe pas
   */
  public boolean ajouterListeVoiture(String nomFichier) throws IOException {
    ArrayList<Voiture> listeVoiture = this.fichierUsine.fichierListeDeVoiture(nomFichier);
    ArrayList<Integer> listeNumeroSerie = new ArrayList<>();
    int numeroSerieMax = 0;

    // Récupération du plus grand numéro de série
    for (Voiture voiture : this.lesVoitures) {
      int numSerie = voiture.getMoteur().getNumeroSerie();
      listeNumeroSerie.add(numSerie);
      if (numSerie > numeroSerieMax) {
        numeroSerieMax = numSerie;
      }
    }

    /*
     * modification des numéros de série des moteurs des voitures ajoutées si nécessaire pour éviter
     * les doublons
     */
    for (Voiture voiture : listeVoiture) {
      // On vérifie si le numéro de série n'est pas déjà existant
      if (listeNumeroSerie.contains(voiture.getMoteur().getNumeroSerie())) {
        // Sinon, on le modifie en ajoutant 1 au plus grand numéro de série parcouru
        voiture.getMoteur().setNumeroSerie(numeroSerieMax + 1);
        listeNumeroSerie.add(voiture.getMoteur().getNumeroSerie());
      }
      // Mise à jour du plus grand numéro de série si nécessaire
      if (voiture.getMoteur().getNumeroSerie() > numeroSerieMax) {
        numeroSerieMax = voiture.getMoteur().getNumeroSerie();
      }
    }
    boolean result = this.lesVoitures.addAll(listeVoiture);
    notifier();
    return result;
  }

  /**
   * Renvoie la liste des voitures du garage identifié par le numéro de série unique du moteur.
   *
   * @return une chaine de caractère contenant l'ensemble des voitures du garage.
   */
  public String listeVoiture() {
    String liste = "";
    for (Voiture v : this.lesVoitures) {
      liste +=
          "-->" + (v == this.voitureCourante ? "[voiture " + v.getMoteur().getNumeroSerie() + "]"
              : "voiture " + v.getMoteur().getNumeroSerie());
    }
    return liste;
  }


  /**
   * Met à jour la voiture courante à partir du numéro de série du moteur de la nouvelle voiture
   * courante.
   *
   * @param numeroSerie numéro de série du moteur de la nouvelle voiture courante.
   * @return true si la nouvelle voiture existe dans la liste du garage, false sinon.
   */
  public boolean setVoitureCourante(int numeroSerie) {
    Voiture nouvelleVoitureCourante = this.getVoiture(numeroSerie);
    if (nouvelleVoitureCourante == null) {
      return false;
    }

    this.voitureCourante = nouvelleVoitureCourante;
    notifier();
    return true;
  }


  public AffichageAutomobile getAffichage() {
    return affichage;
  }

  @Override
  public void notifier() {
    for (Observer o : Observable.listeObserver) {
      o.update();
    }
  }

  @Override
  public void ajouterObserver(Observer o) {
    Observable.listeObserver.add(o);
  }

  @Override
  public void supprimerObserver(Observer o) {
    Observable.listeObserver.remove(o);
  }
  
  
  /* --- Getter/Setter ---*/
  public String afficherVoiture(Voiture voiture) {
    return voiture.applique(affichage);
  }

  public String afficherPneu(Pneu pneu) {
    return pneu.applique(affichage);
  }

  public String afficherMoteur(Moteur moteur) {
    return moteur.applique(affichage);
  }

  public String afficherSimpleVoiture(Voiture voiture) {
    return voiture.applique(affichageSimple);
  }

  public String afficherSimplePneu(Pneu pneu) {
    return pneu.applique(affichageSimple);
  }

  public String afficherSimpleMoteur(Moteur moteur) {
    return moteur.applique(affichageSimple);
  }

  public ArrayList<Voiture> getLesVoitures() {
    return lesVoitures;
  }

  public void setLesVoitures(ArrayList<Voiture> lesVoitures) {
    this.lesVoitures = lesVoitures;
  }

  public UsineVoiture getUsine() {
    return usine;
  }

  public int size() {
    return this.lesVoitures.size();
  }

  public FichierUsineVoiture getFichierUsine() {
    return fichierUsine;
  }

  public VerificationPneu getVerificationPneu() {
    return verificationPneu;
  }

  public Voiture getVoitureCourante() {
    return voitureCourante;
  }
}
