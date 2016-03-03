package javaio;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class SortedDirList {

	private File f;
	SortedDirList(String path) {
		f = new File(path);
	}
	
	String[] list() {
		return f.list();
	}
	
	String[] list(String regex) {
		return f.list(new FilenameFilter() {
			public boolean accept(File dir, String filename) {
				return Pattern.compile(regex).matcher(filename).matches();
			}
		});
	}
	
}
