package functions;
import java.util.*;

import classes.*;

import java.io.*;
import interfaces.*;
import vehicles.*;

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
			//List<String> temps = new ArrayList<String>();
			WeatherTower wt = new WeatherTower();
			while (file.hasNext()) {
				String[] data = new String[0];
				Flyable flyable;
				try{
					line = file.nextLine();
					data = line.split(" ");
					flyable = AircraftFactory.newAircraft(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]));
					wt.register(flyable);
				}
				catch (Exception e){
					System.out.println("couldn't add " + data[1] + " aircraft in method.sc");
				}
				//temps.add(line);
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
			System.out.println("Something is wrong in sc");
		}
		// return null;
	}


	public static void SimTxt() {//creates simulation file and writes data in
		try {
		//File sim = new File("simulation.txt");
		FileWriter mes = new FileWriter("simulation.txt");
		System.out.println(Var.log);
		for (String log : Var.log){
			mes.write(log);
		}
		mes.close();
		System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
		System.out.println("An error occurred. When creating simulation.txt or writing into it");
		}
	}
	  
	// public static int[] AirLand(int[] arr, int index){ 
    //     if (arr == null
    //         || index < 0
    //         || index >= arr.length) { 
  
    //         return arr; 
	// 	}
		
    //     int[] anotherArray = new int[arr.length - 1]; 
    //     for (int i = 0, k = 0; i < arr.length; i++) { 
    //         if (i == index) { 
    //             continue; 
    //         } 
    //         anotherArray[k++] = arr[i]; 
    //     } 
  
    //     return anotherArray; 
    // } 

	public static void iterateSimulation(){
		for (int i = 0; i < Var.numSim; i++){
			try {
				WeatherTower wt = new WeatherTower();
				wt.conditionsChanged();
			} catch (Exception e) {
				System.out.println("simulation isn't iterating");
			}
		}
	}
}
