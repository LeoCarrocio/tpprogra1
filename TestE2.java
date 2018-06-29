
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestE2 {

	ABB abBalanceado, abVacio, abDesbalanceado , ABBalumnosDesbalanceado ;

	@Before

  public void setUp() throws Exception {
	abVacio =new ABB();
	abDesbalanceado = new ABB();
	abDesbalanceado.insertar(5);
	abDesbalanceado.insertar(3);
	abDesbalanceado.insertar(1);
	abBalanceado = new ABB();
	abBalanceado.insertar(8);
	abBalanceado.insertar(3);
	abBalanceado.insertar(10);
	abBalanceado.insertar(1);
	abBalanceado.insertar(6);
	abBalanceado.insertar(4);
	abBalanceado.insertar(7);
	abBalanceado.insertar(14);
	abBalanceado.insertar(9);

	
	ABBalumnosDesbalanceado = new ABB();
	ABBalumnosDesbalanceado.insertar(1000);
	ABBalumnosDesbalanceado.insertar(1);
	ABBalumnosDesbalanceado.insertar(2);
	
	
	
	}
@Test
public void testBalanceado()
{
assertTrue(abBalanceado.balanceado());
assertTrue(abVacio.balanceado());
assertFalse(abDesbalanceado.balanceado());
}
//@Test
//public void testRebalancear()
//{
//abDesbalanceado.rebalancear();
//assertTrue(abDesbalanceado.balanceado());
//}
@Test
public void testIesimo() 
{
assertEquals(abBalanceado.iesimo(0), new Integer(1));
assertEquals(abBalanceado.iesimo(5), new Integer(8));
assertEquals(abBalanceado.iesimo(8), new Integer(14));
boolean thrown = false;
try {
abBalanceado.iesimo(88);
} catch (Exception e
) {
thrown = true;
}
assertTrue(thrown);
}
@Test
public void testIrep() {
assertTrue(abVacio.irep());
assertTrue(abDesbalanceado.irep());
assertTrue(abBalanceado.irep());
abBalanceado.romperIrep();
assertFalse(abBalanceado.irep());
}


@Test
public void testBalanceado2()
{

assertFalse(ABBalumnosDesbalanceado.balanceado());
}

@Test
public void testIrep2() {
assertTrue(ABBalumnosDesbalanceado.irep());

}

}