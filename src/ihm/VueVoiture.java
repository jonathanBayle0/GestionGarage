package ihm;

import automobile.Garage;
import automobile.Observer;
import automobile.Voiture;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * Vue focalis� sur la gestion des caract�ristiques des voitures. Permet d'observer les
 * caract�ristiques d'une voiture � partir d'une liste de voiture et d'en modifier les pneus.
 */
@SuppressWarnings("serial")
public class VueVoiture extends JPanel implements Observer {

  private Garage garage;

  // IHM �l�ments
  private JTextArea listeVoitureArea;
  private JTextField numeroSelectionChamp;
  private JLabel numSerieLabel;
  private JButton selectionBouton;
  private JLabel erreurLabel;
  private JTextArea voitureArea;
  private JTextField largeurPneuChamp;
  private JTextField hauteurPneuChamp;
  private JTextField marquePneuChamp;
  private JCheckBox pneuHiverCheckBox;
  private JButton modifierBouton;
  private JLabel largeurPneuLabel;
  private JLabel hauteurPneuLabel;
  private JLabel marquePneuLabel;


  /**
   * Cr�ation de la vue.
   */
  public VueVoiture(Garage garage) {
    this.garage = garage;

    setBounds(100, 100, 930, 730);
    setBorder(new EmptyBorder(5, 5, 5, 5));
    setLayout(null);

    listeVoitureArea = new JTextArea();
    listeVoitureArea.setLineWrap(true);
    listeVoitureArea.setEditable(false);
    listeVoitureArea.setFont(new Font("SansSerif", Font.PLAIN, 20));
    listeVoitureArea.setBackground(new Color(192, 192, 192));
    listeVoitureArea.setBounds(46, 70, 830, 132);
    this.affichageListeVoiture();
    add(listeVoitureArea);

    numeroSelectionChamp = new JTextField();
    numeroSelectionChamp.setHorizontalAlignment(SwingConstants.CENTER);
    numeroSelectionChamp.setFont(new Font("SansSerif", Font.PLAIN, 20));
    numeroSelectionChamp.setToolTipText("");
    numeroSelectionChamp.setBounds(33, 247, 142, 40);
    add(numeroSelectionChamp);
    numeroSelectionChamp.setColumns(10);

    numSerieLabel = new JLabel("Num�ro de s�rie :");
    numSerieLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
    numSerieLabel.setBounds(33, 215, 155, 23);
    add(numSerieLabel);

    selectionBouton = new JButton("S�lectionner");
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
    selectionBouton.setBounds(369, 247, 165, 40);
    add(selectionBouton);

    erreurLabel = new JLabel("");
    erreurLabel.setForeground(new Color(255, 0, 0));
    erreurLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
    erreurLabel.setBounds(491, 306, 410, 59);
    add(erreurLabel);

    voitureArea = new JTextArea();
    voitureArea.setFont(new Font("SansSerif", Font.PLAIN, 16));
    voitureArea.setLineWrap(true);
    voitureArea.setBackground(new Color(192, 192, 192));
    voitureArea.setBounds(33, 315, 423, 404);
    this.affichageVoiture();
    add(voitureArea);

    largeurPneuChamp = new JTextField();
    largeurPneuChamp.setToolTipText("");
    largeurPneuChamp.setHorizontalAlignment(SwingConstants.CENTER);
    largeurPneuChamp.setFont(new Font("SansSerif", Font.PLAIN, 20));
    largeurPneuChamp.setColumns(10);
    largeurPneuChamp.setBounds(471, 448, 142, 40);
    add(largeurPneuChamp);

    hauteurPneuChamp = new JTextField();
    hauteurPneuChamp.setToolTipText("");
    hauteurPneuChamp.setHorizontalAlignment(SwingConstants.CENTER);
    hauteurPneuChamp.setFont(new Font("SansSerif", Font.PLAIN, 20));
    hauteurPneuChamp.setColumns(10);
    hauteurPneuChamp.setBounds(471, 543, 142, 40);
    add(hauteurPneuChamp);

    marquePneuChamp = new JTextField();
    marquePneuChamp.setToolTipText("");
    marquePneuChamp.setHorizontalAlignment(SwingConstants.CENTER);
    marquePneuChamp.setFont(new Font("SansSerif", Font.PLAIN, 20));
    marquePneuChamp.setColumns(10);
    marquePneuChamp.setBounds(471, 633, 142, 40);
    add(marquePneuChamp);

    pneuHiverCheckBox = new JCheckBox("   Pneu hiver");
    pneuHiverCheckBox.setFont(new Font("SansSerif", Font.PLAIN, 18));
    pneuHiverCheckBox.setBounds(471, 679, 142, 40);
    add(pneuHiverCheckBox);

    modifierBouton = new JButton("Modifier");
    modifierBouton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        modifiePneu();
      }
    });
    modifierBouton.setFont(new Font("SansSerif", Font.PLAIN, 20));
    modifierBouton.setBackground(Color.LIGHT_GRAY);
    modifierBouton.setBounds(685, 543, 165, 40);
    add(modifierBouton);

    largeurPneuLabel = new JLabel("Largeur du pneu :");
    largeurPneuLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
    largeurPneuLabel.setBounds(471, 424, 155, 23);
    add(largeurPneuLabel);

    hauteurPneuLabel = new JLabel("Hauteur du pneu :");
    hauteurPneuLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
    hauteurPneuLabel.setBounds(471, 520, 155, 23);
    add(hauteurPneuLabel);

    marquePneuLabel = new JLabel("Marque du pneu :");
    marquePneuLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
    marquePneuLabel.setBounds(471, 610, 155, 23);
    add(marquePneuLabel);


  }

  /**
   * Permet de s�lectionner une voiture dans la liste des voitures du garage � partir du num�ro de
   * s�rie de son moteur. Et mettre � jour l'affichage de la liste et du d�tail de la voiture.
   *
   * @param numeroSerie num�ro de s�rie du moteur de la voiture choisie
   */
  private void selectionnerVoiture(int numeroSerie) {
    erreurLabel.setText("");
    if (!(garage.setVoitureCourante(numeroSerie))) {
      erreurLabel.setText(
          "Erreur : le num�ro de s�rie entrer est incorrect ! " + "Veuillez en choisir un autre.");
    } else {
      this.affichageListeVoiture();
    }
    this.affichageVoiture();
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

  /**
   * Affiche les caract�ristiques de la voiture courante si elle existe, sinon un message d'erreur
   * est affich�. Pr�-rempli les champs pour la modification des valeurs.
   */
  private void affichageVoiture() {
    Voiture voiture = this.garage.getVoitureCourante();
    if (voiture == null) {
      this.voitureArea.setText("Aucune voiture s�lectionn�e");
    } else {
      String largeur = Double.toString(voiture.getAvd().getLargeur());
      String hauteur = Double.toString(voiture.getAvd().getHauteur());
      this.garage.afficherVoiture(voiture);
      this.largeurPneuChamp.setText(largeur);
      this.hauteurPneuChamp.setText(hauteur);
      this.marquePneuChamp.setText(voiture.getAvd().getMarque());
      this.pneuHiverCheckBox.setSelected(voiture.getAvd().isHiver());
      this.voitureArea.setText(voiture.applique(this.garage.getAffichage()));
    }
  }

  /**
   * Modifie les pneus d'une voiture s�lectionn�e sur l'IHM. Si la modification n'a pas pu �tre
   * faite, un message d'erreur est affich�.
   * 
   */
  private void modifiePneu() {
    erreurLabel.setText("");
    if (this.garage.getVoitureCourante() == null) {
      erreurLabel.setText("Erreur : Aucune voiture selectionn�e.");
    } else {
      Voiture voiture = this.garage.getVoitureCourante();
      double largeur = Double.parseDouble(this.largeurPneuChamp.getText());
      double hauteur = Double.parseDouble(this.hauteurPneuChamp.getText());
      String marque = this.marquePneuChamp.getText();
      boolean hiver = this.pneuHiverCheckBox.isSelected();

      if (!this.garage.modifierPneu(voiture, largeur, hiver, hauteur, marque)) {
        erreurLabel.setText("Erreur : la modification a �chou�e");
      }
    }
  }

  @Override
  public void update() {
    affichageVoiture();
    affichageListeVoiture();
  }
}
