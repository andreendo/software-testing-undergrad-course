package mockextra.ex2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

/**
 *
 * @author andreendo
 */
public class EmpregadoTest {
    
    @Test
    public void getNomeCompletoTest() {
        //criar o objeto
        Empregado empregado = new Empregado();
        //especifica que o objeto sera "espionado" via o spyEmpregado
        Empregado spyEmpregado = spy(empregado);
        
        //apenas esses dois metodos serao mockados
        when(spyEmpregado.getPrimeiroNome()).thenReturn("Maria");
        when(spyEmpregado.getSobrenome()).thenReturn("Lacrosse");
        
        assertEquals("Maria Lacrosse", spyEmpregado.getNomeCompleto());
        
        //verifica se os metodos foram chamados na ordem correta
        InOrder inOrder = inOrder(spyEmpregado);
        inOrder.verify(spyEmpregado).getPrimeiroNome();
        inOrder.verify(spyEmpregado).getSobrenome();
    }
}
