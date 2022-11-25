package ihm;

import automobile.Garage;
import automobile.Observer;
import automobile.Voiture;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


/**
 * Vue de la liste des voitures d'un garage. Permet d'observer une liste de voiture. D'ajouter ou
 * supprimer les voitures de la liste.
 */
@SuppressWarnings("serial")
public class VueListeVoiture extends JPanel implements Observer {

  private Garage garage;

  // IHM éléments
  private JTextArea listeVoitureArea;
  private JTextField numeroSelectionChamp;
  private JLabel numSerieLabel;
  private JButton selectionBouton;
  private JTextField marqueChamp;
  private JTextField modeleChamp;
  private JLabel marqueLabel;
  private JLabel modeleLabel;
  private JButton ajoutBouton;
  private JLabel erreurLabel;

  /**
   * Création de la vue.
   */
  public VueListeVoiture(Garage garage) {
    this.garage = garage;

    setBounds(100, 100, 930, 730);

    setBorder(new EmptyBorder(5, 5, 5, 5));
    setLayout(null);


    numeroSelectionChamp = new JTextField();
    numeroSelectionChamp.setHorizontalAlignment(SwingConstants.CENTER);
    numeroSelectionChamp.setFont(new Font("SansSerif", Font.PLAIN, 20));
    numeroSelectionChamp.setToolTipText("");
    numeroSelectionChamp.setBounds(42, 287, 142, 40);
    add(numeroSelectionChamp);
    numeroSelectionChamp.setColumns(10);

    numSerieLabel = new JLabel("Numéro de série :");
    numSerieLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
    numSerieLabel.setBounds(42, 254, 155, 23);
    add(numSerieLabel);

    selectionBouton = new JButton("Sélectionner");
    selectionBouton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int numero;
        try {
          numero = Integer.parseInt(numeroSelectionChamp.getText());
        } catch (NumberFormatException ex) {
          numero = -1;
        }
        selectionnerVoiture(numero);
      }
    });
    selectionBouton.setBackground(new Color(192, 192, 192));
    selectionBouton.setFont(new Font("SansSerif", Font.PLAIN, 20));
    selectionBouton.setBounds(373, 287, 165, 40);
    add(selectionBouton);

    JButton supprimerBouton = new JButton("Supprimer");
    supprimerBouton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        supprimerVoiture();
      }
    });
    supprimerBouton.setFont(new Font("SansSerif", Font.PLAIN, 20));
    supprimerBouton.setBackground(Color.LIGHT_GRAY);
    supprimerBouton.setBounds(596, 287, 165, 40);
    add(supprimerBouton);

    marqueChamp = new JTextField();
    marqueChamp.setToolTipText("");
    marqueChamp.setHorizontalAlignment(SwingConstants.CENTER);
    marqueChamp.setFont(new Font("SansSerif", Font.PLAIN, 20));
    marqueChamp.setColumns(10);
    marqueChamp.setBounds(42, 523, 142, 40);
    add(marqueChamp);

    modeleChamp = new JTextField();
    modeleChamp.setToolTipText("");
    modeleChamp.setHorizontalAlignment(SwingConstants.CENTER);
    modeleChamp.setFont(new Font("SansSerif", Font.PLAIN, 20));
    modeleChamp.setColumns(10);
    modeleChamp.setBounds(262, 523, 142, 40);
    add(modeleChamp);

    marqueLabel = new JLabel("Marque :");
    marqueLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
    marqueLabel.setBounds(42, 497, 74, 23);
    add(marqueLabel);

    modeleLabel = new JLabel("Modèle :");
    modeleLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
    modeleLabel.setBounds(262, 497, 74, 23);
    add(modeleLabel);

    ajoutBouton = new JButton("Ajouter");
    ajoutBouton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        ajoutVoiture();
      }
    });
    ajoutBouton.setFont(new Font("SansSerif", Font.PLAIN, 20));
    ajoutBouton.setBackground(Color.LIGHT_GRAY);
    ajoutBouton.setBounds(516, 523, 165, 40);
    add(ajoutBouton);

    erreurLabel = new JLabel("");
    erreurLabel.setForeground(new Color(255, 0, 0));
    erreurLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
    erreurLabel.setBounds(42, 387, 612, 59);
    add(erreurLabel);

    listeVoitureArea = new JTextArea();
    listeVoitureArea.setLineWrap(true);
    listeVoitureArea.setEditable(false);
    listeVoitureArea.setFont(new Font("SansSerif", Font.PLAIN, 20));
    listeVoitureArea.setBackground(new Color(192, 192, 192));
    listeVoitureArea.setBounds(27, 85, 842, 132);
    this.affichageListeVoiture();
    add(listeVoitureArea);
  }

  /**
   * Permet de sélectionner une voiture dans la liste des voitures du garage à partir du numéro de
   * série de son moteur. Et mettre à jour l'affichage de la liste.
   *
   * @param numeroSerie numéro de série du moteur de la voiture choisie
   */
  private void selectionnerVoiture(int numeroSerie) {
    erreurLabel.setText("");
    if (!(garage.setVoitureCourante(numeroSerie))) {
      erreurLabel.setText(
          "Erreur : le numéro de série entrer est incorrect ! " + "Veuillez en choisir un autre.");
    } else {
      this.affichageListeVoiture();
    }
  }

  /**
   * Suppression de la voiture courante. Si il n'y a aucune voiture ou que la suppression s'est mal
   * passée : un message d'erreur est affiché.
   */
  private void supprimerVoiture() {
    erreurLabel.setText("");

    Voiture voitureSupp = this.garage.getVoitureCourante();

    if (voitureSupp == null) {
      erreurLabel.setText("Erreur : Aucune voiture à supprimer");
    } else {
      if (!(this.garage.supprimerVoiture(voitureSupp))) {
        erreurLabel.setText("Erreur : la voiture n'a pas pu être supprimée");
      }
      this.affichageListeVoiture();
    }
  }

  /**
   * Ajoute une nouvelle voiture à partir d'une marque et d'un modèle.
   */
  private void ajoutVoiture() {
    erreurLabel.setText("");

    if (marqueChamp.getText().equals("") || modeleChamp.getText().equals("")) {
      erreurLabel
          .setText("Erreur : La marque et le modèle de la voiture " + "doivent être renseignés !");
    } else {
      if (!(this.garage.ajoutVoiture(marqueChamp.getText(), modeleChamp.getText()))) {
        erreurLabel.setText("Erreur : la voiture n'a pas pu être ajoutée");
      } else {
        this.affichageListeVoiture();
      }
    }
  }

  /**
   * Affiche la liste des voitures du garage ou un message d'erreur si le garage est vide.
   */
  private void affichageListeVoiture() {
    String liste = this.garage.listeVoiture();
    if (liste.equals("")) {
      listeVoitureArea.setText("Le garage est vide");
    } else {
      listeVoitureArea.setText(liste);
    }
  }

  @Override
  public void update() {
    affichageListeVoiture();
  }
}
