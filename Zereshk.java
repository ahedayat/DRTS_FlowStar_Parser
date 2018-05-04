import java.util.*;
import java.lang.*;

public class Zereshk{
	public static void main(String[] args) {
		try{
			CBFile cbf = new CBFile();


			cbf.open("input.txt");
			// cbf.print();

			// Integer statementCounter = new Integer(0);
			
			// while( cbf.next() ){
			// 	++statementCounter;
			// 	String str = cbf.forward();
			// 	System.out.println( statementCounter + " |" +  str );
			// }

			// System.out.println("----------------------------------------------------------------");
			// cbf.print2();
			// System.out.println("----------------------------------------------------------------");

			// statementCounter = new Integer(0);
			// while( cbf.previous() ){
			// 	++statementCounter;
			// 	String str = cbf.backward();
			// 	System.out.println( statementCounter + "|" + str );
			// }
			
			// System.out.println("----------------------------------------------------------------");
			// cbf.print2();
			// System.out.println("----------------------------------------------------------------");

			// statementCounter = new Integer(0);
			// while( cbf.next() ){
			// 	++statementCounter;
			// 	String str = cbf.forward();
			// 	System.out.println( statementCounter + " |" +  str );
			// }



		}catch(Exception e){
			System.out.println(e);
		}
	}
}