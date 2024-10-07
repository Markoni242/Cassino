package entidades;

public class Carta {
	private String naipe;
	private String simbolo;
	private int valor;

	public Carta(String naipe, String simbulo, int valor) {
		this.naipe = naipe;
		this.simbolo = simbulo;
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getNaipe() {
		return naipe;
	}

	public String getSimbolos() {
		return simbolo;
	}
}
