package soccer.offside;

import java.util.Arrays;

import app.exceptions.InvalidTeamException;

public final class Offside {

	private Offside() {
	}

	/* Returns true if there is offside position */
	public static boolean checkOffside(int[][] teams) throws InvalidTeamException {
		// Enforcing a constraint - only two teams
		if (teams.length != 2)
			throw new InvalidTeamException("The 2D array should only consist of two teams.");

		// Enforcing a second constraint - 11 players per team
		for (int[] team : teams) {
			if (team.length != 11)
				throw new InvalidTeamException("A team should consist of exactly 11 players.");
		}

		// Sort the two teams X-coordinates in ascending order
		Arrays.sort(teams[0]);
		Arrays.sort(teams[1]);

		// Enforcing a third constraint - values between 0 (inclusive) and
		// 100(inclusive)
		if ((teams[0][0] < 0 || teams[0][10] > 100) || (teams[1][0] < 0 || teams[1][10] > 100))
			throw new InvalidTeamException("X-coordinate values must be between 0 and 100.");

		// Defining the players from both teams who are potentially
		// in offside positions - in the left or right half of the field
		int potentialRightTeamPlayer = teams[1][0];
		int potentialLeftTeamPlayer = teams[0][10];

		// Defining the goalkeepers
		int rightGoalKeeper = teams[1][10];
		int leftGoalKeeper = teams[0][0];

		// Defining the second to last player of the
		// respective teams which are in defense state
		int secondToLastRightTeamPlayer = teams[1][9];
		int secondToLastLeftTeamPlayer = teams[0][1];

		// Whether any of the teams is performing corner
		if (potentialRightTeamPlayer == leftGoalKeeper) {
			System.out.println("Right team is performing corner in left half of the field!");
			return false;
		} else if (potentialLeftTeamPlayer == rightGoalKeeper) {
			System.out.println("Left team is performing corner in right half of the field!");
			return false;
		}

		/*
		 * Most important logic - checking whether there is offside position in both
		 * halves of the field first - if the leftmost player belongs to the right team,
		 * second - if the rightmost player belongs to the left team, third - if there
		 * is right team player between the left goalkeeper and the second to last
		 * player of the left team, fourth - if there is left team player between the
		 * right goalkeeper and the second to last player of the right team.
		 */
		if (potentialRightTeamPlayer < leftGoalKeeper) {
			System.out.println("Player with X-coordinate: [" + potentialRightTeamPlayer
					+ "] from the right team is in offside position!");
			return true;
		} else if (potentialLeftTeamPlayer > rightGoalKeeper) {
			System.out.println("Player with X-coordinate: [" + potentialLeftTeamPlayer
					+ "] from the left  team is in offside position!");
			return true;
		} else if (potentialRightTeamPlayer > leftGoalKeeper && potentialRightTeamPlayer < secondToLastLeftTeamPlayer) {
			System.out.println("Player with X-coordinate: [" + potentialRightTeamPlayer
					+ "] from the right team is in offside position!");
			return true;
		} else if (potentialLeftTeamPlayer < rightGoalKeeper && potentialLeftTeamPlayer > secondToLastRightTeamPlayer) {
			System.out.println("Player with X-coordinate: [" + potentialLeftTeamPlayer
					+ "] from the left  team is in offside position!");
			return true;
		}

		System.out.println("There is no offside position in either halves of the field!");
		return false;
	}

	/*
	 * Second variant of the method which is manually implemented - no sorting of
	 * the arrays - first checks if any of the players of the first team is in
	 * offside position in the first iteration of the main loop and returns true if
	 * so and then does the same for the second team in the second iteration of the
	 * main loop
	 */
	public static boolean checkOffsideManually(int[][] teams) throws InvalidTeamException {
		// Enforcing a constraint - only two teams
		if (teams.length != 2)
			throw new InvalidTeamException("The 2D array should only consist of two teams.");

		// Enforcing a second constraint - 11 players per team
		for (int[] team : teams) {
			if (team.length != 11)
				throw new InvalidTeamException("A team should consist of exactly 11 players.");
		}

		for (int team = 0; team < teams.length; team++) {
			int playersInbetween = teams[team].length;
			for (int playerInAttack = 0; playerInAttack < teams[team].length; playerInAttack++) {
				playersInbetween = teams[team].length;
				for (int playerInDefense = 0; playerInDefense < teams[team].length; playerInDefense++) {
					// Enforcing a third constraint - values between 0
					// (inclusive) and
					// 100(inclusive)
					if (teams[team][playerInAttack] < 0 || teams[team][playerInAttack] > 100) {
						throw new InvalidTeamException("X-coordinate values must be between 0 and 100.");
					}

					// the offside condition is different if the attacking team
					// is on the left or on the right
					boolean offsideCondition = team == 0 ? teams[team][playerInAttack] > teams[1][playerInDefense]
							: teams[team][playerInAttack] < teams[0][playerInDefense];

					// decrease the number of players in between if the
					// condition is true
					if (offsideCondition)
						playersInbetween--;

					if (playersInbetween == 1) {
						// Checking if the last defending player is actually
						// equal to the attacking player - the it is corner
						for (int i = 0; i < teams[team].length; i++) {
							if (teams[team][playerInAttack] == teams[team == 0 ? 1 : 0][i]) {
								String message = (team == 0 ? "Left" : "Right") + " team is performing corner in "
										+ (team == 0 ? "right" : "left") + " half of the field!";
								System.out.println(message);
								return false;
							}
						}

						// Else the attacking player is in offside position
						String message = "Player with X-coordinate: [" + teams[team][playerInAttack] + "] is from the "
								+ (team == 0 ? "left" : "right") + " team is in offside position!";
						System.out.println(message);
						return true;
					}
				}
			}
		}
		System.out.println("There is no offside position in either halves of the field!");
		return false;
	}
}
