package edu.iastate.cs228.hw1;

/**
 *  
 * @author nicaelab
 *
 */

/**
 * A fox eats rabbits and competes against a badger. 
 */
public class Fox extends Animal 
{
	/**
	 * Constructor 
	 * @param p: plain
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Fox (Plain p, int r, int c, int a) 
	{
		this.plain = p;
		this.row = r;
		this.column = c;
		this.age = a;
	}
		
	/**
	 * A fox occupies the square. 	 
	 */
	public State who()
	{
		return State.FOX; 
	}
	
	/**
	 * A fox dies of old age or hunger, or from attack by numerically superior badgers. 
	 * @param pNew     plain of the next cycle
	 * @return Living  life form occupying the square in the next cycle. 
	 */
	public Living next(Plain pNew)
	{
		int[] pop = new int[5];
		this.census(pop);
		
		if (myAge() == FOX_MAX_AGE)
		{
			pNew.grid[this.row][this.column] = new Empty(pNew, this.row, this.column);
		}
		else if (pop[BADGER] > pop[FOX])
		{
			pNew.grid[this.row][this.column] = new Badger(pNew, this.row, this.column, 0);
		}
		else if (pop[BADGER] + pop[FOX] > pop[RABBIT])
		{
			pNew.grid[this.row][this.column] = new Empty(pNew, this.row, this.column);
		}
		else
		{
			this.age++;
			pNew.grid[this.row][this.column] = new Fox(pNew, this.row, this.column, myAge());
		}
		return pNew.grid[this.row][this.column]; 
	}
}