package ElementsJeu;

import ageofzombies.GestionRessource;
import batiments.InterfaceBase;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.*;


/**
 *
 * @author Julien
 */
abstract public class Entite implements InterfaceBase{

    protected Vecteur position;

    //Variables pour l'affichage
    /*
     * Au final, je pense qu'on devrait tenter d'utiliser les sprites, ça serait plus facile pour gérer les
     * changements de direction... à voir... (Eradash
     */
    private int codeImage[];
    private int codePresent;
    private int nbImagesSecondes = 0;
    private int codeActuel = 0;      // xD ça ressemble beaucoup au codePresent xD
    //
    
    private int vie;
    private Shape rectangle;
    

    public Entite(Vecteur position, String nomImg, String formatImage, int nbImages) throws SlickException {
        this.position = position;
        codeImage = new int[nbImages];
        
        for (int i = 0 ; i < codeImage.length ; i++){
            codeImage[i] = GestionRessource.getInstance().chargerImage(nomImg+i+formatImage); 
        }
        codePresent = codeImage[0];
        rectangle = new Rectangle(position.getX(),position.getY(),GestionRessource.getInstance().getImage(codeImage[0]).getWidth(), GestionRessource.getInstance().getImage(codeImage[0]).getHeight());
       }

    @Override
    public Shape getForme(){
        return rectangle;
    }

     public void setForme(Shape _forme){
        rectangle = _forme;
    }
     
    public void render(Graphics g) {
        g.drawImage(GestionRessource.getInstance().getImage(codePresent), getX(), getY());
        nbImagesSecondes++;
        if (nbImagesSecondes > 30){
            nbImagesSecondes = 0;
            prochaineImage();
        }
    }
    
    //Voir commentaire plus haut où les variables
    private void prochaineImage(){
        if(codeImage.length == 1){
            codeActuel = 0;
        } else if (codeImage.length == codeActuel+1){
            codeActuel = 0;
        } else {
            codeActuel++;
        }
        codePresent = codeImage[codeActuel];
    }

    public void update(){
        rectangle.setX(position.getX());
        rectangle.setY(position.getY());
    }

    public int getX() {
        return position.getX();
    }
 
    @Override
    public Vecteur getPosition(){
        return new Vecteur(position);
    }
    
    public int getY() {
        return position.getY();
    }
}