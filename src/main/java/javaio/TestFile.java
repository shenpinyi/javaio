package javaio;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class TestFile {

	public static void main(String[] args) {
		System.out.println("1. test simple file.list");
		listFile();
		
		System.out.println("2. test file.list with filter");
		listFileByName("\\..*"); //list all files start with '.'
		
		System.out.println("3.1 practice file.list");
		SortedDirList sdl = new SortedDirList(".\\src\\main\\java\\javaio");
		for (String dirItem : sdl.list()) {
			System.out.println(dirItem);
		}
		System.out.println("3.2 practice file.list with filter");
		for (String dirItem : sdl.list(".*\\.java")) {
			System.out.println(dirItem);
		}
		
	}
	
	
	private static void listFile() {
		File path = new File(".");
		String[] list = path.list();
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for (String dirItem : list) {
			System.out.println(dirItem);
		}
	}

	private static void listFileByName(String regex) {
		File path = new File(".");
		String[] list = path.list(new FilenameFilter() {
			private Pattern p = Pattern.compile(regex);
			public boolean accept(File dir, String name) {
				return p.matcher(name).matches();
			}
		});
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for (String dirItem : list) {
			System.out.println(dirItem);
		}
	}


}
