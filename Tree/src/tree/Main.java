package tree;

import java.nio.file.Path;
import java.nio.file.Paths;

class Main {

	public static void main(String[] args) {
		Path parent = Paths.get(System.getProperty("user.dir")).getParent();
		
		Directory dic = new Directory(parent.toString(), 0);
		dic.printMe();
	}
}