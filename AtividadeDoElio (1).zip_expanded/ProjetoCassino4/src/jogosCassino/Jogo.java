package jogosCassino;

import java.util.Random;
import java.util.Scanner;

public abstract class Jogo {
	protected Random gerador; 
	protected Scanner sc;
	
	public Jogo() {
		this.gerador = new Random();
		this.sc = new Scanner(System.in);
	}

	public boolean start() {
		return false;
	}
}
