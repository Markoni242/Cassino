package entidades;

import java.util.Scanner;

public class Caixa {
	private String escolhas;
	private String valor;

	private Pessoa pessoa;

	private Scanner sc;

	public Caixa() {
		this.sc = new Scanner(System.in);
		this.valor = "";
		this.escolhas = "";
	}

	public boolean verificarInt(String valorString) {
		try {
			Integer.parseInt(valorString);

		} catch (NumberFormatException e) {
			return false;
		}

		if (Integer.parseInt(valorString) < 0) {
			System.out.println();
			System.out.println("Voce so pode converter valores inteiros positivos !");
			return false;
		}
		return true;
	}

	public void inicio(Pessoa pessoa) {
		this.pessoa = pessoa;
		
		while (true) {
			System.out.println();
			System.out.println("Seu saldo: " + pessoa.getSaldo() + ", Fichas: " +  pessoa.getPlayer().getFichas());
			System.out.println();
			System.out.println("_CAIXA_ : conversao (1 para 1)");
			System.out.println("Oque deseja converter ?");
			System.out.println(" Dinheiro : 1");
			System.out.println(" Fichas   : 2");
			System.out.println(" Sair     : 3");
			escolhas = "";

			while (escolhas.equals("1") == false && escolhas.equals("2") == false && escolhas.equals("3") == false) {
				escolhas = sc.next();
			}

			if (escolhas.equals("1")) {
				if (pessoa.getSaldo() <= 0) {
					System.out.println();
					System.out.println("Voce nao possui saldo");
				} else {
					converteParaFichas();
				}
			} else if (escolhas.equals("2")) {
				if (pessoa.getPlayer().getFichas() <= 0) {
					System.out.println();
					System.out.println("Voce nao possui fichas.");
				} else {
					converteParaDinheiro();
				}

			} else {
				break;
			}
		}
	}

	public void converteParaFichas() {
		valor = "";
		System.out.println();
		System.out.println("Quanto voce deseja converter ? ");
		valor = sc.next();

		if (verificarInt(valor)) {
			if (Integer.parseInt(valor) > pessoa.getSaldo()) {
				System.out.println();
				System.out.println("Voce nao possui essa quantia");
			} else {
				this.pessoa.addSaldo(Double.parseDouble(valor)*-1);
				this.pessoa.getPlayer().addFichas(Integer.parseInt(valor));
			}
		}
	}

	public void converteParaDinheiro() {
		valor = "";
		System.out.println();
		System.out.println("Quanto voce deseja converter ? ");
		valor = sc.next();

		if (verificarInt(valor)) {
			this.pessoa.addSaldo(Double.parseDouble(valor));
			this.pessoa.getPlayer().addFichas(Integer.parseInt(valor)*-1);
		}
	}
}
