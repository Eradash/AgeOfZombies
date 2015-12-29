package personnes;

import ElementsJeu.Vecteur;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Julien
 */
public class Zombie extends Personne {

    private int portee;
    private int xpDonnee;

    public Zombie(Vecteur position) throws SlickException {
        super(position, "monstre" , ".png", 1);
    }

    public int getPortee() {
        return portee;
    }

    public int getXpDonnee() {
        return xpDonnee;
    }
}
