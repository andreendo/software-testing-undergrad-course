package ex12;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsuarioValidatorTest {
	UsuarioDAO usuarioDaoMock;
	SenhaValidator senhaValidMock;
	UsuarioValidator usuarioValid;

	@BeforeEach
	void before() {
		usuarioDaoMock = mock(UsuarioDAO.class);
		senhaValidMock = mock(SenhaValidator.class);
		usuarioValid = new UsuarioValidator(usuarioDaoMock);
		usuarioValid.setSenhaValidator(senhaValidMock);
	}

	// 1, 2
	@Test
	void testNomeUsuarioMenos3Caracteres() {
		Usuario u = new Usuario("ab", "senha", "senha");
		assertThrows(Exception.class, () -> {
			usuarioValid.ehUsuarioValido(u);
		});
	}

	// 1, 3, 5, 6
	@Test
	void testUsuarioJaExiste() {
		when(usuarioDaoMock.existe("admin")).thenReturn(true);

		Usuario u = new Usuario("admin", "senha", "senha");
		assertThrows(Exception.class, () -> {
			usuarioValid.ehUsuarioValido(u);
		});
	}
}
