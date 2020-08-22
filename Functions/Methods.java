package functions;
import java.util.*;
import java.io.*;

public class Methods{//scans the data in a file and returns it
	public static void Sc(){
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
			Scanner file = new Scanner(new File("scenario.txt")).useDelimiter(",\\s*");
			String line = file.nextLine();
			//String [] data = {""};
			try{
				Var.numSim = Integer.parseInt(line);
			}
			catch(Exception e){
				Var.numSim = 1;
				System.out.println("parsing caused an error so simulation will only run one time");
			}

			List<String> temps = new ArrayList<String>();
					while (file.hasNext()) {
			  line = file.next();
			  data = line.split(" ");
			  temps.add(line);
			  //tempsArray[i++] = temps; 
			}

			file.close();
			
//			String[] tempsArray = temps.toArray(new String[0]);
			
			// for (String s : tempsArray) {
			//   System.out.println(s);
			// }
//			System.out.println(tempsArray[0]);
//			System.out.println(data);
			// return data;
		}
		catch (FileNotFoundException e){
			System.out.println("file not found bru");
		}
		// return null;
	}


	public static void SimTxt(String txt) {//creates simulation file and writes data in
		try {
		//File sim = new File("simulation.txt");
		FileWriter mes = new FileWriter("simulation.txt");
		mes.write(txt);
		mes.close();
		System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
		System.out.println("An error occurred. When creating simulation.txt or writing into it");
		}
	}
	  
}
