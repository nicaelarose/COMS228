package edu.iastate.cs228.hw1;

/**
 *  
 * @author nicaelab
 *
 */

/**
 * Grass remains if more than rabbits in the neighborhood; otherwise, it is eaten. 
 *
 */
public class Grass extends Living 
{
	public Grass (Plain p, int r, int c) 
	{
		this.plain = p;
		this.row = r;
		this.column = c;
	}
	
	public State who()
	{ 
		return State.GRASS; 
	}
	
	/**
	 * Grass can be eaten out by too many rabbits. Rabbits may also multiply fast enough to take over Grass.
	 */
	public Living next(Plain pNew)
	{
		int[] pop = new int[5];
		this.census(pop);
		
		if (pop[RABBIT] >= (3 * pop[GRASS]))
		{
			pNew.grid[this.row][this.column] = new Empty(pNew, this.row, this.column);
		}
		else if (pop[RABBIT] >= 3)
		{
			pNew.grid[this.row][this.column] = new Rabbit(pNew, this.row, this.column, 0);
		}
		else
		{
			pNew.grid[this.row][this.column] = new Grass(pNew, this.row, this.column);
		}
		
		return pNew.grid[this.row][this.column];
	}
}