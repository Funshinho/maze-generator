package com.mazerush.mazegenerator;

import com.mazerush.mazegenerator.util.Maze;

/**
 * Test class for the maze generator
 * 
 * @author funshinho
 */
public class MazeGeneratorTest {

	/**
	 * Main method
	 * 
	 * @param args  the arguments
	 */
	public static void main(String[] args) {

		// The maze will be a 6*6 grid
		int width = 6;
		int height = width;
		
		System.out.println("Start maze generation, size : " + width + "*" + height + " cells");

		// Generate maze
		Maze maze = MazeGenerator.getInstance().generateMaze(width, height);
		
		// Print maze
		maze.print();
		
		System.out.println("Maze generation done ! ");

	}

}
