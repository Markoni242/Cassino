package entidades;

import java.util.Scanner;

import entidades.enums.Trabalho;

public class Cassino {
	private SalaJogos salaJogos;
	private Caixa caixa;
	private String escolhas;
	private Scanner sc;
	private Pessoa pessoa;
	private int sequencia;

	public Cassino() {
		this.sc = new Scanner(System.in);
		this.salaJogos = new SalaJogos();
		this.caixa = new Caixa();
	}
	
	public void inicio(Pessoa pessoa ,int id) {
		this.pessoa = pessoa;

		if (id == 1) {
			if (pessoa.getFuncionario() == null) {
				defineFuncionario(Trabalho.FAXINEIRO);
				System.out.println();
				System.out.println("Voce conseguiu um trabalho de Faxineiro");
			} else {
				inicioFuncionario();
			}

		} else {
			inicioPlayer();
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

	public void inicioPlayer() {
		pessoa.setPlayer(new Player());
		
		System.out.println();
		System.out.println(" Bem vindo ao cassino");
		while (true) {
			this.escolhas = "";
			int cont = 0;
			while (validarOpcao(4)) {

				if (cont == 1) {
					System.out.println();
					System.out.println(" Opção invalida");
				}

				System.out.println();
				System.out.println(" Seu saldo: " + pessoa.getSaldo() + ", Fichas: " + pessoa.getPlayer().getFichas());
				System.out.println();
				System.out.println("Escolha um local:");
				System.out.println(" Caixa          : (Converter fichas) : 1");
				System.out.println(" Sala de Jogos  :     (Jogos...)     : 2");
				System.out.println(" Sala           : (BuckshotRoulette) : 3");
				System.out.println(" Sair 	        :     (sair...)      : 4");

				this.escolhas = sc.next();
				cont = 1;
			}

			if (this.escolhas.equals("1")) {
				// caixa
				caixa.inicio(pessoa);

			} else if (escolhas.equals("2")) {
				// sala jogos
				salaJogos.inicio(pessoa.getPlayer());
			} else if (escolhas.equals("3")) {
				GerenciadorRoleta gerenciadorRoleta = new GerenciadorRoleta();
				gerenciadorRoleta.iniciar();

			} else {
				pessoa.setPlayer(null);
				break;
			}
		}
	}

	public void defineFuncionario(Trabalho trabalho) {
		if (trabalho == Trabalho.FAXINEIRO) {
			pessoa.setFuncionario(new Funcionario(trabalho, 1000));
		} else if (trabalho == Trabalho.SEGURANCA) {
			pessoa.setFuncionario(new Funcionario(trabalho, 2000));
		} else if (trabalho == Trabalho.COZINHEIRO) {
			pessoa.setFuncionario(new Funcionario(trabalho, 4000));
		}
	}

	public void inicioFuncionario() {
		sequencia = 0;
		while (true) {
			this.escolhas = "";
			int cont = 0;
			while (validarOpcao(3)) {

				if (cont == 1) {
					System.out.println();
					System.out.println(" Opi�ao invalida...");
				}

				System.out.println();

				System.out.println(" Trabalho : " + pessoa.getFuncionario().getTrabalho() + ", Salario : "
						+ pessoa.getFuncionario().getSalario());

				System.out.println();
				System.out.println("Escolha uma op�ao:");
				System.out.println(" Trabalhar       : 1");
				System.out.println(" Se demitir      : 2");
				System.out.println(" Sair 	         : 3");

				this.escolhas = sc.next();
				cont = 1;
			}

			if (this.escolhas.equals("1")) {
				if (this.pessoa.getFuncionario().trabalhar()) {
					pessoa.addSaldo(this.pessoa.getFuncionario().getSalario());
					sequencia += 1;
				} else {
					sequencia -= 1;
					pessoa.addSaldo(this.pessoa.getFuncionario().getSalario()/2);
				}
				if (sequencia == 10) {
					sequencia = 0;
					System.out.println();
					System.out.println("Voce foi promovido !!!");
					
					if (pessoa.getFuncionario().getTrabalho() == Trabalho.FAXINEIRO) {
						defineFuncionario(Trabalho.SEGURANCA);
					} else if (pessoa.getFuncionario().getTrabalho() == Trabalho.SEGURANCA) {
						defineFuncionario(Trabalho.COZINHEIRO);
					} else {
						sequencia += 1;
					}
					
				} else if (sequencia == -10) {
					System.out.println();
					System.out.println("Voce foi demitido !!!");
					pessoa.setFuncionario(null);
					sequencia = 0;
					break;
				}

			} else if (escolhas.equals("2")) {
				System.out.println();
				System.out.println("Voce se demitiu...");
				pessoa.setFuncionario(null);
				sequencia = 0;
				break;
			} else {
				sequencia = 0;
				break;
			}
		}
	}
}
