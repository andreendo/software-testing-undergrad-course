package exemplo.pessoa;

/**
 *
 * @author andreendo
 */
public class Pessoa {

    int codigo, idade;
    String nome;

    //getters and setters
    public int getCodigo() {
        return codigo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}