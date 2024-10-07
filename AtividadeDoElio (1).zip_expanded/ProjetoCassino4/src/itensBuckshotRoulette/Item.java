package itensBuckshotRoulette;

import java.util.Scanner;

import jogosCassino.BuckshotRoulette;

public abstract class Item {
	protected Scanner sc;
    public abstract void usar(BuckshotRoulette jogo);

	public Item() {
		this.sc = new Scanner(System.in);
	}
}