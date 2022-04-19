package edu.iastate.cs228.hw1;
import static org.junit.Assert.*;
import java.io.FileNotFoundException;
import org.junit.Test;

/**
 * 
 * @author nicaela
 * 
 * Test class for Empty
 */
public class EmptyTest 
{
	@Test
	public void emptyTest() 
	{
		Plain plain = null;
		try {
			plain = new Plain("EmptyTest.txt");
		}
		catch (FileNotFoundException f) {
			f.printStackTrace();
		}

		Plain newP = new Plain(3);
		Living next = plain.grid[0][1].next(newP);
		assertEquals(next.who(), State.RABBIT);
		assertEquals(((Animal) next).myAge(), 0);
	}

}
