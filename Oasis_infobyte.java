package Oasis_package;
import java.util.*;
public class Oasis_infobyte {

	public static void main(String[] args) {
		
     Random random_obj=new Random();
     int random_value=random_obj.nextInt(100)+1;
     while(true) {
     System.out.println("Enter your guess number :");
     Scanner sc=new Scanner(System.in);
     int user_guess=sc.nextInt();
     if(random_value==user_guess) {
    	 System.out.println("You win !");
    	 break;
     }
     else if(random_value>user_guess) {
    	 System.out.println("Random value is higher than you entered...");
     }
     else {
    	 System.out.println("Random values is lower than you entered");
     }
	}
	}
}
