package edu.iastate.cs228.hw1;

/**
 *  
 * @author nicaelab
 *
 */

/** 
 * Empty squares are competed by various forms of life.
 */
public class Empty extends Living 
{
	public Empty (Plain p, int r, int c) 
	{
		this.plain = p;
		this.row = r;
		this.column = c;
	}
	
	public State who()
	{
		return State.EMPTY; 
	}
	
	/**
	 * An empty square will be occupied by a neighboring Badger, Fox, Rabbit, or Grass, or remain empty. 
	 * @param pNew     plain of the next life cycle.
	 * @return Living  life form in the next cycle.   
	 */
	public Living next(Plain pNew)
	{
		int[] pop = new int[5];
		this.census(pop);
		
		if (pop[RABBIT] > 1)
		{
			pNew.grid[this.row][this.column] = new Rabbit(pNew, this.row, this.column, 0);
		}
		else if (pop[FOX] > 1)
		{
			pNew.grid[this.row][this.column] = new Fox(pNew, this.row, this.column, 0);
		}
		else if (pop[BADGER] > 1)
		{
			pNew.grid[this.row][this.column] = new Badger(pNew, this.row, this.column, 0);
		}
		else if (pop[GRASS] >= 1)
		{
			pNew.grid[this.row][this.column] = new Grass(pNew, this.row, this.column);
		}
		else
		{
			pNew.grid[this.row][this.column] = new Empty(pNew, this.row, this.column);
		}
		
		return pNew.grid[this.row][this.column]; 
	}
}
