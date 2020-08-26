//import java.io.*;
//import java.util.Scanner;
import functions.*;
//import singleton.WeatherProvider;
//import classes.*;

public class Main{
	public static void main(String[] args){
		if (args.length == 1){
			// int i, j;
			// i = 0;
			// j = 0;
			//WeatherProvider wp = new WeatherProvider(); 
			//File file = new File(args[0]);
			//String[][] data = 
			Methods.Sc();
			Methods.iterateSimulation();
			Methods.SimTxt();
			//System.out.println(data[++i][++j]);
			//Methods.SimTxt();
			//String wea = wp.getCurrentWeather();
			//System.out.println(wea);
			//Methods.SimTxt().mes.close();
			//Methods.SimTxt(mes.close());
		}
		else {
			System.out.println("Check that you have 1 argument, no more, no less");
		}
	}
}
