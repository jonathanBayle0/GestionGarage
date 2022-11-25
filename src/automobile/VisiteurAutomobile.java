package automobile;

/**
 * Interface VisiteurAutomobile.
 */

public interface VisiteurAutomobile {
  String visite(Voiture voiture);
  
  String visite(Pneu pneu);
  
  String visite(Moteur moteur);
 
}
