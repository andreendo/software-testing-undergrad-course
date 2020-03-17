package mockextra.ex2;

/**
 *
 * @author andreendo
 */
public class Empregado {
    private long id;
    private String primeiroNome;
    private String sobrenome;

    public Empregado() { 
    }
    
    public Empregado(long id, String primeiroNome, String sobrenome) {
        this.id = id;
        this.primeiroNome = primeiroNome;
        this.sobrenome = sobrenome;
    }
    
    public String getNomeCompleto() {
        return getPrimeiroNome() + " " + getSobrenome();
    }    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
}
