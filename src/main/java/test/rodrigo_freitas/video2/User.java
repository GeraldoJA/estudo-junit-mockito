package test.rodrigo_freitas.video2;

public class User {
	
	private double salario;
	private String nome;
	
	public void reajuste(int nota) {
		if(nota > 8) {
			this.salario = salario * 1.50;
		}else {
			this.salario = salario * 1.10;
		}
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	
	

}
