package exemplo.linha;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import exemplo.linha.NovaLinha;

/**
 *
 * @author andreendo
 */
public class NovaLinhaTest {
    
	//Caminho executado: 	
    @Test
    public void testCobreArco3_9() {
        NovaLinha nl = new NovaLinha();
        String ret = nl.collapseNewlines("");
        assertEquals("", ret);
    }
    
    //Caminho executado: 1,2,3,5,6,8,4,3,9
    @Test
    public void testCobreArco3_9_() {
        NovaLinha nl = new NovaLinha();
        String ret = nl.collapseNewlines("a");
        assertEquals("a", ret);
    }
    
    //1,2,3,5,6,7,4,3,9
    @Test
    public void testCobreArco6_7() {
        NovaLinha nl = new NovaLinha();
        String ret = nl.collapseNewlines("\n");
        assertEquals("", ret);
    }
    
    //1,2,3,5,6,8,4,3,5,6,7,8,4,3,5,6,8,4,3,9
    @Test
    public void testCobreArco7_8() {
        NovaLinha nl = new NovaLinha();
        String ret = nl.collapseNewlines("a\nb");
        assertEquals("a\nb", ret);
    } 
    
    @Test
    public void testOQueFaz() {
        NovaLinha nl = new NovaLinha();
        String ret = nl.collapseNewlines("a\n\nb");
        //System.out.println("a\n\nb");
        //System.out.println(ret);
        assertEquals("a\nb", ret);
    }    
}
