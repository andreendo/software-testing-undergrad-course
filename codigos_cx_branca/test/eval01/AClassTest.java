package eval01;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AClassTest {

	Coder1 c1Mock;
	Coder2 c2Mock;
	Coder3 c3Mock;
	AClass a;
	
	@BeforeEach
	void before() {
		c1Mock = mock(Coder1.class);
		c2Mock = mock(Coder2.class);
		c3Mock = mock(Coder3.class);
		a = new AClass(c1Mock, c2Mock, c3Mock);
	}
	
	@Test
	void test1() {
		assertEquals("INVALID", a.cifrar(null));
		assertEquals("INVALID", a.cifrar(new ArrayList<String>()));
		
		var arr = new ArrayList<String>();
		arr.add("STOP");
		assertEquals("INVALID", a.cifrar(arr));
	}

	@Test
	void test2() {
		when(c1Mock.m1(any())).thenReturn(true);
		when(c2Mock.m2(any())).thenReturn(true);
		
		var arr = new ArrayList<String>();
		arr.add("some");
		assertEquals("C1-C2", a.cifrar(arr));
	}	
	
	@Test
	void test3() {
		when(c1Mock.m1(any())).thenReturn(false);
		when(c2Mock.m2(any())).thenReturn(false);
		
		var arr = new ArrayList<String>();
		arr.add("HI");
		arr.add("HI");
		assertEquals("2 OR MORE HIs", a.cifrar(arr));
	}	
	
	@Test
	void test4() {
		when(c1Mock.m1(any())).thenReturn(true);
		when(c2Mock.m2(any())).thenReturn(false);
		when(c3Mock.m3()).thenReturn(0);
		
		var arr = new ArrayList<String>();
		arr.add("UOU");
		arr.add("NO");
		assertEquals("UOU", a.cifrar(arr));
	}	
	
	@Test
	void test5() {
		when(c1Mock.m1(any())).thenReturn(true);
		when(c2Mock.m2(any())).thenReturn(false);
		when(c3Mock.m3()).thenReturn(3);
		
		var arr = new ArrayList<String>();
		arr.add("UOU");
		arr.add("NO");
		assertEquals("-UOU-UOU-UOU", a.cifrar(arr));
	}	
	
}
