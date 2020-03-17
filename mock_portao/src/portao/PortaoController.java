package portao;

/**
 *
 * @author andreendo
 */
public class PortaoController {

	AutomovelDAO automovelDao;
	Display display;
	Cancela cancela;
	RegistroEntradaDao registroEntradaDao;

	public void setAutomovelDao(AutomovelDAO automovelDao) {
		this.automovelDao = automovelDao;
	}

	public void setCancela(Cancela cancela) {
		this.cancela = cancela;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}

	public void setRegistroEntradaDao(RegistroEntradaDao registroEntradaDao) {
		this.registroEntradaDao = registroEntradaDao;
	}

	public boolean abrir(String tag) {
		display.limpar();
		if (tag.equals("ERRO")) {
			display.mostrarMsg("Automovel nao possui TAG. Por favor, voltar!");
			return false;
		} else {
			Automovel auto = automovelDao.getByTag(tag);
			if (auto != null) {
				display.mostrarMsg("Bem-Vindo, " + auto.getProprietario() + "!");
				cancela.levantar();
				registroEntradaDao.registrarEntradaAgora(auto.getPlaca(), auto.getProprietario());
				return true;
			} else {
				display.mostrarMsg("TAG desconhecida. Por favor, voltar!");
				return false;
			}
		}
	}
}