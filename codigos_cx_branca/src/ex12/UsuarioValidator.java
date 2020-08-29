package ex12;

public class UsuarioValidator {
	private UsuarioDAO usuarioDao;
	private SenhaValidator senhaValidator;

	public UsuarioValidator(UsuarioDAO usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public void setSenhaValidator(SenhaValidator senhaValidator) {
		this.senhaValidator = senhaValidator;
	}

	public boolean ehUsuarioValido(Usuario u) throws Exception {
		/*1*/if (u.getNome().length() <= 3)
			/*2*/throw new Exception("nome do usuario precisa de pelo menos 3 caracteres");
		
		/*3*/if (!u.getSenha().equals(u.getSenhaConfirmada()))
			/*4*/throw new Exception("senhas diferentes");
		
		/*5*/if (usuarioDao.existe(u.getNome()))
			/*6*/throw new Exception("usuario ja existe");
		
		/*7*/if (senhaValidator.verificar(u.getSenha()))
			/*8*/throw new Exception("senha invalida");
		
		/*9*/String nome = u.getNome();
		/*9*/boolean isValid = true;
		for (/*10*/int i = 0; /*11*/i < nome.length(); /*12*/i++) {
			/*13*/char atual = nome.charAt(i);
			if (/*14*/!Character.isAlphabetic(atual) && /*15*/!Character.isDigit(atual))
				/*16*/isValid = false;
		}
		/*17*/return isValid;
	}
}
