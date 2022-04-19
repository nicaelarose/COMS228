package edu.iastate.cs228.hw1;

/**
 *  
 * @author nicaelab
 *
 */

/*
 * A rabbit eats grass and lives no more than three years.
 */
public class Rabbit extends Animal 
{	
	/**
	 * Creates a Rabbit object.
	 * @param p: plain  
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Rabbit (Plain p, int r, int c, int a) 
	{
		this.plain = p;
		this.row = r;
		this.column = c;
		this.age = a;
	}
		
	// Rabbit occupies the square.
	public State who()
	{
		return State.RABBIT;
	}
	
	/**
	 * A rabbit dies of old age or hunger. It may also be eaten by a badger or a fox.  
	 * @param pNew     plain of the next cycle 
	 * @return Living  new life form occupying the same square
	 */
	public Living next(Plain pNew)
	{
		int[] pop = new int[5];
		this.census(pop);
		
		if (myAge() == RABBIT_MAX_AGE || pop[GRASS] == 0)
		{
			pNew.grid[this.row][this.column] = new Empty(pNew, this.row, this.column);
		}
		else if ((pop[FOX] + pop[BADGER] >= pop[RABBIT]) && (pop[FOX] > pop[BADGER]))
		{
			pNew.grid[this.row][this.column] = new Fox(pNew, this.row, this.column, 0);
		}
		else if (pop[BADGER] > pop[RABBIT])
		{
			pNew.grid[this.row][this.column] = new Badger(pNew, this.row, this.column, 0);
		}
		else
		{
			this.age++;
			pNew.grid[this.row][this.column] = new Rabbit(pNew, this.row, this.column, myAge());
		}
		
		return pNew.grid[this.row][this.column];
			
	}
}
