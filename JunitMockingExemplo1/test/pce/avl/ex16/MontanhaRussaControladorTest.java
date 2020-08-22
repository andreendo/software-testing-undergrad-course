package pce.avl.ex16;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

/**
 *
 * @author Aluno
 */
public class MontanhaRussaControladorTest {
    
    MontanhaRussaControlador controlador;
    ClienteDAO clienteDaoMock;
    
    @BeforeEach
    public void before() {
        clienteDaoMock = mock(ClienteDAO.class);
        controlador = new MontanhaRussaControlador(clienteDaoMock);
    }
    
    @Test
    public void testeCVMenor18() throws Exception {
        when(clienteDaoMock.ehCliente("Bruce Lee"))
                .thenReturn(true);
        
        String res = controlador.autorizar("Bruce Lee", 15);
        assertEquals("acompanhado dos pais", res);
    }
    
    @Test
    public void testeCVMaior90() throws Exception {
        when(clienteDaoMock.ehCliente("Mestre Hoshi"))
                .thenReturn(true);
        
        String res = controlador.autorizar("Mestre Hoshi", 110);
        assertEquals("acompanhado do responsavel legal", res);
    }

    @Test
    public void testeCVIdade18a90() throws Exception {
        when(clienteDaoMock.ehCliente("Capitao Spook"))
                .thenReturn(true);
        
        String res = controlador.autorizar("Capitao Spook", 55);
        assertEquals("autorizado", res);
    }
    
    @Test
    public void testeCINomeInvalido() throws Exception {
        assertThrows(Exception.class, () -> {
        	controlador.autorizar("Peter", 55);		
        }); 
    }    
    
    @Test
    public void testeCIIdadeMenor1() throws Exception {
        assertThrows(Exception.class, () -> {
            controlador.autorizar("Peter Parker", -10);
        }); 
    }    
    
    @Test
    public void testeCIIdadeMaior120() throws Exception {
        assertThrows(Exception.class, () -> {
            controlador.autorizar("Luke Sky", 150);
        });     	
    }    
    
    @Test
    public void testeCINaoEhCliente() throws Exception {
        when(clienteDaoMock.ehCliente("Bruce Lee"))
                .thenReturn(false);
        
        assertThrows(Exception.class, () -> {
            controlador.autorizar("Bruce Lee", 15);
        });        
    }
    
}
