package ordenacaoTop;

import ordenacaoTop.Atividade;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 *
 * @author andreendo
 */
public class GrafoTest {
    
    Grafo g;
    Atividade aMeia, aCamisa, aCueca, aCalca, aSapato;
        
    @BeforeEach
    public void beforeEach() {
        aMeia = new Atividade("meia");
        aCamisa = new Atividade("camisa");
        aCueca = new Atividade("cueca");
        aCalca = new Atividade("calca");
        aSapato = new Atividade("sapato");
        g = new Grafo();
        g.add(aMeia);
        g.add(aCamisa);
        g.add(aCueca);
        g.add(aCalca);
        g.add(aSapato);
        g.addDependencia(aMeia, aSapato);
        g.addDependencia(aCamisa, aCalca);
        g.addDependencia(aCueca, aCalca);
        g.addDependencia(aCalca, aSapato);
    }        
    
    @Test
    public void testAtividadesSemDependencia() {
        assertEquals(3, g.getAtividadesSemDepedencia().size());
    }    
    
    @Test
    public void testRemoverDependencia() {
        g.removerDependenciasDe(aCamisa);
        assertEquals(3, g.getDependencias().size());
    }    

    @Test
    public void testRoupaDeHomem() {       
        List<Atividade> ativOrdenadas = g.ordenacaoTopologica();
        assertEquals(aMeia, ativOrdenadas.get(0));
        assertEquals(aCamisa, ativOrdenadas.get(1));
        assertEquals(aCueca, ativOrdenadas.get(2));
        assertEquals(aCalca, ativOrdenadas.get(3));
        assertEquals(aSapato, ativOrdenadas.get(4));
    }
}
