package entidades;

import entidades.enums.Trabalho;
import jogosCassino.Jogo;
import minigamesTrabalhos.*;

public class Funcionario {
	private double salario;
	private Jogo miniGame;
	private Trabalho trabalho;

	public Funcionario(Trabalho trabalho, double salario) {
		
		if (trabalho == Trabalho.FAXINEIRO) {
			this.miniGame = new JogoFaxineiro();
		} else if (trabalho == Trabalho.SEGURANCA) {
			this.miniGame = new JogoSeguranca();
		} else if (trabalho == Trabalho.COZINHEIRO) {
			this.miniGame = new JogoCozinheiro();
		}
		this.trabalho = trabalho;
		this.salario = salario;
	}

	public boolean trabalhar() {
		return miniGame.start();
	}

	public double getSalario() {
		return salario;
	}

	public Trabalho getTrabalho() {
		return trabalho;
	}
}
