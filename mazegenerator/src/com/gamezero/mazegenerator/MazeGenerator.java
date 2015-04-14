package com.gamezero.mazegenerator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.gamezero.mazegenerator.util.Maze;

/**
 * This class describes the maze generator using the recursive backtracking
 * algorithm
 * 
 * @author funshinho
 */
public class MazeGenerator {

	/**
	 * The direction the algorithm will take during the maze generation
	 */
	private enum Direction {
		UP, DOWN, LEFT, RIGHT;
	}

	/**
	 * The instance of the generator
	 */
	private static MazeGenerator instance = null;

	/**
	 * Constructor
	 */
	private MazeGenerator() {
	}

	/**
	 * Access point of the maze generator
	 * 
	 * @return the instance of the maze generator
	 */
	public static MazeGenerator getInstance() {
		if (instance == null) {
			instance = new MazeGenerator();
		}
		return instance;
	}

	/**
	 * Generate a maze
	 * 
	 * @param width
	 *            the maze width
	 * @param height
	 *            the maze height
	 * @return the generated maze
	 */
	public Maze generateMaze(int width, int height) {

		// Init maze
		Maze maze = new Maze(width, height);
		Random r = new Random();
		int startX = r.nextInt(width);
		int startY = r.nextInt(height);
		buildMaze(startX, startY, maze);
		
		return maze;
	}

	/**
	 * Build maze from the given starting point
	 * 
	 * @param x
	 *            the x position
	 * @param y
	 *            the y position
	 * @param maze
	 *            the maze
	 */
	private void buildMaze(int x, int y, Maze maze) {

		// The cell is now visited
		maze.setVisited(x, y, true);

		// Shuffle carving directions
		List<Direction> dirList = Arrays.asList(Direction.values());
		Collections.shuffle(dirList);

		// Get the new cell position
		int newX = 0;
		int newY = 0;

		for (Direction dir : dirList) {
			switch (dir) {
			case UP:
				newX = x;
				newY = y - 1;
				break;
			case DOWN:
				newX = x;
				newY = y + 1;
				break;
			case LEFT:
				newX = x - 1;
				newY = y;
				break;
			case RIGHT:
				newX = x + 1;
				newY = y;
			}

			int width = maze.getWidth();
			int height = maze.getHeight();

			// Check if the new cell is within the bounds and if the cell was
			// unvisited
			if (newX >= 0 && newX < width && newY >= 0 && newY < height
					&& !maze.isVisited(newX, newY)) {

				breakWall(x, y, dir, maze);
				buildMaze(newX, newY, maze);

			}
		}
	}

	/**
	 * Break the wall at the given direction from the given cell
	 * 
	 * @param x
	 *            the x position
	 * @param y
	 *            the y position
	 * @param dir
	 *            the direction
	 */
	private void breakWall(int x, int y, Direction dir, Maze maze) {
		switch (dir) {
		case UP:
			maze.setHorizontalWall(x, y, false);
			break;
		case DOWN:
			maze.setHorizontalWall(x, y + 1, false);
			break;
		case LEFT:
			maze.setVerticalWall(x, y, false);
			break;
		case RIGHT:
			maze.setVerticalWall(x + 1, y, false);
		}
	}

}
