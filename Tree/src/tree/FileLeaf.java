package tree;

/**
 * a class to present a file
 * 
 * @author me
 * 
 */
class FileLeaf extends FileComponent	{
	static final String CYAN = "\u001b[96m";
	static final String RESET = "\u001b[0m";
	static final String YELLOW = "\u001b[33m";
	static final String BLUE = "\u001b[94m";
	
	/**
	 * constractor for the leaf
	 * @param name
	 * @param level
	 */
	public FileLeaf(String name, int level) {
		super(name, level);
	}

	/* 
	 * a method to print a single file (by its level)
	 */
	@Override
	public void printMe() {
		int lev = this.getLevel();
		
		while (lev > 0) {
			System.out.print("|");
			if (lev > 1) {
				System.out.print("   ");
			}
			--lev;
		}
		
		if (this.getName().indexOf(".h") != -1) {
			System.out.println("______ " + CYAN + this.getName() + RESET);
	
		}
		else if(this.getName().indexOf(".c") != -1) {
			System.out.println("______ " + YELLOW + this.getName() + RESET);
		}
		else {
			System.out.println("______ " + BLUE + this.getName() + RESET);
		}
	}
}
