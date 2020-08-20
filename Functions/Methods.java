package functions;

import java.util.Scanner;
import java.io.*;

public class Methods{//scans the data in a file and returns it
	public static String Sc(File file){
		try{
			Scanner sc = new Scanner(file);
			String data = sc.nextLine() + "\n";
			while(sc.hasNextLine()){
				data = data + sc.nextLine();
			}
			sc.close();
			return data;
		}
		catch (FileNotFoundException e){
			System.out.println("file not found bru");
		}
		return null;
	}


	public static void SimTxt() {//creates simulation file and writes data in
		try {
		File sim = new File("simulation.txt");
		FileWriter mes = new FileWriter("simulation.txt");
		if (sim.createNewFile()) {
			System.out.println("File created: " + sim.getName());
		} else {
			System.out.println("File already exists.");
		}
		mes.write("Files in Java might be tricky, but it is fun enough!\n");
		mes.close();
		System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
		System.out.println("An error occurred. When creating simulation.txt or writing into it");
		}
	}
	  
}
