package quickVoids;

public class LogicGates {

	public static void main(String[] args) {
		
	}
	static boolean and(boolean check, boolean against) {
		boolean returnTo;
		if (check && against) {
			returnTo = true;
		} else {
			returnTo = false;
		}
		return (returnTo);
	}

	static boolean or(boolean check, boolean against) {
		boolean returnTo;
		if (check || against) {
			returnTo = true;
		} else {
			returnTo = false;
		}
		return (returnTo);
	}

	static boolean xOr(boolean check, boolean against) {
		boolean returnTo;
		if (check && against) {
			returnTo = false;
		} else if (check || against) {
			returnTo = true;
		} else if (against) {
			returnTo = true;
		} else {
			returnTo = false;
		}
		return (returnTo);
	}

	static boolean not(boolean check) {
		boolean returnTo;
		if (check) {
			returnTo = false;
		} else {
			returnTo = true;
		}

		return (returnTo);
	}

	static boolean nor(boolean check, boolean against) {
		boolean returnTo;
		if (!check && !against) {
			returnTo = true;
		} else {
			returnTo = false;
		}

		return (returnTo);
	}

	static boolean xNor(boolean check, boolean against) {
		boolean returnTo;
		if ((!check && !against) || (check && against)) {
			returnTo = true;
		} else {
			returnTo = false;
		}
		return (returnTo);
	}

	static boolean nand(boolean check, boolean against) {
		boolean returnTo;
		if (!check && !against) {
			returnTo = true;
		} else {
			returnTo = false;
		}
		return (returnTo);
	}

}
