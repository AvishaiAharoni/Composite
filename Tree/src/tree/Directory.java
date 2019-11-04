package tree;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author avishai
 *
 */
class Directory extends FileComponent {
	static final String RESET = "\u001b[0m";
	static final String GREEN = "\u001b[32m";
	
	List<FileComponent> file_components = new ArrayList<>();
	
	/**
	 * constructor to insert the root directory and all the directories and the files 
	 * that connected to the root.
	 *  
	 * @param fullPath - to store the path of the root directory
	 * @param level - for each directory or file
	 * 
	 */
	Directory (String fullPath, int level) {
		super(fullPath, level);
		
		File f = new File(fullPath);
		
		File[] fileList = f.listFiles();
		
		setName(f.getName());
		
		for (File current : fileList) {
			if (current.isFile()) {
				file_components.add(new FileLeaf(current.getName(), level));
			}
			else if (current.isDirectory()) {
				file_components.add(new Directory(current.toString(), level + 1));
			}
		}
		
		// to sort the files by name
		Collections.sort(file_components, new Comparator<FileComponent> ( ) {

				@Override
				public int compare(FileComponent f1, FileComponent f2) {
					return f1.getName().compareToIgnoreCase(f2.getName());
				}
			});
	}
	
	/* 
	 * a method to print the directory and all its files
	 */
	@Override
	public void printMe() {
		System.out.println(GREEN + this.getName() + RESET);
		System.out.println("|");
		
		for (FileComponent fc : file_components) {
				System.out.print("|   ");
				fc.printMe();
		}
	}
}