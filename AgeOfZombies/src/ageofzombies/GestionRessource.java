package ageofzombies;

import java.util.ArrayList;
import org.newdawn.slick.Image;
import java.util.HashMap;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Michel
 */
public class GestionRessource {
    private static GestionRessource instance = null;
    
    private HashMap<String,Integer> mapNomNo;
    private HashMap<Integer,Image> mapNoImg;
    private ArrayList<int[]> liste = new ArrayList<>();
    
    private GestionRessource(){
            
        mapNomNo = new HashMap<>();
        mapNoImg = new HashMap<>();
    }
    
    public static GestionRessource getInstance(){
        
        if(instance == null){
            instance = new GestionRessource();
        }
        
        return instance;
    }
    
    public Integer chargerImage(String nom) throws SlickException{
        Integer no;
        
        if(mapNomNo.containsKey(nom) == false){
            no = mapNoImg.size()+1;
            mapNomNo.put(nom, no);
            Image tmp = new Image("Images/"+nom);
            mapNoImg.put(no, tmp);                
            return no;
        }
        
        no = mapNomNo.get(nom);
        
        return no;
    }
    
    public Image getImage(Integer no){
        
        return mapNoImg.get(no);
    }
    
    public void terminer(){
        mapNoImg.clear();
        mapNomNo.clear();
    }
}
