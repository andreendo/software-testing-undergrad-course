package example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FixtureExampleTest {
	static BancoDeDados bd = Estrutura.criarConexao();
	
	@AfterAll
	static void afterAll() {
		System.out.println("afterAll");
	}

	@BeforeAll
	static void beforeAll() {
		System.out.println("beforeAll");
	}
	
	@BeforeEach
	void beforeEach() {
		System.out.println("BeforeEach");
	}

	@AfterEach
	void afterEach() {
		System.out.println("AfterEach");
	}	

	@Test
	void test01() {
		System.out.println("test 01");
		
		bd.adicionarDadosFake();
		Estrutura.executar("run test01");
		bd.apagar();
	}

	@Test
	void test02() {
		System.out.println("test 02");

		bd.adicionarDadosFake();
		Estrutura.executar("run test02");
		bd.apagar();
	}

	@Test
	void test03() {
		System.out.println("test 03");
		
		bd.adicionarDadosFake();
		Estrutura.executar("run test03");
		bd.apagar();		
	}	
}