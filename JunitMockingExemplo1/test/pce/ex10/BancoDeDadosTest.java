package pce.ex10;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class BancoDeDadosTest {
	VerificadorDeCodigos verificadorMock;
	
	@BeforeEach
	public void beforeEach() {
		verificadorMock = mock(VerificadorDeCodigos.class);
	}
	
	@Test
	void testSucesso() {
		when(verificadorMock.verificarCodigoDisciplina("IF55S"))
			.thenReturn(true);
		when(verificadorMock.verificarCodigoTurma("ES66"))
			.thenReturn(true);
		
		BancoDeDados bd = new BancoDeDados(verificadorMock);
		String res = bd.cadastrarTurma("IF55S", "ES66", 27);
		assertEquals("sucesso", res);
	}
	
	@Test
	void testCodigoDisciplinaInvalido() {
		when(verificadorMock.verificarCodigoDisciplina("IF6$$"))
			.thenReturn(false);
		when(verificadorMock.verificarCodigoTurma("ES66"))
			.thenReturn(true);
		
		BancoDeDados bd = new BancoDeDados(verificadorMock);
		String res = bd.cadastrarTurma("IF6$$", "ES66", 27);
		assertEquals("codigo de disciplina invalido", res);
	}
	
	@Test
	void testCodigoTurmaInvalido() {
		when(verificadorMock.verificarCodigoDisciplina("IF55S"))
			.thenReturn(true);
		when(verificadorMock.verificarCodigoTurma("4555"))
			.thenReturn(true);
		
		BancoDeDados bd = new BancoDeDados(verificadorMock);
		String res = bd.cadastrarTurma("IF55S", "4555", 27);
		assertEquals("codigo de turma invalido", res);
	}	
	
	@Test
	void testNumeroDeAlunosInvalidoMenorQue3() {
		when(verificadorMock.verificarCodigoDisciplina("IF55S"))
			.thenReturn(true);
		when(verificadorMock.verificarCodigoTurma("ES66"))
			.thenReturn(true);
		
		BancoDeDados bd = new BancoDeDados(verificadorMock);
		String res = bd.cadastrarTurma("IF55S", "ES66", 2);
		assertEquals("numero de alunos invalido", res);
	}
	
	@Test
	void testNumeroDeAlunosInvalidoMaiorQue44() {
		when(verificadorMock.verificarCodigoDisciplina("IF55S"))
			.thenReturn(true);
		when(verificadorMock.verificarCodigoTurma("ES66"))
			.thenReturn(true);
		
		BancoDeDados bd = new BancoDeDados(verificadorMock);
		String res = bd.cadastrarTurma("IF55S", "ES66", 56);
		assertEquals("numero de alunos invalido", res);
	}	
	
//	Valores limites
	
//	(“IF55S”, “ES66”, 3; “sucesso”)
//	(“IF55S”, “ES66”, 4; “sucesso”)
//	(“IF55S”, “ES66”, 44; “sucesso”)
//	(“IF55S”, “ES66”, 43; “sucesso”)
	@Test
	void testValoresLimitesSucesso() {
		when(verificadorMock.verificarCodigoDisciplina("IF55S"))
			.thenReturn(true);
		when(verificadorMock.verificarCodigoTurma("ES66"))
			.thenReturn(true);
		
		BancoDeDados bd = new BancoDeDados(verificadorMock);
		
		assertEquals("sucesso", bd.cadastrarTurma("IF55S", "ES66", 3));
		assertEquals("sucesso", bd.cadastrarTurma("IF55S", "ES66", 4));
		assertEquals("sucesso", bd.cadastrarTurma("IF55S", "ES66", 44));
		assertEquals("sucesso", bd.cadastrarTurma("IF55S", "ES66", 43));
	}	
	
	
	//(“IF55S”, “ES66”, 45; “numero de alunos invalido”)
	@Test
	void testNumeroDeAlunosInvalidoLimite() {
		when(verificadorMock.verificarCodigoDisciplina("IF55S"))
			.thenReturn(true);
		when(verificadorMock.verificarCodigoTurma("ES66"))
			.thenReturn(true);
		
		BancoDeDados bd = new BancoDeDados(verificadorMock);
		String res = bd.cadastrarTurma("IF55S", "ES66", 45);
		assertEquals("numero de alunos invalido", res);
	}	
	
}