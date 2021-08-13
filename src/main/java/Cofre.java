public class Cofre {
        
    private int volumeMaximo;
    private int volume = 0;
    private boolean quebrado = false;
    private String itens = "";
    private double moedas;
    
    public Cofre(int volumeMaximo) {
        this.volumeMaximo = volumeMaximo;
    }
    
    public void setVolume(int volume) {
        this.volume += volume;
    }
    
    public int getVolume() {
        return this.volume;
    }

    public int getVolumeMaximo() {
        return this.volumeMaximo;
    }

    public int getVolumeRestante() {
        return this.volumeMaximo - this.volume;
    }

    public boolean add(Item item) {
        if (quebrado) {
            return false;
        }else {
            if(volumeMaximo < item.getVolume()) {
            	return false;
            }else {
            	if(itens=="") {
	                setVolume(item.getVolume());
	                this.itens+=item.getDescricao();
	                return true;
                }else {
                	setVolume(item.getVolume());
                	this.itens+=", ";
	                this.itens+=item.getDescricao();
	                return true;
                }
            }
        }
    }

    public boolean add(Moeda moeda) {
        if (quebrado) {
            return false;
        }else {
            if(getVolume() > moeda.getVolume()||moeda.getVolume() > volumeMaximo) {
                return false;
            }else {
                setVolume(moeda.getVolume());
                this.moedas += moeda.getValor();
                return true;
            }
        }
    }

    public String obterItens() {
        if(!quebrado){
            return null;
        }else{
            if(getVolume() == 0){
                return "vazio";
            }else{
                this.volume = 0;
                return getItens();
            }
        }
    }

    private String getItens() {
        return itens;
    }

    public double obterMoedas() {
        if(!quebrado) {
            return -1;    
        }else{
            this.volume=0;
            return getMoedas();
        }
    }

    private double getMoedas() {
        return moedas;
    }
    
    public boolean taInteiro() {
        if(quebrado) {
            return false;
        }
        return true;
    }

    public boolean quebrar() {
        if(!quebrado) {
            this.quebrado = true;
            return true;
        }
        return false;
    }
}