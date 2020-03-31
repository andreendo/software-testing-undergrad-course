package exemplo.pessoa;

import java.util.ArrayList;

import exemplo.pessoa.Pessoa;
import exemplo.pessoa.PessoaDAO;
import exemplo.pessoa.RHService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

/**
 *
 * @author andreendo
 */
public class PessoaDAOTest {
    
    public PessoaDAOTest() {
    }
    
    //caminho: 1,2,5
    @Test
    public void testListaDePessoasVazia() {
        //criou o mock
        RHService rhServiceMock = mock(RHService.class); 
        //define o comportamento do mock
        ArrayList<Pessoa> pessoasDoMock = new ArrayList<Pessoa>();
        when(rhServiceMock.getAllPessoas())
                .thenReturn( pessoasDoMock );
        
        PessoaDAO dao = new PessoaDAO(rhServiceMock);
        
        assertFalse(dao.existePessoa("joao da silva"));
    }
    
    //caminho:1,2,3,2,5 
    @Test
    public void testListaDePessoasCom1Elemento() {
        //criou o mock
        RHService rhServiceMock = mock(RHService.class); 
        //define o comportamento do mock
        ArrayList<Pessoa> pessoasDoMock = new ArrayList<Pessoa>();
        Pessoa p = new Pessoa();
        p.setNome("Carlos de Souza");
        pessoasDoMock.add(p);
        
        when(rhServiceMock.getAllPessoas())
                .thenReturn( pessoasDoMock );
        
        PessoaDAO dao = new PessoaDAO(rhServiceMock);
        
        assertFalse( dao.existePessoa("joao da silva") );
    }
    
    //caminho: 1,2,3,4
    @Test
    public void testListaDePessoasCom2Elementos() {
        //criou o mock
        RHService rhServiceMock = mock(RHService.class); 
        //define o comportamento do mock
        ArrayList<Pessoa> pessoasDoMock = new ArrayList<Pessoa>();
        Pessoa p = new Pessoa();
        p.setNome("Joao Da Silva");
        pessoasDoMock.add(p);
        p = new Pessoa();
        p.setNome("Carlos de Souza");
        pessoasDoMock.add(p);
        
        when(rhServiceMock.getAllPessoas())
                .thenReturn( pessoasDoMock );
        
        PessoaDAO dao = new PessoaDAO(rhServiceMock);
        
        assertTrue( dao.existePessoa("joao da silva") );
        
        verify(rhServiceMock).getAllPessoas();
    }    
}
