package pce.avl.ex12;

public class Calculadora {
	private CustoDAO custoDao;

	public Calculadora(CustoDAO custoDao) {
		this.custoDao = custoDao;
	}

	public int calcularFrete(String regiao, int peso) throws Exception {
		// nao precisa implementar
		return 0;
	}
}