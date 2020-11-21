package penguin;

import java.util.Random;

public class Penguin {
	public static void main(String[] args) {
		Penguin penguin = new Penguin("Sam", "Adelie", 4);
		penguin.printInfo();
		penguin.hunt(true);
		penguin.waddle(true);
		penguin.makeInvisible(true);
		penguin.kill(true);
		penguin.makeInvisible(true);
		penguin.makeVisible(true);
		penguin.makeVisible(true);
		penguin.revive(true);
	}
	

	private String name;
	private String species;
	private int age;
	private boolean isGhost;
	private boolean isInvisible;

	Penguin(String name, String species, int age) {
		this.name = name;
		this.species = species;
		this.age = age;
	}
	void printInfo() {
		System.out.println(name + " the " + species + " penguin is " + age + " years old.");
	}
	int hunt(boolean printStatement) {
		int r = new Random().nextInt(7 - 2 + 2) + 2;
		if (printStatement) {
			System.out.println(name + " the penguin caught " + r + " fish.");
		}
		return r;
	}

	int waddle(boolean printStatement) {
		int r = new Random().nextInt(50 - 10 + 1) + 10;
		if (printStatement) {
			System.out.println(name + " the penguin waddled " + r + " inches.");
		}
		return r;
	}

	String getName() {
		return name;
	}

	String getSpecies() {
		return species;
	}

	int getAge() {
		return age;
	}

	void kill(boolean printStatement) {
		isGhost = true;
		if (printStatement) {
			System.out.println("DEAD PENGUIN :(");
		}
	}

	void revive(boolean printStatement) {
		isGhost = false;
		if (printStatement) {
			System.out.println(name + " the penguin is alive again!");
		}
	}

	void makeInvisible(boolean printStatement) {
		if (printStatement) {
			if (isGhost) {
				System.out.println(name + " the penguin is now invisible.");
			}
			if (!isGhost) {
				System.out.println(name + " the penguin is not a ghost, you can make it a ghost by using .kill()");
			}
		}
		if (isGhost) {
			isInvisible = true;
		}
		if (!isGhost) {
			isInvisible = false;
		}

	}

	void makeVisible(boolean printStatement) {
		boolean returnTrue = false;
		boolean Continue = true;
		if (isInvisible) {
			if (printStatement) {
				System.out.println(name + " the penguin is now visible");
				isInvisible = false;
				Continue = false;
			}
		}
		if (Continue) {
			if (!isInvisible) {
				if (printStatement) {
					System.out.println(name + " the penguin is already visible");
				}
			}
		}

	}

	boolean isAlive(boolean printStatement) {
		if (printStatement) {
			if (isGhost) {
				System.out.println(name + " the penguin is dead. :(");
			}
			if (!isGhost) {
				System.out.println(name + " the penguin is alive! :)");
			}
		}
		return isGhost;
	}

	boolean isInvisible(boolean printStatement) {
		boolean returnTrue = false;
		if (printStatement) {
			if (isInvisible) {
				System.out.println(name + " the penguin is invisible");
				returnTrue = true;
			}
			if (!isInvisible) {
				System.out.println(name + " the penguin isn't invisible");
				returnTrue = true;
			}
		}
		if (returnTrue) {
			return true;
		} else {
			return false;
		}
	}

}
