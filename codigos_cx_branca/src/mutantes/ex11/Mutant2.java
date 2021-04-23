package mutantes.ex11;

public class Mutant2 {
	public int contarA(String word) {
		int contador = 0;
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == 'a' || word.charAt(i) == 'A')
				contador = contador + 1;  // contador++ => contador = contador + 1
		}
		
		return contador;
	}
}
