package entidades;

import itensBuckshotRoulette.Lupa;
import itensBuckshotRoulette.LataDeCerveja;
import itensBuckshotRoulette.Algemas;
import itensBuckshotRoulette.Serra;
import jogosCassino.BuckshotRoulette;
import itensBuckshotRoulette.Cigarro;

public class GerenciadorRoleta {
	private BuckshotRoulette buckshotRoulette;

	public GerenciadorRoleta() {
		this.buckshotRoulette = new BuckshotRoulette();
	}

	public void iniciar() {
		System.out.println("Bem-vindo ao Buckshot Roulette!!!");

		buckshotRoulette.adicionarItem(new Lupa());
		buckshotRoulette.adicionarItem(new LataDeCerveja());
		buckshotRoulette.adicionarItem(new Algemas());
		buckshotRoulette.adicionarItem(new Serra());
		buckshotRoulette.adicionarItem(new Cigarro());

		buckshotRoulette.start();

		System.out.println("Jogo finalizado!");
	}
}
