package app.start;

import app.exceptions.InvalidTeamException;
import soccer.offside.Offside;

public class MainClass {

	public static void main(String[] args) {
		try {
			// First variant of the method - sorting the arrays in advance
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
			Offside.checkOffsideManually(new int[][] { { 5, 22, 30, 40, 30, 50, 30, 50, 50, 60, 50 },
					{ 96, 20, 30, 25, 25, 40, 60, 70, 80, 70, 40 } });
			System.out.println();
			Offside.checkOffsideManually(new int[][] { { 5, 22, 30, 40, 30, 50, 30, 50, 50, 60, 50 },
					{ 96, 28, 30, 25, 25, 40, 60, 70, 80, 70, 40 } });
			System.out.println();
			Offside.checkOffsideManually(new int[][] { { 5, 20, 30, 40, 30, 50, 30, 50, 50, 60, 50 },
					{ 96, 20, 30, 25, 25, 40, 60, 70, 80, 70, 40 } });
		} catch (InvalidTeamException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
