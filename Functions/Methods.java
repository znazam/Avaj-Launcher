package functions;
import java.util.*;

import classes.*;
import java.io.*;
import interfaces.*;
import vehicles.*;
//import java.security.MessageDigest;

public class Methods{//scans the data in a file than sends it to register 
	public static void Sc(){
		try{
			Scanner file = new Scanner(new File("scenario.txt")).useDelimiter(",\\s*");
			String line = file.nextLine();
			try{
				Var.numSim = Integer.parseInt(line);
			}
			catch(Exception e){
				Var.numSim = 1;
				System.out.println("parsing caused an error so simulation will only run one time");
			}
			WeatherTower wt = new WeatherTower();
			while (file.hasNext()) {
				String[] data = new String[0];
				Flyable flyable;
				try{
					line = file.nextLine();
					data = line.split(" ");
					//int data2 = Integer.parseInt(data[2]) + Var.ID.toString();
					flyable = AircraftFactory.newAircraft(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]));
					Var.log.add("Tower says: "+data[0]+"#"+data[1]+"("+Var.ID+")"+" registered in tower.\n");
					wt.register(flyable);
				}
				catch (Exception e){
					System.out.println("couldn't add " + data[0] + " aircraft in method.sc becuase of invalid data in scenario.txt");
				} 
			}
			file.close();
			iterateSimulation(wt);
		}
		catch (FileNotFoundException e){
			System.out.println("Something is wrong in sc");
		}
	}


	public static void SimTxt() {//creates simulation file and writes data in
		try {
		FileWriter mes = new FileWriter("simulation.txt");
		for (String log : Var.log){
			mes.write(log);
		}
		mes.close();
		} catch (IOException e) {
		System.out.println("An error occurred. When creating simulation.txt or writing into it");
		}
	}

	public static void iterateSimulation(WeatherTower wt){//counts the amount of times the simulation must run and runs it
		for (int i = 0; i < Var.numSim; i++){
			try {
				wt.conditionsChanged();
			} catch (Exception e) {
				System.out.println("simulation isn't iterating" + e);
			}
		}
	}
}
