import java.io.*;
//import java.util.Scanner;
import functions.*;
//import singleton.WeatherProvider;
import classes.*;
// TODO
// Coordinates

public class Main{
	public static void main(String[] args){
		if (args.length == 1){
			int i, j;
			i = 0;
			j = 0;
			Methods func = new Methods();
			//WeatherProvider wp = new WeatherProvider(); 
			File file = new File(args[0]);
			//String[][] data = 
			func.Sc();
			//System.out.println(data[++i][++j]);
			func.SimTxt();
			//String wea = wp.getCurrentWeather();
			//System.out.println(wea);
			func.SimTxt().mes.close();
			Methods.SimTxt().mes.close();
		}
		else {
			System.out.println("Check that you have 1 argument, no more or no less");
		}
	}
}
