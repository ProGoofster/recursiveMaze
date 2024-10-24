public class customMazeSolver {
    private Maze maze;

    /**
     * Constructor for the MazeSolver class.
     */
    public customMazeSolver(Maze maze)
    {
        this.maze = maze;
    }
    /**
     * Attempts to recursively traverse the maze. Inserts special
     * characters indicating locations that have been TRIED and that
     * eventually become part of the solution PATH.
     *
     * @param row row index of current location
     * @param column column index of current location
     * @return true if the maze has been solved
     */
    public boolean traverse(int row, int column)
    {
        boolean done = false;

        if (maze.validPosition(row, column))
        {
            maze.markPath(row, column);   // mark this cell as tried

        }
        System.out.println(maze);
        return done;
    }

    public int[] getStartingPos(){
        return maze.getStart();
    }
}
