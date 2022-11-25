package automobile;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Classe UsineListeVoiture. Permet la création de voiture à partir d'un fichier JSON.
 */
public class FichierUsineVoiture {
  protected GsonBuilder builder;
  protected Gson json;
  protected VerificationPneu verificationPneu;


  /**
   * Constructeur de la classe FichierUsineVoiture.
   */
  public FichierUsineVoiture() {
    builder = new GsonBuilder();
    json = builder.create();
    verificationPneu = new VerificationPneu();
  }

  /**
   * Méthode qui retourne une liste de voiture à partir d'un fichier JSON. Tous les attributs de
   * chaque instances de Voiture doivent être non null.
   *
   * @param nomFichier le nom du fichier où extraire les données
   * @return une liste de voiture si le fichier est correct, null sinon
   * @throws IOException Si le fichier source n'existe pas
   */
  public ArrayList<Voiture> fichierListeDeVoiture(String nomFichier) throws IOException {
    String extension = "";
    int i = nomFichier.lastIndexOf('.');
    if (i > 0) {
      extension = nomFichier.substring(i + 1);
    }

    if (extension.equals("json")) {
      return this.fichierListeVoitureJson(nomFichier);
    } else {
      return null;
    }
  }

  /**
   * Méthode d'extraction d'une liste de voitures à partir d'un fichier Json.
   *
   * @param nomFichier le nom du fichier contenant les données à extraire
   * @return une liste de voitures ou null si le fichier est vide ou ne contient aucune voiture
   *         correct.
   * @throws IOException Si le fichier source n'existe pas
   */
  private ArrayList<Voiture> fichierListeVoitureJson(String nomFichier) throws IOException {
    // Récupération des instances de Voiture dans un tableau
    String data = new String(Files.readAllBytes(Paths.get(nomFichier)));
    Voiture[] voitures = json.fromJson(data, Voiture[].class);

    // Récupération dans une liste et vérification du numéro de série
    ArrayList<Voiture> listeVoiture = new ArrayList<>();
    ArrayList<Integer> listeNumeroSerie = new ArrayList<>();
    int numeroSerieMax = 0;

    for (Voiture voiture : voitures) {
      if (voiture != null && verificationPneu.verificationTousLesPneus(voiture.getAvg(),
          voiture.getAvd(), voiture.getArg(), voiture.getArd()) == 0) {
        // On vérifie si le numéro de série n'est pas déjà existant
        if (listeNumeroSerie.contains(voiture.getMoteur().getNumeroSerie())) {
          // Sinon, on le modifie en ajoutant 1 au plus grand numéro de série parcouru
          voiture.getMoteur().setNumeroSerie(numeroSerieMax + 1);
        }
        listeVoiture.add(voiture);
        listeNumeroSerie.add(voiture.getMoteur().getNumeroSerie());

        // Mise à jour du plus grand numéro de série si nécessaire
        if (voiture.getMoteur().getNumeroSerie() > numeroSerieMax) {
          numeroSerieMax = voiture.getMoteur().getNumeroSerie();
        }
      }
    }

    return listeVoiture;
  }


  public void writeTo(ArrayList<Voiture> lesVoitures) {
    System.out.println(json.toJson(lesVoitures, ArrayList.class));
  }
}
