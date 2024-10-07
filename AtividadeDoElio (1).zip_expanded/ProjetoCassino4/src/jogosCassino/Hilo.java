package jogosCassino;

import entidades.Carta;

import java.util.ArrayList;

import entidades.Baralho;

public class Hilo extends Jogo {
	private Baralho cartas;
	private ArrayList<Carta> baralho;
	private Carta cartaAtual;
	private int index;
	private Carta proximaCarta;
	private int erros;
	private String resposta;

	public Hilo() {
		super();

		cartas = new Baralho();
		baralho = new ArrayList<>();

	}

	@Override
	public boolean start() {
		this.erros = 0;

		cartas.embaralhar();
		for (int i = 1; i < 14; i++) {
			for (Carta carta : cartas.getCartas()) {
				if (carta.getValor() == i) {
					baralho.add(carta);
					break;
				}
			}
		}

		index = gerador.nextInt(12);
		cartaAtual = baralho.get(index);
		baralho.remove(index);

		while (baralho.size() != 0) {

			System.out.println();
			resposta = "";
			while (resposta.equals("1") == false && resposta.equals("2") == false) {

				System.out.println(" Carta : " + cartaAtual.getSimbolos() + " de " + cartaAtual.getNaipe()
						+ ", Valor : " + cartaAtual.getValor());
				System.out.println();
				System.out.println("a próxima carta é maior ou menor?");
				System.out.println(" Maior    : 1");
				System.out.println(" Menor    : 2");
				resposta = sc.next();

			}

			index = gerador.nextInt(baralho.size()) - 1;
			if (index == -1) {
				index = 0;
			}
			proximaCarta = baralho.get(index);
			baralho.remove(index);

			System.out.println();
			if (resposta.equals("1")) {
				if (cartaAtual.getValor() < proximaCarta.getValor()) {
					cartaAtual = proximaCarta;
					System.out.println("acertou!!");

				} else {
					cartaAtual = proximaCarta;
					System.out.println("errou!!");
					erros += 1;
				}
			} else if (resposta.equals("2")) {
				if (cartaAtual.getValor() > proximaCarta.getValor()) {
					cartaAtual = proximaCarta;
					System.out.println("Acertou!!!");
				} else {
					cartaAtual = proximaCarta;
					System.out.println("errou!!");
					erros += 1;
				}

			}
		}
		baralho.clear();
		System.out.println();
		if (erros >= 7) {
			System.out.println("Voce perdeu, erros : " + erros);
			return false;
		} else {
			System.out.println("Voce venceu, erros : " + erros);
			return true;
		}
	}

	@Override
	public String toString() {
		return "Hilo";
	}

}
