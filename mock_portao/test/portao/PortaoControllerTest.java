package portao;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

class PortaoControllerTest {

	@Test
	void testAutomovelSemTag() {
		PortaoController controller = new PortaoController();
		Display displayMock = mock(Display.class);
		controller.setDisplay(displayMock);

		assertFalse(controller.abrir("ERRO"));

		verify(displayMock).limpar();
		verify(displayMock).mostrarMsg("Automovel nao possui TAG. Por favor, voltar!");
	}

	@Test
	void testAutomovelComTagValida() {
		PortaoController controller = new PortaoController();
		Display displayMock = mock(Display.class);
		controller.setDisplay(displayMock);

		AutomovelDAO automovelDaoMock = mock(AutomovelDAO.class);
		controller.setAutomovelDao(automovelDaoMock);
		when(automovelDaoMock.getByTag("ABCS"))
			.thenReturn(new Automovel("ACX8899", "Joao da Silva"));

		RegistroEntradaDao registroDaoMock = mock(RegistroEntradaDao.class);
		controller.setRegistroEntradaDao(registroDaoMock);

		Cancela cancelaMock = mock(Cancela.class);
		controller.setCancela(cancelaMock);
		
		assertTrue(controller.abrir("ABCS"));

		verify(displayMock).limpar();
		verify(displayMock).mostrarMsg("Bem-Vindo, Joao da Silva!");
		verify(cancelaMock).levantar();
		verify(registroDaoMock).registrarEntradaAgora(any(), any());
	}
}
