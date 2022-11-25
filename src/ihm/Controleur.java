package ihm;

import automobile.Garage;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Controleur de l'application.
 */
@SuppressWarnings("serial")
public class Controleur extends JFrame {

  private final Garage garage;

  private final JFrame fenetre;
  private final CardLayout cl;
  private final JPanel container;
  private final VueListeVoiture vueListe;
  private final VueVoiture vueVoiture;
  private final JButton vueListeBouton;
  private final JButton vueVoitureBouton;


  /**
   * Initialise l'ensemble de l'IHM.
   */
  public Controleur(Garage garage) {
    this.garage = garage;

    // Initialisation des éléments
    fenetre = new JFrame();
    container = new JPanel();
    vueListe = new VueListeVoiture(this.garage);
    vueVoiture = new VueVoiture(this.garage);
    vueListeBouton = new JButton("Détail voiture");
    vueListeBouton.setBounds(27, 26, 165, 40);
    vueVoitureBouton = new JButton("Liste des voitures");
    vueVoitureBouton.setBounds(27, 26, 165, 40);
    // initialisation des observers
    garage.ajouterObserver(vueListe);
    garage.ajouterObserver(vueVoiture);
    
    vueListeBouton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        cl.show(container, "2");
      }

    });
    vueVoitureBouton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        cl.show(container, "1");
      }
    });

    cl = new CardLayout();
    container.setLayout(cl);
    vueListe.add(vueListeBouton);
    vueVoiture.add(vueVoitureBouton);

    container.add(vueListe, "1");
    container.add(vueVoiture, "2");
    cl.show(container, "1");

    fenetre.add(container);
    fenetre.setName("Gestion Garage");
    fenetre.setTitle("Gestion Garage");
    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    fenetre.setResizable(true);
    fenetre.setVisible(true);
    fenetre.setBounds(100, 100, 930, 730);
  }

}
