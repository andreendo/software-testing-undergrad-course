package exemplo1.pilharestrita;

public class PilhaRestrita {

	private String array[];
	private int posicao = 0;

	public PilhaRestrita(int tamanho) {
		array = new String[tamanho];
	}

	public void empilhar(String objeto) throws PilhaCheiaException {
		if (posicao >= array.length) {
			throw new PilhaCheiaException();
		}
		
		array[posicao] = objeto;
		posicao++;
	}

	public boolean vazia() {
		return posicao == 0;
	}

	public String desempilhar() throws PilhaVaziaException {
		if (vazia()) {
			throw new PilhaVaziaException();
		}
		
		posicao--;
		String objeto = array[posicao];
		array[posicao] = null;
		return objeto;
	}
}
