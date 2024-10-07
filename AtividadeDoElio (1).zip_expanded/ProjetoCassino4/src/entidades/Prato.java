package entidades;

public class Prato {
	private String nome;
	private String[] igredientes;

	public Prato(String nome, String[] igredientes) {
		this.igredientes = igredientes;
		this.nome = nome;
	}

	public String getIgrediente(int index) {
		return igredientes[index];
	}

	public int getListaSize() {
		return igredientes.length;
	}

	@Override
	public String toString() {
		return nome;
	}

}
