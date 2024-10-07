package entidades;

public class Player {
	private int fichas;

	public Player() {
		this.fichas = 0;
	}

	public int getFichas() {
		return this.fichas;
	}

	public void addFichas(int fichas) {
		this.fichas += fichas;

	}

}