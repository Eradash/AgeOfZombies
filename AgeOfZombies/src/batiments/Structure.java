package batiments;

import ElementsJeu.Entite;
import ElementsJeu.Vecteur;
import ageofzombies.Ressources;
import batiments.etatBatiment.*;
import org.newdawn.slick.SlickException;


public class Structure extends Entite{
    private int vie;
    private int niveau;
    private Ressources ressources;
    protected EtatBatiment alerte;
    
    Structure(Vecteur position,String nom_img, String formatImage) throws SlickException{
        super(position, nom_img, formatImage, 1);
        niveau = 1;
        ressources = null;
    }
    
    public int getVie() {
        return vie;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public Ressources getRessources() {
        return ressources;
    }

    public void setRessources(Ressources ressources) {
        this.ressources = ressources;
    }

    public EtatBatiment getAlerte() {
        return alerte;
    }

    public void setAlerte(EtatBatiment alerte) {
        this.alerte = alerte;
    }

    @Override
    public void update() {
       
    }
}