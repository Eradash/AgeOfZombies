package batiments;

import ElementsJeu.Vecteur;
import ageofzombies.Ressources;
import org.newdawn.slick.SlickException;

public class Mine extends Structure{

    private Ressources ressourcesCourantes;
    
    public Mine(Vecteur position) throws SlickException{
        super(position, "mine", ".png");
        ressourcesCourantes = new Ressources();
    }

    public Ressources getRessourcesCourantes() {
        return ressourcesCourantes;
    }


    public void setRessourcesCourantes(Ressources ressourcesCourantes) {
        this.ressourcesCourantes = ressourcesCourantes;
    }
}
