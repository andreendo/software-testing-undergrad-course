package ex08;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmissarioTestResposta {
	ServidorDeEmail servidorEmailMock;
	UsuarioDAO usuarioDAOMock;
	Criptografia criptoMock;
	Emissario emissario;
	
	@BeforeEach
	void beforeEach() {
		servidorEmailMock = mock(ServidorDeEmail.class);
		usuarioDAOMock = mock(UsuarioDAO.class);
		criptoMock = mock(Criptografia.class);
		
		emissario = new Emissario(usuarioDAOMock, servidorEmailMock);
		emissario.setCriptografia(criptoMock);
	}
	
	// 1, 2
	@Test
	void testNomesNaoInformados() {
		assertEquals("nomes nao informados", emissario.enviarPara(null));
	}

	// 1, 3, 5
	@Test
	void testNaoHaUsuarios01() {
		when(usuarioDAOMock.getAllUsuarios())
			.thenReturn(null);
		
		ArrayList<String> nomes = new ArrayList<String>();
		nomes.add("joao");
		assertEquals("nao ha usuarios", emissario.enviarPara(nomes));
	}	
	
	// 1, 3, 4, 5
	@Test
	void testNaoHaUsuarios02() {
		when(usuarioDAOMock.getAllUsuarios())
			.thenReturn(new ArrayList<Usuario>());
		
		ArrayList<String> nomes = new ArrayList<String>();
		nomes.add("joao");
		assertEquals("nao ha usuarios", emissario.enviarPara(nomes));
	}
	
	// 1, 3, 4, 6, 7, 8, 9, 10, 11, 7, 13, 14
	@Test
	void testSucessoUmUsuarioUmNome() {
		var usuariosNoBd = new ArrayList<Usuario>();
		var usuario = new Usuario();
		usuario.setNome("joao");
		usuario.setEmail("joao@mail.com");
		usuariosNoBd.add(usuario);
		
		when(usuarioDAOMock.getAllUsuarios())
			.thenReturn(usuariosNoBd);
		
		when(criptoMock.criptografar(anyString()))
			.thenReturn("$$??");
		
		when(servidorEmailMock.enviar(anyString()))
			.thenReturn(true);
		
		ArrayList<String> nomes = new ArrayList<String>();
		nomes.add("joao");
		assertEquals("mensagens enviadas", emissario.enviarPara(nomes));
	}
	
	// 1, 3, 4, 6, 7, 8, 9, 10, 12
	@Test
	void testServidorEmailOffline() {
		var usuariosNoBd = new ArrayList<Usuario>();
		var usuario = new Usuario();
		usuario.setNome("joao");
		usuario.setEmail("joao@mail.com");
		usuariosNoBd.add(usuario);
		
		when(usuarioDAOMock.getAllUsuarios())
			.thenReturn(usuariosNoBd);
		
		when(criptoMock.criptografar(anyString()))
			.thenReturn("$$??");
		
		when(servidorEmailMock.enviar(anyString()))
			.thenReturn(false);
		
		ArrayList<String> nomes = new ArrayList<String>();
		nomes.add("joao");
		assertEquals("servidor de email offline", emissario.enviarPara(nomes));
	}
	
	// 1, 3, 4, 6, 7, 8, 9, 8, 7, 13, 15
	@Test
	void testUsuarioNaoEncontrado() {
		var usuariosNoBd = new ArrayList<Usuario>();
		var usuario = new Usuario();
		usuario.setNome("joao");
		usuario.setEmail("joao@mail.com");
		usuariosNoBd.add(usuario);
		
		when(usuarioDAOMock.getAllUsuarios())
			.thenReturn(usuariosNoBd);
		
		when(criptoMock.criptografar(anyString()))
			.thenReturn("$$??");
		
		when(servidorEmailMock.enviar(anyString()))
			.thenReturn(false);
		
		ArrayList<String> nomes = new ArrayList<String>();
		nomes.add("maria");
		assertEquals("usuarios nao encontrados", emissario.enviarPara(nomes));
	}	
}
