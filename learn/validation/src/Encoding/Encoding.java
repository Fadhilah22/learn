import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

public class Encoding {
	public static Random rand;
	public static Scanner scan;

	public Encoding(){
		this.rand = new Random();
		this.scan = new Scanner(System.in);
	}

	// formula = (char) char(i)**2
	public String encodeStringMethod1(String arg){
		String encoded = "";
		for(char chr : arg.toCharArray()){
			int num = (int)chr*(int)chr;
			// int num = (int)chr;
			// System.out.print("" + num + " ");
			encoded += (char)num;
		}
		return encoded;
	}
	public String decodeStringMethod1(String arg){
		String decoded = "";
		for(char chr : arg.toCharArray()){
			int num = (int)Math.sqrt((int)chr);
			decoded += (char)num;
		}
		return decoded;
	}

	public static void main (String[] args){
		Encoding encode = new Encoding();
		System.out.print("Input text >> ");
		String userInput = scan.nextLine();

		String string1 = encode.encodeStringMethod1(userInput);
		String string2 = encode.decodeStringMethod1(string1);

		System.out.println(string1);
		System.out.println(string2);
	}
}
