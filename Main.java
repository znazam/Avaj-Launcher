import functions.*;

public class Main{
	public static void main(String[] args){
		if (args.length == 1){
			Methods.Sc();
			Methods.SimTxt();
		}
		else {
			System.out.println("Check that you have 1 argument, no more, no less");
		}
	}
}
