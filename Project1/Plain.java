package edu.iastate.cs228.hw1;

/**
 *  
 * @author nicaelab
 *
 */

import java.io.File; 
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner; 
import java.util.Random; 

/**
 * 
 * The plain is represented as a square grid of size width x width. 
 *
 */
public class Plain 
{
	private int width; // grid size: width X width 
	
	public Living[][] grid; 
	
	/**
	 *  Default constructor reads from a file 
	 */
	public Plain(String inputFileName) throws FileNotFoundException
	{		
        // TODO 
		// 
		// Assumption: The input file is in correct format. 
		// 
		// You may create the grid plain in the following steps: 
		// 
		// 1) Reads the first line to determine the width of the grid.
		// 
		// 2) Creates a grid object. 
		// 
		// 3) Fills in the grid according to the input file. 
		// 
		// Be sure to close the input file when you are done. 
	}
	
	/**
	 * Constructor that builds a w x w grid without initializing it. 
	 * @param width  the grid 
	 */
	public Plain(int w)
	{
		this.width = w;
		grid = new Living[width][width];
	}
	
	
	public int getWidth()
	{ 
		return width;
	}
	
	/**
	 * Initialize the plain by randomly assigning to every square of the grid  
	 * one of BADGER, FOX, RABBIT, GRASS, or EMPTY.  
	 * 
	 * Every animal starts at age 0.
	 */
	public void randomInit()
	{
		Random generator = new Random(); 
		 
		for (int r = 0; r < grid.length; r++)
		{
			for (int c = 0; c < grid[r].length; c++)
			{
				switch (generator.nextInt(5))
				{
				case 0:
					grid[r][c] = new Empty(this, r, c);
					break;
				case 1:
					grid[r][c] = new Grass(this, r, c);
					break;
				case 2:
					grid[r][c] = new Badger(this, r, c, 0);
					break;
				case 3:
					grid[r][c] = new Fox(this, r, c, 0);
					break;
				case 4:
					grid[r][c] = new Rabbit(this, r, c, 0);
					break;
				}
			}
		}
	}
	
	
	/**
	 * Output the plain grid. For each square, output the first letter of the living form
	 * occupying the square. If the living form is an animal, then output the age of the animal 
	 * followed by a blank space; otherwise, output two blanks.  
	 */
	public String toString()
	{
		String outputGrid = "";
		for (int r = 0; r < width; r++)
		{
			for (int c = 0; c < width; c++)
			{
				switch (grid[r][c].who())
				{
				case EMPTY:
					outputGrid = outputGrid + "E ";
					break;
				case GRASS:
					outputGrid = outputGrid + "G ";
					break;
				case BADGER:
					outputGrid = outputGrid + "B" + ((Animal) grid[r][c]).myAge();
					break;
				case FOX:
					outputGrid = outputGrid + "F" + ((Animal) grid[r][c]).myAge();
					break;
				case RABBIT:
					outputGrid = outputGrid + "R" + ((Animal) grid[r][c]).myAge();
					break;
				}
				outputGrid = outputGrid + " ";
			}
			outputGrid = (r < width - 1) ? outputGrid + "\n" : outputGrid;
		}
		return outputGrid;
	}
	

	/**
	 * Write the plain grid to an output file.  Also useful for saving a randomly 
	 * generated plain for debugging purpose. 
	 * @throws FileNotFoundException
	 */
	public void write(String outputFileName) throws FileNotFoundException
	{
		// 
		// 1. Open the file. 
		// 
		// 2. Write to the file. The five life forms are represented by characters 
		//    B, E, F, G, R. Leave one blank space in between. Examples are given in
		//    the project description. 
		// 
		// 3. Close the file. 
		File file = new File(outputFileName);
		PrintWriter outputFile = new PrintWriter(file);
		outputFile.println(this.toString());
		outputFile.close();
	}			
}
