package oasis_infobyte;
import java.util.*;
public class NumberGuess {

	public static void main(String[] args) {
		
     Random r=new Random();
     int random_value=r.nextInt(100)+1;
     int count=0;
     while(true) {
    	 System.out.println("Enter the numbers between 1-100 :");
    	 Scanner s=new Scanner(System.in);
    	 count++;
    	 int user_guess=s.nextInt();
    	 if(random_value==user_guess) {
    		 System.out.println("You win at "+count+"attempt!");
    		 break;
    	 }
    	 else if(random_value>user_guess) {
    		 System.out.println("Random value is higher than you entered !");
    	 }
    	 else {
    		 System.out.println("Random value is lower than you entered !");
    	 }
     }
	}

}
