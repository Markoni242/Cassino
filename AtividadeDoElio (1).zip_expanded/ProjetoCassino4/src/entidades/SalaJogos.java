package entidades;

import java.util.ArrayList;
import java.util.Scanner;
import jogosCassino.*;

public class SalaJogos {
	private Player player;
	private ArrayList<Mesa> mesas;
	private ArrayList<CacaNiquel> listCacaNiqueis;
	protected String escolhas;
	protected Scanner sc;
	private int escolhaInt;
	private ArrayList<Jogo> listaJogos;

	public SalaJogos() {
		this.sc = new Scanner(System.in);
		this.listCacaNiqueis = new ArrayList<CacaNiquel>();
		this.mesas = new ArrayList<Mesa>();
		listaJogos = new ArrayList<>();
				
		listaJogos.add(new Dados(3));
		listaJogos.add(new BlackJack());
		listaJogos.add(new Hilo());
		listaJogos.add(new Keno());

		for (Jogo jogo : listaJogos) {
			this.mesas.add(new Mesa(jogo));
		}
		listCacaNiqueis.add(new CacaNiquel(3));
	}

	public int getSizeListMesas() {
		return mesas.size();
	}

	public void inicio(Player player) {
		this.player = player;
		while (true) {
			escolhas = "";
			System.out.println();
			System.out.println("Fichas : " + this.player.getFichas());
			System.out.println();

			System.out.println("_SALA DE JOGOS_");
			while (validarOpcao(this.mesas.size() + 2)) {

				for (int i = 0; i < this.mesas.size(); i++) {
					System.out
							.println(" Mesa :" + (i + 1) + " (Jogo " + this.mesas.get(i).getJogo() + ") = " + (i + 1));
				}
				System.out.println(" Caça-Niquel = " + (this.mesas.size() + 1));
				System.out.println(" Sair = " + (this.mesas.size() + 2));
				this.escolhas = sc.next();
			}

			this.escolhaInt = Integer.parseInt(escolhas);

			if (this.escolhaInt <= this.mesas.size()) {
				irParaMesa(this.escolhaInt - 1);

			} else if (this.escolhaInt == this.mesas.size() + 1) {
				irParaCacaNiquel(0);

			} else {
				break;
			}
		}
	}

	public boolean validarOpcao(int quantia) {
		for (int i = 0; i < (quantia); i++) {
			if (this.escolhas.equals((i + 1) + "")) {
				return false;
			}
		}
		return true;
	}


	public void irParaMesa(int index) {
		
		this.mesas.get(index).setAposta(0);
		
		while (true) {
			this.escolhas = "";
			while (escolhas.equals("1") == false && escolhas.equals("2") == false && escolhas.equals("3") == false) {
				System.out.println();
				System.out
						.println(" Fichas: " + this.player.getFichas() + ", Aposta : (" + this.mesas.get(index).getAposta() + ")");
				System.out.println();
				System.out.println("_MESA_ " + (index + 1) + "_ (Jogo : " + this.mesas.get(index).getJogo() + ")");
				System.out.println(" Jogar   : 1");
				System.out.println(" Apostar : 2");
				System.out.println(" Sair    : 3");
				this.escolhas = sc.next();
			}

			if (escolhas.equals("1")) {
				this.mesas.get(index).jogar();
				this.player.addFichas(mesas.get(index).returnAposta());

			} else if (this.escolhas.equals("2")) {
				if ( this.player.getFichas() == 0) {
					System.out.println();
					System.out.println("Voce nao possui fichas suficiente");

				} else {
					this.mesas.get(index).apostar();
				}
			} else {
				break;
			}
		}
	}

	public void irParaCacaNiquel(int index) {
		while (true) {
			System.out.println();
			System.out.println("Fichas : " +  this.player.getFichas());
			System.out.println();
			System.out.println("_CAÇA-NIQUEL_ : Custo = (5 fichas) ");
			System.out.println(" Jogar : 1");
			System.out.println(" Sair  : 2");
			this.escolhas = sc.next();

			while (escolhas.equals("1") == false && escolhas.equals("2") == false) {
				escolhas = sc.next();
			}

			if (escolhas.equals("1")) {
				if ( this.player.getFichas() == 0) {
					System.out.println();
					System.out.println("Voce nao possui fichas suficiente");
				} else {
					 this.player.addFichas(-5);
					if (listCacaNiqueis.get(index).start()) {
						this.player.addFichas(this.listCacaNiqueis.get(index).premiacao());
					}
				}
			} else {
				break;
			}
		}
	}
}
