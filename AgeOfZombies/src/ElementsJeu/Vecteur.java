/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementsJeu;

/**
 *
 * @author Moi
 */
public class Vecteur {
    double x,y;
    
    public Vecteur(){
        x = 0.0;
        y = 0.0;
    }
    
    public Vecteur(int _x,int _y){
        x = _x;
        y = _y;
    }
    
    public Vecteur(Vecteur _v){
        x = _v.x;
        y = _v.y;
    }
    
    public void setX(int _x){
        x = _x;
    }
    
    public void setY(int _y){
        y = _y;
    }
    
        public void multiplication(double _d){
        x *= _d;
        y *= _d;
    }
    
    public double distance(Vecteur _v){
        double d = Math.sqrt((_v.x - x)*(_v.x - x) + (_v.y - y)*(_v.y - y));
        
        return d;
    }
        public Vecteur unitaire(Vecteur _v){
        Vecteur tmp = new Vecteur(this);
        
        double d = tmp.distance(_v);
        
        tmp.x = (_v.x - tmp.x)/d;
        tmp.y = (_v.y - tmp.y)/d;
        
        return tmp;
    }
    
    public void addition(Vecteur _v){
        x += _v.x;
        y += _v.y;
    }
    
    
    
    public int getX(){
        return (int) x;
    }
    
    public int getY(){
        return (int) y;
    }
}
