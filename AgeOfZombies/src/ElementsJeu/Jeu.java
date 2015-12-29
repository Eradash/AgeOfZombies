package ElementsJeu;

import batiments.Base;
import batiments.Champ;
import batiments.Mine;
import batiments.Structure;
import java.util.ArrayList;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import personnes.*;

/**
 *
 * @author Julien
 */
public class Jeu extends BasicGameState {
    public final static int LARGEUR = 1000;
    public final static int HAUTEUR = 600;
    private ArrayList<Personne> listeVivant;
    private Structure base;
    private Structure champ;
    private Structure mine;
    private Input input;

    @Override
    public int getID() {
        return 1;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        listeVivant = new ArrayList<>();
        base = new Base(new Vecteur(50,50));
        champ = new Champ(new Vecteur(600,50));
        mine = new Mine(new Vecteur(200,400));
        input = gc.getInput();
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        grphcs.drawImage(new Image("Images/fond.jpg"), 0, 0);
        for (int x = 0; x < listeVivant.size(); x++) {
            listeVivant.get(x).render(grphcs);
        }
        
        base.render(grphcs);
        champ.render(grphcs);
        mine.render(grphcs);
        
        //J'ai mis des noms de travailleurs, mais ça pourrais juste être une différence dans les états... (Eradash)
        grphcs.drawString(""
                + "1 - Créer un mineur (100 Blés) "
                + "\n2 - Créer un fermier (100 Blés)"
                + "\n3 - Créer soldat"
                + "\n4 - Créer zombie", 
                10, 520);
        grphcs.drawString("Blé: "+base.getRessources().getBle()+" Minerai: "+base.getRessources().getMinerai(),(gc.getWidth()/2)-50,20);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {

        //Va falloir mettre les coûts de construction dans les classes directement ou de quoi du genre, parce que
        //dès qu'on va se faire une interface plus complète, ça va être un vrai chiale de tout gèrer ça ici... (Eradash)
        if (input.isKeyPressed(Input.KEY_1)) {
            if(base.getRessources().getBle() >= 100){
                listeVivant.add(new Travailleur(base.getPosition(), mine, base));
                base.getRessources().setBle(base.getRessources().getBle()-100);
            }
        } else if (input.isKeyPressed(Input.KEY_2)) {
            if(base.getRessources().getBle() >= 100){
                listeVivant.add(new Travailleur(base.getPosition(), champ, base));
                base.getRessources().setBle(base.getRessources().getBle()-100);
            }
        } else if (input.isKeyPressed(Input.KEY_3)) {
            if(base.getRessources().getBle() >= 100 && base.getRessources().getMinerai() >= 20){
                listeVivant.add(new Soldat(base.getPosition()));
                base.getRessources().setMinerai(base.getRessources().getMinerai()-20);
                base.getRessources().setBle(base.getRessources().getBle()-100);
            }
        } else if (input.isKeyPressed(Input.KEY_4)) {
            listeVivant.add(new Zombie(new Vecteur((int)(Math.random() * Jeu.LARGEUR), (int) (Math.random() * Jeu.HAUTEUR))));
        }
        if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)){///// À ENLEVER, C'ÉTAIT SEULEMENT POUR TE MONTRER LE CHANGEMENT DE CURSEUR
            gc.setMouseCursor(new Image("Images/peter0.png"), 0, 0);
        }
        for (int x = 0; x < listeVivant.size(); x++) {
            listeVivant.get(x).update();
        }

    }
}
