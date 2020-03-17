package mockextra.ex1;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/**
 *
 * @author andreendo
 */
public class AvaliadorTest {
    
    @Test
    public void clienteComRisco10Test() {
        BD bdMock = mock(BD.class);
        
        Avaliador avaliador = new Avaliador();
        avaliador.setBd(bdMock);
        
        Cliente cliente = new Cliente();
        cliente.setId(55667);
        
        //aqui acontece a magica
        doAnswer(new Answer() {     //cria uma classe anonima
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                //recuperar o primeiro argumento do metodo
                //e alterar seu risco para 10
                Cliente c = invocation.getArgumentAt(0, Cliente.class);
                c.setRisco(10);
                return null;    //eh um metodo void
            }
        }).when(bdMock).completarDados(cliente);
        
        assertTrue( avaliador.ehClienteArriscado(cliente) );
    }
}