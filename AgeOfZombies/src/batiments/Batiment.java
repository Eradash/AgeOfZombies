package batiments;

import ElementsJeu.Entite;
import ElementsJeu.Vecteur;
import ageofzombies.Ressources;
import org.newdawn.slick.SlickException;

public class Batiment extends Entite{
    private Ressources cout;
    private int niveauMinimal;
    private int niveau;

    public Batiment(Vecteur position, String nomImage, String formatImage) throws SlickException{
        super(position, nomImage, formatImage, 1);
    }
    
    public Ressources getCout() {
        return cout;
    }

    public int getNiveauMinimal() {
        return niveauMinimal;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    @Override
    public void update() {
        
    }
}
