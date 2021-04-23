package mutantes.ex11;

public class Mutant3 {
	public int contarA(String word) {
		int contador = 0;
		for (int i = 0; i < word.length() - 1; i++) {  // add -1 to conditional
			if (word.charAt(i) == 'a' || word.charAt(i) == 'A')
				contador++;
		}
		
		return contador;
	}
}
