package td.ex09;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculadoraDeDescontosTest {
    CalculadoraDeDescontos c = new CalculadoraDeDescontos();
    
    @Test
    public void c1() {    
        assertEquals(10, c.calcular(true, false, false) );
    }
    @Test
    public void c2() {
        assertEquals(12, c.calcular(false, true, false) );
    }
    @Test
    public void c3() {
        assertEquals(25, c.calcular(false, false, true) );
    }
    @Test
    public void c4() {
        assertEquals(25, c.calcular(true, false, true) );
    }
    @Test
    public void c5() {
        assertEquals(0, c.calcular(false, false, false) );
    }
    @Test
    public void c6() {
        assertEquals(37, c.calcular(false, true, true) );
    }

}
