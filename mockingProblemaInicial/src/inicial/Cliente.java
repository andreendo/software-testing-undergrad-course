package inicial;

/**
 *
 * @author andreendo
 * 
 * Traduzido de https://examples.javacodegeeks.com/core-java/mockito/mockito-verify-example/
 */
public class Cliente {
    private GerenteDeContas gerenteDeContas;

    /**
     * Metodo sob teste
     */
    public long efetuarSaque(long valor) 
            throws SemFundosException {
        Conta conta = gerenteDeContas.acharConta(this);
        long saldo = gerenteDeContas.recuperarSaldo(conta);
        if(saldo < valor)
            throw new SemFundosException();
        
        gerenteDeContas.efetuarSaque(conta, valor);
        return gerenteDeContas.recuperarSaldo(conta);
    }
    
    public void setGerenteDeContas(GerenteDeContas gerenteDeContas) {
        this.gerenteDeContas = gerenteDeContas;
    }
}
