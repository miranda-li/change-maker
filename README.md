change-maker-hw1
================

Gives the amount of quarters, dimes, nickels a cent amount can be split into.  HW1 practice on recursion.

To run: in the command line, compile javac ChangeMaker.java, then run java ChangeMaker [value to change].

Anything non-positive or indivisible by 5 cannot be changed (it will print “[number] cannot be changed”).

A practice on recursion:

I created two makeChange() methods; one takes an int (the cent amount you want to change), and one takes an int (the cent amount), a max int, and a String s.  A call to the first makeChange calls the second, passing into the String “Change for [the amount] = “ and the three maxes, 25, 10, and 5 (if the amount to change is greater than the maxes).

The second makeChange() method adds on the max value to the String, then subtracts the max from the amount and calls makeChange() 3 (or fewer) more times, setting the max to 25, 10, and 5 (quarter, dime, and nickel) only if the new amount is greater than the max.  To avoid duplication, the max can only go down; you cannot call a makeChange() with a max of 10, then from there, a max of 25.  This will recursively print out all the combinations of change.
