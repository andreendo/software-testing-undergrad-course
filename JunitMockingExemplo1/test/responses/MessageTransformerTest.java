package responses;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import mock.Helper;
import mock.Logger;
import mock.MessageTransformer;

class MessageTransformerTest {

	@Test
	void testSuccess() {
		var helperMock = mock(Helper.class);
		var loggerMock = mock(Logger.class);

		String[] censWords = { "KKKK", "abcd", "xyz" };
		when(helperMock.getCensoredWords())
			.thenReturn(censWords);

		when(loggerMock.logTransformation(anyString(), anyString()))
			.thenReturn(true);

		MessageTransformer transformer = new MessageTransformer(loggerMock, helperMock);
		var message = transformer.transform("As palavras KKKK e abcd foram removidas");
		assertEquals("As palavras ??? e ??? foram removidas", message);
	}

}
