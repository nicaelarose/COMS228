package edu.iastate.cs228.hw1;
import static org.junit.Assert.*;
import java.io.FileNotFoundException;
import org.junit.Test;

/**
 * 
 * @author nicaela
 *
 * Test class for Grass
 */
public class GrassTest 
{
	@Test
	public void grassTest() 
	{
		Plain plain = null;
		try {
			plain = new Plain("GrassTest.txt");
		}
		catch (FileNotFoundException f) {
			f.printStackTrace();
		}

		Plain newP = new Plain(3);
		Living next = plain.grid[1][1].next(newP);
		assertEquals(next.who(), State.GRASS);
	}	
}
