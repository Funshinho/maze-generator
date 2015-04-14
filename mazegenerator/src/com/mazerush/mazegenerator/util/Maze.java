package com.mazerush.mazegenerator.util;

import java.util.Arrays;

/**
 * Representation of the maze
 * 
 * @author funshinho
 */
public class Maze {

	/** Matrix of boolean representing the horizontal walls */
	private boolean[][] horizontalWalls;

	/** Matrix of boolean representing the vertical walls */
	private boolean[][] verticalWalls;

	/** Matrix of boolean representing the cells */
	private boolean[][] grid;

	/** The maze width */
	private int width;

	/** The maze height */
	private int height;

	/**
	 * Default constructor
	 * 
	 * @param width
	 *            the maze grid width
	 * @param height
	 *            the maze grid height
	 */
	public Maze(int width, int height) {

		this.width = width;
		this.height = height;

		this.horizontalWalls = new boolean[width][height + 1];
		this.verticalWalls = new boolean[width + 1][height];
		this.grid = new boolean[width][height];

		// Init maze
		for (int i = 0; i < width; i++) {
			Arrays.fill(this.horizontalWalls[i], true);
		}
		for (int i = 0; i <= width; i++) {
			Arrays.fill(this.verticalWalls[i], true);
		}
		for (int i = 0; i < width; i++) {
			Arrays.fill(this.grid[i], false);
		}
	}

	/**
	 * Get the width
	 * 
	 * @return the width
	 */
	public int getWidth() {
		return this.width;
	}

	/**
	 * Set the width
	 * 
	 * @param width
	 *            the width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Get the height
	 * 
	 * @return the height
	 */
	public int getHeight() {
		return this.height;
	}

	/**
	 * Set the height
	 * 
	 * @param height
	 *            the height
	 */
	public void setHeight(int height) {
		this.width = height;
	}

	/**
	 * Get a horizontal wall
	 * 
	 * @param x
	 *            the x position (from 0 to width)
	 * @param y
	 *            the y position (from 0 to height+1)
	 * @return true if there is a wall, false otherwise
	 */
	public boolean getHorizontalWall(int x, int y) {
		return this.horizontalWalls[x][y];
	}

	/**
	 * Get a vertical wall
	 * 
	 * @param x
	 *            the x position (from 0 to width+1)
	 * @param y
	 *            the y position (from 0 to height)
	 * @return true if there is a wall, false otherwise
	 */
	public boolean getVerticalWall(int x, int y) {
		return this.verticalWalls[x][y];
	}

	/**
	 * Set a horizontal wall
	 * 
	 * @param x
	 *            the x position (from 0 to width)
	 * @param y
	 *            the y position (from 0 to height+1)
	 * @param b
	 *            true if there is a wall, false otherwise
	 */
	public void setHorizontalWall(int x, int y, boolean b) {
		this.horizontalWalls[x][y] = b;
	}

	/**
	 * Set a vertical wall
	 * 
	 * @param x
	 *            the x position (from 0 to width+1)
	 * @param y
	 *            the y position (from 0 to height)
	 * @param b
	 *            true if there is a wall, false otherwise
	 */
	public void setVerticalWall(int x, int y, boolean b) {
		this.verticalWalls[x][y] = b;
	}

	/**
	 * Check if a cell was visited
	 * 
	 * @param x
	 *            the x position
	 * @param y
	 *            the y position
	 * @return true if the cell was visited, false otherwise
	 */
	public boolean isVisited(int x, int y) {
		return this.grid[x][y];
	}

	/**
	 * Set if a cell was visited or not
	 * 
	 * @param x
	 *            the x position
	 * @param y
	 *            the y position
	 * @param b
	 *            the visited status
	 */
	public void setVisited(int x, int y, boolean b) {
		this.grid[x][y] = b;
	}

	/**
	 * Utility method to print the maze on the output console
	 */
	public void print() {
		
		for (int y = 0; y < height; y++) {

			// Print a row of horizontal walls
			for (int x = 0; x < this.width; x++) {
				System.out.print("*");
				System.out.print(this.getHorizontalWall(x, y) ? "--" : "  ");
			}
			System.out.println("*");

			// Print a row of vertical walls
			for (int x = 0; x < this.width; x++) {
				System.out.print(this.getVerticalWall(x, y) ? "|" : " ");
				System.out.print("  ");
			}
			System.out.println(this.getVerticalWall(width, y) ? "|" : " ");
		}

		// Print the last row of horizontal walls
		for (int x = 0; x < width; x++) {
			System.out.print("*");
			System.out.print(this.getHorizontalWall(x, height) ? "--" : "  ");
		}
		System.out.println("*");
	}

}
