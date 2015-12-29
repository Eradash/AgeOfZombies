/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package personnes;

import ElementsJeu.Vecteur;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Julien
 */
public class Soldat extends Personne{

    private int porteeDeTir;
    private int puissanceDeTir;
    private int vitesseDeTir;
    private Type type;
    
    private Vecteur mission1 = new Vecteur(750,300);
    private Vecteur mission2 = new Vecteur(400,400);
    private Vecteur mission3 = new Vecteur(250,300);

    public Soldat(Vecteur position) throws SlickException {
        super(position,"soldat", ".png", 1);
        super.setDestination(400, 400);
    }

    public int getPorteeDeTir() {
        return porteeDeTir;
    }

    public int getPuissanceDeTir() {
        return puissanceDeTir;
    }

    public int getVitesseDeTir() {
        return vitesseDeTir;
    }

    public Type getType() {
        return type;
    }
    
    @Override
    public void update(){
        if (position.distance(mission1) < 2){
            super.setDestination(mission2);
        } else if (position.distance(mission2) < 2){
            super.setDestination(mission3);
        } else if (position.distance(mission3) < 2){
            super.setDestination(mission1);
        }
        super.update();
    }
}
