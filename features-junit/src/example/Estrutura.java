package example;

public class Estrutura {
	public static BancoDeDados criarConexao() {
		return new BancoDeDados();
	}
	
	public static void fecharConexao(BancoDeDados bd) {
		
	}
	
	public static boolean executar(String comando) {
		return true;
	}
}
