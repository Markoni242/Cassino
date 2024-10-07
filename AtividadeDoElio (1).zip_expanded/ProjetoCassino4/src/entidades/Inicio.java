package entidades;

import java.util.ArrayList;
import java.util.Scanner;

public class Inicio {
	private Cassino cassino;
	private Pessoa pessoa;
	public Scanner sc;
	
	public Inicio() {
		this.sc = new Scanner(System.in);
		this.cassino = new Cassino();
		String escolha;
		ArrayList<Pessoa> pessoas = new ArrayList<>();
		
		while (true) {
			escolha = "";
			while (escolha.equals("1") == false && escolha.equals("2") == false && escolha.equals("3") == false && escolha.equals("4") == false) {
				
				if (this.pessoa == null) {
					System.out.println();
					System.out.println("Bem vindo...           :");
					System.out.println(" Come�ar               : 1");
					System.out.println(" Continuar             : 2");
					System.out.println(" Buscar                : 3");
					System.out.println(" Sair                  : 4");
				} else {
					System.out.println();
					System.out.println("Bem vindo : ("+pessoa.getNome()+")");
					System.out.println(" Nova pessoa           : 1");
					System.out.println(" Continuar             : 2");
					System.out.println(" Buscar                : 3");
					System.out.println(" Sair                  : 4");
				}
				
				escolha = sc.next();
			}
			
			if (escolha.equals("1")) {
				if (this.pessoa == null) {
					System.out.println();
					System.out.println("digite um nome:");
					this.pessoa = new Pessoa(sc.next());
					pessoas.add(this.pessoa);
					
					continuarComecar();
					
				} else if (pessoa != null) {
					System.out.println();
					System.out.println("digite um nome:");
					this.pessoa = new Pessoa(sc.next());
					pessoas.add(this.pessoa);
				}
				

			} else if (escolha.equals("2")) {
				
				if (pessoas.size() == 0) {
					System.out.println();
					System.out.println("Nao a o que continuar");
					
				} else {
					continuarComecar();
				}
			}
			else if (escolha.equals("3")) {
				if (pessoas.size() <= 1) {
					System.out.println();
					System.out.println("Nao ninguem para buscar");
				} else {
					System.out.println();
					System.out.println("Insira o nome da pessoa");
					String texto = sc.next();
					for (Pessoa pessoaAtual : pessoas) {
						if (pessoaAtual.getNome().equals(texto)) {
							this.pessoa = pessoaAtual;
							break;
						}
					}
					if (this.pessoa.getNome().equals(texto)) {
						
					} else {
						System.out.println();
						System.out.println("Nome nao encontrado");
					}
					
				}
			} else {
				break;
			}
			
			
		}
		sc.close();
	}
	
	public void continuarComecar() {
		while (true) {
			String escolha = "";

			while (escolha.equals("1") == false && escolha.equals("2") == false && escolha.equals("3") == false) {
				System.out.println();
				if (pessoa.getFuncionario() == null) {
					System.out.println(" Seu saldo : " + pessoa.getSaldo() + " (Trabalho : Nenhum)");
				} else {
					System.out.println(" Seu saldo : " + pessoa.getSaldo() + " (Trabalho : "
							+ pessoa.getFuncionario().getTrabalho() + ")");
				}
				System.out.println();
				if (pessoa.getFuncionario() == null) {
					System.out.println("Oque que fazer                     :");
					System.out.println(" Ir ao cassino procurar emprego    : 1");
					System.out.println(" Ir ao cassino jogar               : 2");
					System.out.println(" Sair                              : 3");

				} else {
					System.out.println("Oque que fazer           :");
					System.out.println(" Ir ao cassino Trabalhar : 1");
					System.out.println(" Ir ao cassino jogar     : 2");
					System.out.println(" Sair                    : 3");
				}

				escolha = sc.next();
			}

			if (escolha.equals("3")) {
				System.out.println();
				System.out.println("Adeus");
				break;
			} 
			cassino.inicio(pessoa,Integer.parseInt(escolha));
		}
	}

}
