package edu.iastate.cs228.hw1;

import java.io.FileNotFoundException;
import java.util.Scanner; 

/**
 *  
 * @author nicaelab
 *
 */

/**
 * 
 * The Wildlife class performs a simulation of a grid plain with
 * squares inhabited by badgers, foxes, rabbits, grass, or none. 
 *
 */
public class Wildlife 
{
	/**
	 * Update the new plain from the old plain in one cycle. 
	 * @param pOld  old plain
	 * @param pNew  new plain 
	 */
	public static void updatePlain(Plain pOld, Plain pNew)
	{
		// For every life form (i.e., a Living object) in the grid pOld, generate  
		// a Living object in the grid pNew at the corresponding location such that 
		// the former life form changes into the latter life form. 
		// 
		// Employ the method next() of the Living class. 
		for (int r = 0; r < pNew.grid.length; r++)
		{
			for (int c = 0; c < pNew.grid[r].length; c++)
			{
				pNew.grid[r][c] = pOld.grid[r][c].next(pNew);
			}
		}
	}
	
	/**
	 * Repeatedly generates plains either randomly or from reading files. 
	 * Over each plain, carries out an input number of cycles of evolution. 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException
	{	
		// Generate wildlife simulations repeatedly like shown in the 
		// sample run in the project description. 
		// 
		// 1. Enter 1 to generate a random plain, 2 to read a plain from an input
		//    file, and 3 to end the simulation. (An input file always ends with 
		//    the suffix .txt.)
		// 
		// 2. Print out standard messages as given in the project description. 
		// 
		// 3. For convenience, you may define two plains even and odd as below. 
		//    In an even numbered cycle (starting at zero), generate the plain 
		//    odd from the plain even; in an odd numbered cycle, generate even 
		//    from odd. 
		
		Plain even;   				 // the plain after an even number of cycles 
		Plain odd;                   // the plain after an odd number of cycles
		
		// 4. Print out initial and final plains only.  No intermediate plains should
		//    appear in the standard output.  (When debugging your program, you can 
		//    print intermediate plains.)
		// 
		// 5. You may save some randomly generated plains as your own test cases. 
		// 
		// 6. It is not necessary to handle file input & output exceptions for this 
		//    project. Assume data in an input file to be correctly formated. 
		Scanner sc = new Scanner(System.in);
		int trial = 1;
		int input = 0;
		
		System.out.println("Simulation of Wildlife of the Plain");
		System.out.println("keys: 1 (random plain) 2 (file input) 3 (exit)");
		
		while (input == 1 || input == 2 || (input == 0 && trial == 1))
		{
			int numCycles = 0;
			System.out.print("Trial " + trial + ": ");
			input = sc.nextInt();
			
			if (input == 1)
			{
				System.out.println("Random plain");
				System.out.println("Enter grid width: ");
				int gridWidth = sc.nextInt();
				even = new Plain(gridWidth);
				odd = new Plain(gridWidth);
				even.randomInit();
				while (numCycles <= 0)
				{
					System.out.println("Enter the number of cycles: ");
					numCycles = sc.nextInt();
				}
			}
			else if (input == 2)
			{
				System.out.println("Plain input from a file");
				System.out.println("File name: ");
				String fileName = sc.next();
				even = new Plain(fileName);
				odd = new Plain(even.getWidth());
				
				while (numCycles <= 0)
				{
					System.out.println("Enter the number of cycles: ");
					numCycles = sc.nextInt();
				}
			}
			else break;
			
			System.out.println("Initial plain:\n" + even.toString() + "\n");
			for (int i = 1; i <= numCycles; i++)
			{
				if (i % 2 == 0)
				{
					updatePlain(odd, even);
				}
				else
				{
					updatePlain(even, odd);
				}
			}
			if (numCycles % 2 == 0)
			{
				System.out.println("Final plain:\n" + even.toString() + "\n");
			}
			else
			{
				System.out.println("Final plain:\n" + odd.toString() + "\n");
			}
			trial++;
		}
		sc.close();
	}
}