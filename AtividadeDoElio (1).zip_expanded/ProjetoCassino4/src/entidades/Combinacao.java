package entidades;

public class Combinacao {
	private int valor;
	private String tipo;

	public Combinacao(int valor, String tipo) {
		this.valor = valor;
		this.tipo = tipo;
	}

	public int getValor() {
		return valor;
	}

	@Override
	public String toString() {
		return tipo;
	}
}
