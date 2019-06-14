package app.start;

import app.exceptions.InvalidTeamException;
import soccer.offside.Offside;

public class MainClass {

	public static void main(String[] args) {
		try {
			// First variant of the method - sorting the arrays in advance
			System.out.println("-----First variant-----");
			Offside.checkOffside(new int[][] { { 5, 22, 30, 40, 30, 50, 30, 50, 50, 60, 50 },
					{ 96, 20, 30, 25, 25, 40, 60, 70, 80, 70, 40 } });
			System.out.println();
			Offside.checkOffside(new int[][] { { 5, 22, 30, 40, 30, 50, 30, 50, 50, 60, 50 },
					{ 96, 28, 30, 25, 25, 40, 60, 70, 80, 70, 40 } });
			System.out.println();
			Offside.checkOffside(new int[][] { { 5, 20, 30, 40, 30, 50, 30, 50, 50, 60, 50 },
					{ 96, 20, 30, 25, 25, 40, 60, 70, 80, 70, 40 } });
			System.out.println();

			// Second variant of the search - manually iterating over the elements
			System.out.println("-----Second variant-----");
			Offside.checkOffsideManually(new int[][] { { 5, 22, 30, 40, 30, 50, 30, 50, 50, 60, 50 },
					{ 96, 20, 30, 25, 25, 40, 60, 70, 80, 70, 40 } });
			System.out.println();
			Offside.checkOffsideManually(new int[][] { { 5, 22, 30, 40, 30, 50, 30, 50, 50, 60, 50 },
					{ 96, 28, 30, 25, 25, 40, 60, 70, 80, 70, 40 } });
			System.out.println();
			Offside.checkOffsideManually(new int[][] { { 5, 20, 30, 40, 30, 50, 30, 50, 50, 60, 50 },
					{ 96, 20, 30, 25, 25, 40, 60, 70, 80, 70, 40 } });
			System.out.println();

			// Checking the corners
			System.out.println("-----First variant - checking corners - true-----");
			Offside.checkOffside(new int[][] { { 0, 22, 30, 40, 30, 50, 30, 50, 50, 60, 50 },
					{ 96, 0, 30, 25, 25, 40, 60, 70, 80, 70, 40 } });
			System.out.println();
			Offside.checkOffside(new int[][] { { 5, 22, 30, 40, 30, 50, 30, 50, 50, 60, 100 },
					{ 96, 28, 30, 25, 25, 40, 60, 70, 100, 70, 40 } });

			System.out.println();
			System.out.println("-----Second variant - checking corners - true-----");
			Offside.checkOffsideManually(new int[][] { { 0, 22, 30, 40, 30, 50, 30, 50, 50, 60, 50 },
					{ 96, 0, 30, 25, 25, 40, 60, 70, 80, 70, 40 } });
			System.out.println();
			Offside.checkOffsideManually(new int[][] { { 5, 22, 30, 40, 30, 50, 30, 50, 50, 60, 100 },
					{ 96, 28, 30, 25, 25, 40, 60, 70, 100, 70, 40 } });
		} catch (InvalidTeamException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
