package ex5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClimatizadorTest {

	@Test
	void testUmidificar() {
		//new,
		var c = new Climatizador();
		//ligar, 
		c.ligar();
		//umidificar,
		c.umidificar();
		//umidificando/false, 
		assertFalse(c.umidificando());
		//umidificar,
		c.umidificar();
		//umidificando/true, 
		assertTrue(c.umidificando());
		//aumentarV/true,
		assertTrue(c.aumentarV());
		//umidificar,
		c.umidificar();
		//umidificando/false, 
		assertFalse(c.umidificando());
		//umidificar,
		c.umidificar();
		//umidificando/true		
		assertTrue(c.umidificando());
	}

	
	@Test
	void testDesligar() {
		//new,
		var c = new Climatizador();
		//ligar, 
		c.ligar();
		//desligar,
		c.desligar();
		//velocidade/0, 
		assertEquals(0, c.velocidade());
		//ligar, 
		c.ligar();
		//aumentarV/true, 
		assertTrue(c.aumentarV());
		//umidificar, 
		c.umidificar();
		//desligar, 
		c.desligar();
		//velocidade/0
		assertEquals(0, c.velocidade());
	}
}
