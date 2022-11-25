package automobile;

import java.util.ArrayList;

/**
 * Interface Observable. Objet pouvant être observer.
 */
public interface Observable {
  public ArrayList<Observer> listeObserver = new ArrayList<>();

  public void ajouterObserver(Observer o);

  public void supprimerObserver(Observer o);

  public void notifier();
}
