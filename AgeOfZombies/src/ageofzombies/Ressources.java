package ageofzombies;

public class Ressources {
    private int ble;
    private int minerai;
    
    public Ressources(){
        ble = 0;
        minerai = 0;
    }
    
    public Ressources(int _ble, int _minerai){
        ble = _ble;
        minerai = _minerai;
    }
    
    public void ajouterRessources(Ressources r){
        ble+= r.getBle();
        minerai+= r.getMinerai();
    }
    
  public void setRessource(Ressources r){
        ble = r.getBle();
        minerai = r.getMinerai();
    }
  
  public void vider(){
      ble = 0;
      minerai = 0;
  }

    public int getBle() {
        return ble;
    }

    public void setBle(int ble) {
        this.ble = ble;
    }

    public int getMinerai() {
        return minerai;
    }

    public void setMinerai(int minerai) {
        this.minerai = minerai;
    }
    
}
