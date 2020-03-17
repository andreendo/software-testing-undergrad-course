package mockextra.ex1;

/**
 *
 * @author andreendo
 */
public class Avaliador {
    private BD bd;

    public void setBd(BD bd) {
        this.bd = bd;
    }
    
    public boolean ehClienteArriscado(Cliente cliente) {
        //objeto cliente pode conter apenas o id
        //este metodo completa os demais atrbitutos com dados do BD
        bd.completarDados(cliente);
        
        if(cliente.getRisco() >= 10)
            return true;
        
        return false;
    }
}
