package example;

public class Operacoes {
	
	public int soma(int num1, int num2) {
		return num1 + num2;
	}
	
	public int somatoria(int valor) {
		int soma = 0, i = 0;
		while(i != valor) {	
			soma += i;
			i++;
		}
		return soma;
	}
}
