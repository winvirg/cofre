public enum Moeda {
	
    M10(.10, 1),
    M25(.25, 2),
    M50(.50, 3),
    M100(1.00, 4);

	private int volume;
	private double valor;
	
    Moeda(double valor, int volume) {
    	this.volume = volume;
		this.valor = valor;
    }

	public int getVolume() {
		return volume;
	}

	public double getValor(){
		return valor;
	}
    
    
}
