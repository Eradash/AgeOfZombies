package personnes;

import ElementsJeu.Entite;
import ElementsJeu.Jeu;
import ElementsJeu.Vecteur;
import org.newdawn.slick.SlickException;
import personnes.etatPersonne.EtatPersonne;

/**
 *
 * @author Julien
 */
public class Personne extends Entite {

    private int appetit;
    private double vitesseDeDeplacement;
    private EtatPersonne monEtat;
    private int champDeVision;
    private Vecteur depart, destination;
    private boolean enDeplacement;

    public Personne(Vecteur position, String nom_img, String formatImage, int nbImages) throws SlickException {
        super(position, nom_img, formatImage, nbImages);
        depart = new Vecteur(position);
        destination = new Vecteur((int) (Math.random() * Jeu.LARGEUR), (int) (Math.random() * Jeu.HAUTEUR));
        enDeplacement = true;
        vitesseDeDeplacement = 1.3;
    }

    public void setDestination(int px, int py) {
        destination = new Vecteur(px, py);
    }

    public void setDestination(Vecteur position) {
        destination = new Vecteur(position);
    }

    public Vecteur getDestination() {
        return destination;
    }

    public void setEnDeplacement(boolean condition) {
        enDeplacement = condition;
    }

    @Override
    public void update() {
        deplacement();
        super.update();
    }

    //Va falloir demander à Micher s'il va nous fournir une IA comme il l'avait dis au début...
    //Ça serait pratique pour contourner des obstacles, comme le côté de la base (pour que les
    //travailleurs entrent et sortent de la porte de la base... (Eradash)
    public void deplacement() {
        if (enDeplacement == true) {
            if (position.distance(destination) > 0.5) {
                Vecteur direction = position.unitaire(destination);
                direction.multiplication(vitesseDeDeplacement);
                position.addition(direction);
            }
        }
    }
}
