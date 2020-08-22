package td.ex17;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculadoraTest {

	@Test
	void testC1() {
		Calculadora calc = new Calculadora();
		Salario salario = calc.calcularSalario("Assalariado40H", 0);
		assertEquals(4000, salario.getValorSalario());
		assertEquals("", salario.getPendencia());
	}

	@Test
	void testC2() {
		Calculadora calc = new Calculadora();
		Salario salario = calc.calcularSalario("Assalariado20H", 0);
		assertEquals(1500, salario.getValorSalario());
		assertEquals("", salario.getPendencia());
	}
	
	@Test
	void testC3() {
		Calculadora calc = new Calculadora();
		Salario salario = calc.calcularSalario("Horista", 40);
		assertEquals(40 * 15, salario.getValorSalario());
		assertEquals("", salario.getPendencia());
	}	
	
	@Test
	void testC4() {
		Calculadora calc = new Calculadora();
		Salario salario = calc.calcularSalario("Horista", 25);
		assertEquals(25 * 15, salario.getValorSalario());
		assertEquals("Relatorio de ausencia", salario.getPendencia());
	}		
	
	@Test
	void testC5() {
		Calculadora calc = new Calculadora();
		Salario salario = calc.calcularSalario("Horista", 60);
		assertEquals(60 * 15, salario.getValorSalario());
		assertEquals("Relatorio de horas-extra", salario.getPendencia());
	}			
	
}
