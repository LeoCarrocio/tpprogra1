import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.jupiter.api.Test;
	

public class TestEj1 {
	private Jenga jenga1;
	@Before
	public void setUp() {
	jenga1 = new Jenga(10,"j0","j1");
//	jenga2 = new Jenga(10,"jugador0","jugador1");
	}
	
	
	@Test
	public void test1() {
	int alturaInicial = jenga1.altura();
	jenga1.jugar();
//	jenga1.jugar();
//	jenga1.jugar();
	//System.out.println(alturaInicial +","+ jenga1.altura());
	// deberia cambiar la altura
	assertTrue(alturaInicial != jenga1.altura());
	}
//	@Test
//	public void test2() 
//	{
//	int nivel = jenga2.torre.primerNivelPosible();
//	jenga2.torre.quitar(nivel, 0);
//	jenga2.torre.quitar(nivel,1);
//	jenga2.torre.quitar(nivel,2);
//	System.out.println(jenga2.ganador);
//	// deberia haberse caido el jenga!
//	assertTrue(!jenga2.ganador().equals(""));
//	}
	}


