public class Cofre {

    int volume = 0;
    int volumeMaximo = 100;
    boolean quebrado = false;

    public Cofre(int volumeMaximo) {
        this.volumeMaximo = volumeMaximo;
    }

    public int getVolume() {
        return volume;
    }

    public int getVolumeMaximo() {
        return volumeMaximo;
    }

    public int getVolumeRestante() {
        return volumeMaximo - volume;
    }

    public boolean add(Item item) {
        if (quebrado == false){
            if (volume < volumeMaximo){
                volume ++;
                return true;
            }
            else return false;
        }
        else return false;
    }

    public boolean add(Moeda moeda) {
        if(quebrado == false){
            if (volume < volumeMaximo){
                volume ++;
                return true;
            }
            else return false;
        }
        else return false;
    }

    public String obterItens() {
        return "vazio";
    }

    private String getItens() {
        return null;
    }

    public double obterMoedas() {
        if(quebrado==true){
            return 0;
        }
        else return -1;
    }
    
    public boolean taInteiro() {
        return false;
    }

    public boolean quebrar() {
        if (quebrado == true){
            return false;
        }else{
            volume = 0;
            volumeMaximo = 0;
            quebrado = true;
            return true;
        }
    }
}
