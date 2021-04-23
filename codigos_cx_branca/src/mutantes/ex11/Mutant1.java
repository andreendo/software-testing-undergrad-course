package mutantes.ex11;

public class Mutant1 {
	public int contarA(String word) {
		int contador = 0;
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == 'a' || word.charAt(i) == 'a') // 'A' => 'a'
				contador++;
		}
		
		return contador;
	}
}
