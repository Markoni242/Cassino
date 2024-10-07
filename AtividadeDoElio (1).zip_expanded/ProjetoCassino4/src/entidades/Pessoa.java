package entidades;

public class Pessoa {
	private String nome;
	private double saldo;
	private Player player;
	private Funcionario funcionario;

	public Pessoa(String nome) {
		this.saldo = 500;
		this.nome = nome;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public double getSaldo() {
		return saldo;
	}

	public void addSaldo(double saldo) {
		this.saldo += saldo;
	}

	public String getNome() {
		return nome;
	}

}
