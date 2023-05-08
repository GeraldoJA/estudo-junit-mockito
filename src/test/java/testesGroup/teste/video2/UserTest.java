package testesGroup.teste.video2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import testesGroup.video2.User;

class UserTest {

	private User user;
	
	@BeforeEach
	private void createUser() {
		System.out.println("before each");
		user = new User();
		user.setSalario(1000d);
		user.setNome("pedro");
	}
	
	@AfterEach
	public void afterEach() {
		System.out.println("after each");
	}
	
	@BeforeAll
	public static void beforeAll() {
		System.out.println("before all");
	}
	
	@AfterAll
	public static void afterAll() {
		System.out.println("after all");
	}
	
	@Test
	void testaReajusteComNotaMaisAlta() {
		System.out.println("Nota Mais Alta");
		user.reajuste(9);
		double salario = user.getSalario();
		Assertions.assertEquals(1500, salario);		
	}

	@Test
	void testaReajusteComNotaMaisBaixa() {
		System.out.println("Nota Mais Baixa");
		user.reajuste(5);
		double salario = user.getSalario();
		Assertions.assertEquals(1100, salario);		
	}

}
