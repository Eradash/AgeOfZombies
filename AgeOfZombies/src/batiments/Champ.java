package batiments;

import ElementsJeu.Vecteur;
import ageofzombies.Ressources;
import org.newdawn.slick.SlickException;

public class Champ extends Structure{
    private Ressources ressourcesCourantes;
    
    public Champ(Vecteur position) throws SlickException{
        super(position, "champ", ".png");
        ressourcesCourantes = new Ressources(0,0);
    }
    
        public Ressources getRessourcesCourantes() {
        return ressourcesCourantes;
    }


    public void setRessourcesCourantes(Ressources ressourcesCourantes) {
        this.ressourcesCourantes = ressourcesCourantes;
    }
}