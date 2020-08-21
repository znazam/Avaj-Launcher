package functions;

import java.util.*;
import java.io.*;

public class Methods{//scans the data in a file and returns it
	public static void Sc(File file){
		try{
			// Scanner presc = new Scanner(file);
			// Scanner sc = new Scanner(file);
			// int i = 0;
			// int j = 0;
			// int c= 0;
			// String cp = "start";
			// while(presc.hasNextLine()){
			// 	//data = data + sc.nextLine() + "\n";
			// 	cp = presc.nextLine();
			// 	c++;
			// }
			// System.out.println(cp);
			// String[][] data = new String[c][5];
			// while (sc.hasNextLine()){
			// 	while (sc.hasNext(" ")){
			// 		data[i][j] = sc.next(" ");
			// 		j++;
			// 		System.out.println(data[i][j]);
			// 	}
			// 	i++;
			// }
			// presc.close();
			// sc.close();
			String token1 = "";
			Scanner inFile1 = new Scanner(new File("scenario.txt")).useDelimiter(",\\s*");
			String[] tempsArray = {""};
			int i = 0;
			List<String> temps = new ArrayList<String>();
					while (inFile1.hasNext()) {
			  token1 = inFile1.next();
			  temps.add(token1);
			  tempsArray[i++] = temps; 
			}
			inFile1.close();
		
			// String[] tempsArray = temps.toArray(new String[0]);
		
			// for (String s : tempsArray) {
			//   System.out.println(s);
			// }
			System.out.println(tempsArray[0]);
			// return data;
		}
		catch (FileNotFoundException e){
			System.out.println("file not found bru");
		}
		// return null;
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
