package javaio;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class WalkDir {

	File dir;

	public WalkDir() {
		dir = new File(".\\");
	}

	public WalkDir(String path) {
		dir = new File(path);
	}

	public void walk() {
		walk(dir, 0);
	}

	private void walk(File p, int layer) {

		if (p.isDirectory()) {
			printDir(p, layer);
			List<File> l = Arrays.asList(p.listFiles());
			for (File f : l) {
				walk(f, layer + 1);
			}
		} else {
			printFile(p, layer);
		}
	}

	private void printDir(File f, int layer) {

		if (layer == 0) {
			System.out.print(f.getAbsolutePath());
		} else {
			for (; layer > 1; layer--) {
				System.out.print("  ");
			}
			System.out.print("|-\\");
		}
		System.out.print(f.getName() + "\n");
	}

	private void printFile(File f, int layer) {
		if (layer == 0) {
			System.out.print(f.getAbsolutePath());
		} else {
			for (; layer > 1; layer--) {
				System.out.print("  ");
			}
			System.out.print("|-");
		}
		System.out.print(f.getName() + "\n");
	}
}
