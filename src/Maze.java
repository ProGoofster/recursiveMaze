import java.util.*;
import java.io.*;
import java.util.regex.Pattern;

/**
 * Maze represents a maze of characters. The goal is to get from the
 * top left corner to the bottom right, following a path of 1's. Arbitrary
 * constants are used to represent locations in the maze that have been TRIED
 * and that are part of the solution PATH.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class Maze
{
    private static final char PATH = 'o';

    private int numberRows, numberColumns;
    private char[][] grid;


    /**
     * Constructor for the Maze class. Loads a maze from the given file.
     * Throws a FileNotFoundException if the given file is not found.
     *
     * @param filename the name of the file to load
     * @throws FileNotFoundException if the given file is not found
     */
    public Maze(String filename) throws FileNotFoundException
    {
        Scanner scanner = new Scanner(new File(filename));

        // Count the number of lines and characters in the file
        numberRows = 0;
        numberColumns = 0;
        while (scanner.hasNextLine()) {
            numberColumns++;
            String line = scanner.nextLine();
            if (line.length() > numberRows) {
                numberRows = line.length();
            }
        }

        // initialize grid for maze
        grid = new char[numberColumns][numberRows];

        // Reset the scanner
        scanner = new Scanner(new File(filename));

        // Populate  2D array
        int row = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            for (int col = 0; col < line.length(); col++) {
                grid[row][col] = line.charAt(col);
            }
            row++;
        }
    }

    /**
     * Marks a given position in the maze as part of the PATH
     *
     * @param row the index of the row to mark as part of the PATH
     * @param col the index of the column to mark as part of the PATH
     */
    public void markPath(int row, int col)
    {
        grid[row][col] = PATH;
    }

    /**
     * Unmarks a given position in the maze as part of the PATH
     *
     * @param row the index of the row to mark as part of the PATH
     * @param col the index of the column to mark as part of the PATH
     */
    public void unmarkPath(int row, int col){
        if((grid[row][col] == 'o')) grid[row][col] = '.';
    }



    public char getTile(int row, int col){
        return grid[row][col];
    }

    /**
     * Determines if a specific location is valid. A valid location
     * is one that is on the grid, is not blocked, and has not been TRIED.
     *
     * @param row the row to be checked
     * @param column the column to be checked
     * @return true if the location is valid
     */
    public boolean validPosition(int row, int column)
    {
        boolean result = false;

        // check if cell is in the bounds of the matrix
        if (row >= 0 && row < grid.length &&
                column >= 0 && column < grid[row].length)

            //  check if cell is not blocked and not previously tried
            if (!Pattern.compile("[#o]").matcher(String.valueOf(grid[row][column])).matches()) result = true;
        return result;
    }
    /**
     * Returns the maze as a string.
     *
     * @return a string representation of the maze
     */
    public String toString()
    {
        String result = "\n";

        for (int row=0; row < grid.length; row++)
        {
            for (int column=0; column < grid[row].length; column++)
                result += grid[row][column] + "";
            result += "\n";
        }

        return result;
    }

    /**
     * Finds the coords of the starting tile
     *
     * @return a integer array containing the coordinates of "R"
     */
    public int[] getStart(){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 'R') {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {-1, -1};
    }
}

