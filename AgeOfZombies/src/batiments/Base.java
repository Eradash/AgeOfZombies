package batiments;

import ElementsJeu.Entite;
import ElementsJeu.Partage;
import ElementsJeu.Vecteur;
import ageofzombies.Ressources;
import java.util.ArrayList;
import org.newdawn.slick.SlickException;
import personnes.Travailleur;

public class Base extends Structure implements Partage {

    private final int creationTravailleur = 100;
    private int vie;
    private ArrayList<Entite> habitants;
    //private batiments;  A voir dependant les batiments
    private Ressources niveauRessources;

    public Base(Vecteur position) throws SlickException {
        super(position, "basement", ".png");
        niveauRessources = new Ressources(500, 100);
    }

    @Override
    public void donnerRessources(Travailleur t) {
        niveauRessources.ajouterRessources(t.getRessources());
        t.getRessources().vider();
    }

    @Override
    public Ressources getRessources() {
        return niveauRessources;
    }

    public boolean creerTravailleur() {
        if (niveauRessources.getBle() > creationTravailleur) {
            return true;
        } else {
            return false;
        }
    }
}