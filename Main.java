import java.io.*;
import java.util.Scanner;
//import Myclass.*;
import Functions.methods;

public class Main{
	public static void main(String[] args){
		if (args.length == 1){
			File file = new File(args[0]);
			String data = sc(file);
			System.out.println(data);
		}
		else {
			System.out.println("Check that you have 1 argument, no more or no less");
		}
	}
}
