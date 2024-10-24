/**
 * MazeSolver attempts to recursively traverse a Maze. The goal is to get from the
 * given starting position to the bottom right, following a path of 1's. Arbitrary
 * constants are used to represent locations in the maze that have been TRIED
 * and that are part of the solution PATH.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class MazeSolver
{
    private Maze maze;
    private int calls;
    private int breadcrumbs;
    /**
     * Constructor for the MazeSolver class.
     */
    public MazeSolver(Maze maze)
    {
        this.maze = maze;
        calls = 0;
        breadcrumbs = 0;
    }

    /*
    boolean maze_solved(row, col):
    // row and col represent the current position of the rat as it moves
    // through the maze, searching for the cheese.
    // The return value (boolean) specifies whether or not the maze can be solved
    // from the current (row, col) position.

    Print the current position of the rat.
    // This printing step is not needed in the algorithm, but I want you to
    //include it so I can check that your recursion is correct.

    Is our current (row, col) where the cheese is?
    If yes, return true.
    // If no, keep going below.

    Drop a breadcrumb at our current (row, col) position.
    Can the rat move NORTH from its current position?
    If yes, try to solve the maze from one position north.
    If the maze can be solved from one position north, return true.

    Can the rat move SOUTH from its current position?
    If yes, try to solve the maze from one position south.
    If the maze can be solved from one position south, return true.

    Can the rat move EAST from its current position?
    If yes, try to solve the maze from one position east.
    If the maze can be solved from one position east, return true.

    Can the rat move WEST from its current position?
    If yes, try to solve the maze from one position west.
    If the maze can be solved from one position west, return true.

    If we get here, it means the maze cannot be solved from our current
    position, since trying all four possible directions failed. We must be in a
    dead end.
    Pick up the breadcrumb from our current position because breadcrumbs only
    mark the solution, and we didn't find one from here.
    Return false (indicating we're stuck)
     */

    /**
     * Attempts to recursively traverse the maze. Inserts special
     * characters indicating locations that have been TRIED and that
     * eventually become part of the solution PATH.
     *
     * @param row row index of current location
     * @param column column index of current location
     * @return true if the maze has been solved
     */
    public boolean maze_solved(int row, int column)
    {
        calls++;
        System.out.println("The rat is at " + row + ", " + column + ".");

        if(maze.getTile(row, column) == 'C') return true;
        breadcrumbs++;
        maze.markPath(row, column);

        if(maze.validPosition(row-1, column)) if(maze_solved(row-1, column)) return true; //up
        if(maze.validPosition(row+1, column)) if(maze_solved(row+1, column)) return true; //down
        if(maze.validPosition(row, column+1)) if(maze_solved(row, column+1)) return true; //right
        if(maze.validPosition(row, column-1)) if(maze_solved(row, column-1)) return true; //left

        breadcrumbs--;
        maze.unmarkPath(row, column);
        return false;
    }

    public int[] getStartingPos(){
        return maze.getStart();
    }

    public int getCalls(){
        return calls;
    }

    public int getBreadcrumbs(){
        return breadcrumbs;
    }
}
