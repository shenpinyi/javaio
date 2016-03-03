package javaio;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class TestFile {

	public static void main(String[] args) {
		//listFile();
		listFileByName("\\..*"); //list all files start with '.'
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
