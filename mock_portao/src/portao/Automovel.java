package portao;

public class Automovel {

	private String placa, proprietario;
	
	public Automovel(String placa, String proprietario) {
		this.placa = placa;
		this.proprietario = proprietario;
	}
	
	public String getProprietario() {
		return proprietario;
	}

	public String getPlaca() {
		return placa;
	}
}
