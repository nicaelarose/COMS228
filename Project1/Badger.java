package edu.iastate.cs228.hw1;

/**
 *  
 * @author nicaela
 *
 */

/**
 * A badger eats a rabbit and competes against a fox. 
 */
public class Badger extends Animal
{
	/**
	 * Constructor 
	 * @param p: plain
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Badger (Plain p, int r, int c, int a) 
	{
		this.plain = p;
		this.row = r;
		this.column = c;
		this.age = a;
	}
	
	/**
	 * A badger occupies the square. 	 
	 */
	public State who()
	{
		return State.BADGER;
	}
	
	/**
	 * A badger dies of old age or hunger, or from isolation and attack by a group of foxes. 
	 * @param pNew     plain of the next cycle
	 * @return Living  life form occupying the square in the next cycle. 
	 */
	public Living next(Plain pNew)
	{
		// See Living.java for an outline of the function. 
		// See the project description for the survival rules for a badger. 
		int[] pop = new int[5];
		this.census(pop);
		if (myAge() == BADGER_MAX_AGE)
		{
			pNew.grid[this.row][this.column] = new Empty(pNew, this.row, this.column);
		}
		else if (pop[BADGER] == 1 && pop[FOX] > 1)
		{
			pNew.grid[this.row][this.column] = new Fox(pNew, this.row, this.column, 0);
		}
		else if (pop[BADGER] + pop[FOX] > pop[RABBIT])
		{
			pNew.grid[this.row][this.column] = new Empty(pNew, this.row, this.column);
		}
		else
		{
			this.age++;
			pNew.grid[this.row][this.column] = new Badger(pNew, this.row, this.column, myAge());
		}
		
		return pNew.grid[this.row][this.column]; 
	}
}