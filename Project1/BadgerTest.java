package edu.iastate.cs228.hw1;

import static org.junit.Assert.assertEquals;


import java.io.FileNotFoundException;

import org.junit.Test;

/**
 * 
 * @author nicaela
 * 
 * Test class for Badger
 */
public class BadgerTest 
{
	//Testing Badger Constructor
	@Test
	public void testBadgerConstructor() 
	{
		Plain plain = new Plain(3);
		Badger badge = new Badger(plain, 1, 2, 3);
		assertEquals(badge.row, 1);
		assertEquals(badge.column, 2);
		assertEquals(badge.plain, plain);
		assertEquals(badge.age, 3);
	}

	@Test
	public void badgerTest() 
	{
		Plain plain = null;
		try {
			plain = new Plain("BadgerTest.txt");
		}
		catch (FileNotFoundException f) {
			f.printStackTrace();
		}
		Plain newP = new Plain(3);
		Living next = plain.grid[1][1].next(newP);
		assertEquals(next.who(), State.BADGER);
		assertEquals(((Animal) next).myAge(), 3);
	}
}
