package edu.iastate.cs228.hw1;
import static org.junit.Assert.*;
import java.io.FileNotFoundException;
import org.junit.Test;

/**
 * 
 * @author nicaela
 *
 * Test class for Rabbit
 */
public class RabbitTest 
{
	@Test
	public void rabbitTest() 
	{
		Plain plain = null;
		try {
			plain = new Plain("RabbitTest.txt");
		}
		catch (FileNotFoundException f) {
			f.printStackTrace();
		}

		Plain newP = new Plain(3);
		Living next = plain.grid[1][1].next(newP);
		assertEquals(next.who(), State.EMPTY);
	}
}
