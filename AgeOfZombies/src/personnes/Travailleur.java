package personnes;

import ElementsJeu.Partage;
import ElementsJeu.Vecteur;
import ageofzombies.Ressources;
import batiments.Champ;
import batiments.InterfaceBase;
import batiments.Mine;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Julien
 */
public class Travailleur extends Personne {

    private Ressources ressources;
    private int vitesseDeTravail;
    //Ça serait selon son état non ? je sais pas s'il n'y aurais pas une manière plus simple de le faie avec les états.... (Eradash)
    private InterfaceBase base;
    private Partage partageBase;
    private InterfaceBase tache;
    //
    private int temps;
    private boolean estParti;

    public Travailleur(Vecteur position, InterfaceBase _tache, InterfaceBase _base) throws SlickException {
        super(position, "peter", ".png", 2);
        tache = _tache;
        base = _base;
        vitesseDeTravail = 5;
        ressources = new Ressources();
        partageBase = (Partage) _base;
        temps = 0;
        estParti = false;
        super.setDestination(tache.getPosition());
    }

    public Ressources getRessources() {
        return ressources;
    }

    @Override
    public void update() {
        
        //Ça va être à mettre dans l'état : En travail (Eradash)
        temps++;
        if (super.getForme().intersects(tache.getForme())) {
            System.out.println("Un ouvrier est arrivé à la mine/champ");
            if (tache instanceof Mine) {
                ressources.setMinerai(10);
            } else if (tache instanceof Champ) {
                ressources.setBle(10);
            }
            super.setDestination(base.getPosition());
            setEnDeplacement(false);
            estParti = true;
        }
        if (super.getForme().intersects(base.getForme())) {
            System.out.println("Un ouvrier est revenu à la base");
            partageBase.donnerRessources(this);
            super.setDestination(tache.getPosition());
            if (estParti) {
                setEnDeplacement(false);
            }
        }
        if (temps > 1000/vitesseDeTravail) {
            setEnDeplacement(true);
            temps = 0;
        }
        super.update();
        //
    }
}