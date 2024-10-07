package entidades;

import java.util.ArrayList;
import java.util.Collections;

public class Baralho {
	private ArrayList<Carta> cartas;

	public Baralho() {
		cartas = new ArrayList<>();
		String[] naipes = { "espadas", "copas", "ouros", "paus" };
		String[] simbolos = { "As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Valete", "Rainha", "Rei" };

		for (String naipe : naipes) {
			for (int x = 1; x < 14; x++) {
				cartas.add(new Carta(naipe, simbolos[x - 1], x));
			}
		}
	}

	public ArrayList<Carta> getCartas() {
		return this.cartas;
	}

	public void embaralhar() {
		Collections.shuffle(cartas);
	}
}
