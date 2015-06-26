/*Miranda Li
UNI: mjl2206
COMS 3137 Sec 001
Professor Peter Allen
*/

import java.util.*;

/**Prints change of a cent value in quarters, dimes, and nickels*/
public class ChangeMaker {

    public static final int QUARTER = 25;
    public static final int DIME = 10;
    public static final int NICKEL = 5;
    
    /**Makes Change for given amount.  Calls the other makeChange method.
       @param amount the amount
    */
    public void makeChange( int amount ) {
	if(( amount % 5 ) != 0 || amount <= 0 )
	    System.out.println ( amount + " can't be changed." );
	else {
	    String s = "Change for " + amount + " = ";
	    if( amount >= QUARTER )
		makeChange( amount, QUARTER, s );
	    if( amount >= DIME )
		makeChange( amount, DIME, s );
	    if( amount >= NICKEL )
		makeChange( amount, NICKEL, s );
	}
    }

    /** Recursively prints the change.  The max the the amount you are reducing in this step, and you cannot increase it for the next step (so if you reduce by dimes for this step, you have to reduce by dimes or nickels, not quarters, for the next step).  A
       @param amount the amount
       @param max the max to reduce at this step
       @param s the String to add on to at this step.
    */
    public void makeChange( int amount, int max, String s ) {
	if( amount == 0 ) 
	    System.out.println(s);
	else {
	    String newS = s + " " + max;
	    int newAmount = amount - max;
	    if( newAmount == 0 ) //if, after you subtract, the amount is 0, just call makeChange again and you will print the String s.
		makeChange( 0, max, newS );
	    if( max == QUARTER ) {
		if( newAmount >= QUARTER )
		    makeChange( newAmount, QUARTER, newS );
		if( newAmount >= DIME )
		    makeChange( newAmount, DIME, newS );
		if( newAmount >= NICKEL )
		    makeChange( newAmount, NICKEL, newS );
	    }
	    if( max == DIME ) {
		if( newAmount >= DIME )
		    makeChange( newAmount, DIME, newS );
		if( newAmount >= NICKEL )
		    makeChange( newAmount, NICKEL, newS );
	    }
	    if( max == NICKEL ) {
		if( newAmount >= NICKEL )
		    makeChange( newAmount, NICKEL, newS );
	    }
	}
    }
    

    /**Main method tester: takes user input.
       @param args the user input to makeChange to.
    */
    public static void main( String[] args ) {
	ChangeMaker a = new ChangeMaker();
	a.makeChange( Integer.parseInt( args[0] ));
    }
}
