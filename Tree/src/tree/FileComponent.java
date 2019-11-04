package tree;

 /*
  * an abstract class that has for every file (or directory) its name and its level in the tree.
  * also has a method that prints the name of the file. 

 * @author avishai
 *
 */
abstract class FileComponent {
	private String name;
	private int level;
	
	/**
	 * constructor
	 * @param name
	 * @param level
	 */
	public FileComponent(String name, int level) {
		this.name = name;
		this.level = level;
	}
	
	/**
	 * @return the name of the file
	 */
	protected final String getName() {
		return name;
	}

	/**
	 * @param name - to set the file name
	 */
	protected final void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the level of the file
	 */
	protected final int getLevel() {
		return level;
	}

	/**
	 * @param level - to set the level of the file
	 */
	protected final void setLevel(int level) {
		this.level = level;
	}

	abstract public void printMe();
}