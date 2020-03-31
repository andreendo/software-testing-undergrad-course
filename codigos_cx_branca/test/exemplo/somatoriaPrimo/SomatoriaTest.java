package exemplo.somatoriaPrimo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


import exemplo.somatoriaPrimo.MathOps;
import exemplo.somatoriaPrimo.Primo;
import exemplo.somatoriaPrimo.Somatoria;

import static org.mockito.Mockito.*;

/**
 *
 * @author andreendo
 */
public class SomatoriaTest {
    
    @Test
    public void testListaVazia() {
        Somatoria somatoria = new Somatoria(null);
        int numeros[] = {};
        assertEquals(0, somatoria.somaDeFatoriais(numeros, null));
    }
    
    @Test
    public void testPrimoMock() {
        //criar o mock
        Primo primoMock = mock(Primo.class);
        //definir o comportamento
        when(primoMock.ehPrimo(5))
                .thenReturn(Boolean.TRUE);
        when(primoMock.ehPrimo(11))
                .thenReturn(Boolean.TRUE);
                
        Somatoria somatoria = new Somatoria(null);
        int numeros[] = {5, 11};
        assertEquals(0, somatoria.somaDeFatoriais(numeros, primoMock) );
    }
    
    @Test
    public void testPrimoMockFatorialMock() {
        //criar o mock
        Primo primoMock = mock(Primo.class);
        MathOps mathopsMock = mock(MathOps.class);
        //definir o comportamento
        when(primoMock.ehPrimo(4))
                .thenReturn(Boolean.FALSE);
        when(primoMock.ehPrimo(5))
                .thenReturn(Boolean.TRUE);
        when(primoMock.ehPrimo(6))
                .thenReturn(Boolean.FALSE);        
        when(primoMock.ehPrimo(11))
                .thenReturn(Boolean.TRUE);
        
        when(mathopsMock.fatorial(4))
                .thenReturn(24);
        when(mathopsMock.fatorial(6))
                .thenReturn(720);                
        
        Somatoria somatoria = new Somatoria(mathopsMock);
        int numeros[] = {4, 5, 6, 11};
        assertEquals(744, somatoria.somaDeFatoriais(numeros, primoMock));
    }    
}
