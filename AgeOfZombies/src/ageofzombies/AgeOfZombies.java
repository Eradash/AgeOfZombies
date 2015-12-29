package ageofzombies;

import ElementsJeu.Jeu;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
/**
 *
 * @author Julien
 */
public class AgeOfZombies extends StateBasedGame {

    private Jeu jeu;
    private AppGameContainer container;


    public AgeOfZombies() {
        super("Age of zombies");
    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException {
 
        jeu = new Jeu();
        container.setShowFPS(true);
        addState(jeu);
    }

    public static void main(String[] args) {
        try {
            AppGameContainer container = new AppGameContainer(new AgeOfZombies());
            container.setDisplayMode(Jeu.LARGEUR, Jeu.HAUTEUR, false);
            container.setTargetFrameRate(100);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
