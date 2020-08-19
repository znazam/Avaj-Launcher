package methods;

import java.util.Scanner;

public class methods{
	static String Sc(File file){
			try{
			Scanner sc = new Scanner(file);
			System.out.println("the file given is " + file);
			String data;
			while(sc.hasNextLine())
				data = sc.nextLine();
			System.out.println(data);
			return(data);
		}
		catch (FileNotFoundException e){
			System.out.println("file not found bru");
		}
	}
}
