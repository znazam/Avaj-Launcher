package methods;

import java.util.Scanner;
import java.io.*;

public class Methods{
	public String Sc(File file){
		try{
			Scanner sc = new Scanner(file);
			System.out.println("the file given is " + file);
			String cp = sc.nextLine() + "\n";
			while(sc.hasNextLine()){
				String data = sc.nextLine();
				cp = cp + data;
			}
			///String data = sc.useDelimiter(null);
			return cp;
		}
		catch (FileNotFoundException e){
			System.out.println("file not found bru");
		}
		return null;
	}
}
