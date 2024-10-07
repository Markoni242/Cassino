package jogosCassino;

import java.util.ArrayList;

import entidades.Baralho;
import entidades.Carta;

public class BlackJack extends Jogo {
	private Baralho cartas;
	private ArrayList<Carta> baralho;
	private int somaPlayer;
	private int somaDaeler;
	private int index;
	private String escolha;
	
	public void distribuirCarta(int id, int numero) {
			
		for (int i = 0; i < numero;i++) {
			int soma = 0;
	
			index = gerador.nextInt(baralho.size()-1);
			if (index == -1) {
				index = 0;
			}
			if (id == 0) {
				System.out.println();
				System.out.println("Daeler :");
			} else {
				System.out.println();
				System.out.println("Player :");
			}
			
			System.out.println("Carta  : " + baralho.get(index).getSimbolos() + " de " + baralho.get(index).getNaipe());
	
			if (baralho.get(index).getSimbolos().equals("As") || baralho.get(index).getSimbolos().equals("Valete")
					|| baralho.get(index).getSimbolos().equals("Rainha")
					|| baralho.get(index).getSimbolos().equals("Rei")) {
				
				
				if (baralho.get(index).getSimbolos().equals("As")) {
					soma += 11;
				} else {
					soma += 10;
				}
				
			} else {
				soma += baralho.get(index).getValor();
			}
			
			if (id == 0) {
				somaDaeler += soma;
				System.out.println();
				System.out.println("Soma Daeler : " + somaDaeler);
			} else {
				somaPlayer += soma;
				System.out.println();
				System.out.println("Soma Player : " + somaPlayer);
			}
			
			baralho.remove(index);
		}
	}

	public BlackJack() {
		super();
		this.cartas = new Baralho();
		this.baralho = new ArrayList<>();

	}

	@Override
	public boolean start() {
		somaPlayer = 0;
		somaDaeler = 0;

		cartas.embaralhar();

		for (Carta carta : cartas.getCartas()) {
			baralho.add(carta);
		}
		
		distribuirCarta(0, 1); // (id , qunatia cartas) ... (0, 1), id : 0 = daeler.

		distribuirCarta(1, 2);

		while (somaPlayer < 21) {
			escolha = "";
			while (escolha.equals("1") == false && escolha.equals("2") == false) {
				System.out.println();
				System.out.println(" Pedir carta : 1");
				System.out.println(" Parar       : 2");
				escolha = sc.next();
			}

			if (escolha.equals("1")) {
				distribuirCarta(1, 1);

			} else {
				break;
			}

		}

		while (somaPlayer < 21 && (somaDaeler < 21 && somaDaeler <= somaPlayer)) {
			System.out.println();

			distribuirCarta(0, 1);
		}

		baralho.clear();

		System.out.println();
		if (somaDaeler > 21 || somaPlayer == 21) {
			System.out.println("Voce ganhou");
			return true;
		} else {
			System.out.println("Voce perdeu");
			return false;
		}
	}

	@Override
	public String toString() {
		return "BlackJack";
	}

}
