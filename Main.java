import java.io.*;
import java.util.Scanner;
//import Myclass.*;
import methods.*;

public class Main{
	public static void main(String[] args){
		if (args.length == 1){
			Methods func = new Methods();
			File file = new File(args[0]);
			String data = func.Sc(file);
			System.out.println(data);
		}
		else {
			System.out.println("Check that you have 1 argument, no more or no less");
		}
	}
}
