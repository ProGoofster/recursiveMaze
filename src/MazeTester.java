import java.util.*;
import java.io.*;

/* Name: Jake Berryman
# Date: 4/22/2024
# Class: CSC1120
# Pledge: I have neither given nor received unauthorized aid on this program.
# Description: The Recursive Maze solving project
# Input: put in the file to test
# Output:The program will output the solved maze.
*/

/**
 * MazeTester uses recursion to determine if a maze can be traversed.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class MazeTester
{
    /**
     * Creates a new maze, prints its original form, attempts to
     * solve it, and prints out its final form.
     */
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter maze configuration: ");
        String filename = scan.nextLine();
        Maze maze = null;
        try {
            maze = new Maze(filename);
        } catch (Exception e) {
            System.out.println(filename+ " does not exist, try again!");
            main(args);
            return;
        }

        MazeSolver solver = new MazeSolver(maze);

        int[] startPos = solver.getStartingPos();
        if (solver.maze_solved(startPos[0], startPos[1])) {
            System.out.println("Solution found!");
            System.out.println("solve_maze was called " + solver.getCalls() + " times.");
            System.out.println("There are " + solver.getBreadcrumbs() + " breadcrumbs.");
            System.out.println(maze);
        }
        else System.out.println("There is no possible path.");
    }
}



// Change grid to 4/4 to 0 for no possible paths