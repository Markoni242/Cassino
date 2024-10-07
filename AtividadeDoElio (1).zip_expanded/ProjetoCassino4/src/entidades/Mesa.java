package entidades;

import java.util.Scanner;

import jogosCassino.Jogo;

public class Mesa {
	private Jogo jogo;
	private int aposta;
	private String valor;
	private Scanner sc;

	public Mesa(Jogo jogo) {
		this.jogo = jogo;
		this.aposta = 0;
		this.sc = new Scanner(System.in);
	}

	public Jogo getJogo() {
		return jogo;
	}

	public int getAposta() {
		return aposta;
	}

	public void setAposta(int valor) {
		this.aposta = valor;
	}

	public int returnAposta() {
		int retorno = this.aposta;
		this.aposta = 0;
		return retorno;
	}

	public boolean verificarInt(String valorString) {
		try {
			Integer.parseInt(valorString);

		} catch (NumberFormatException e) {
			return false;
		}

		if (Integer.parseInt(valorString) < 0) {
			return false;
		}
		return true;
	}

	public void apostar() {
		System.out.println();
		System.out.println("Qual o valor da aposta");
		this.valor = sc.next();

		if (verificarInt(this.valor)) {
			this.aposta = Integer.parseInt(this.valor);
		} else {
			System.out.println("Valor invalido");
		}
	}

	public void jogar() {
		
		if (this.jogo.start()) {
			this.aposta *= 2;
		} else {
			this.aposta *= -1;
		}

		if (this.aposta > 0) {
			System.out.println("fichas: +" + this.aposta);
		} else if (this.aposta < 0) {
			System.out.println("fichas: " + this.aposta);
		}
	}
}
