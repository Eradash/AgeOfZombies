/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package batiments;

import ElementsJeu.Vecteur;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Eradash
 */
public class Aeroport extends Batiment{
    
    Aeroport(Vecteur position) throws SlickException{
        super(position, "aeropert", ".png");
    }
}
