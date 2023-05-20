
    /*
    * ValidPassApp.java
    * V Murphy
    * 11/05/23
    */
    import java.util.*;

    public class ValidPassApp {
        public static void main(String args[]) {

            // variables
            String userAlias;
            String output;
            int numAliases;
            int numPasswords;
            int[] numArray;

            // bring in objects
            Scanner keyboard = new Scanner(System.in);
            ValidPass passCheck = new ValidPass();

            // determine how many aliases the user wishes to enter
            System.out.println("How many aliases do you wish to validate?");
            numAliases = keyboard.nextInt();

            // for loop will allow the user to enter multiple aliases. As per approach MAA1
            for (int i = 0; i < numAliases; i++) {
                // take user input
                System.out.println("Enter your User Alias:");
                userAlias = keyboard.next();

                // send input to compute class
                passCheck.setUserAlias(userAlias);

                // call compute function
                passCheck.checkAlias();

                // get result from compute class
                output = passCheck.getOutput();

                // display output
                System.out.println(output);
            }


            //Question 2 B
            // Take input on how many passwords the user wishes to generate/numbers to be passed as a parameter for the modulo calculation
            System.out.println("How many passwords do you wish to generate? Minimum of three permitted.");
            numPasswords = keyboard.nextInt();
            //Ensure there are at least three passwords entered 
            if (numPasswords >= 3) {
                // Generate the array of numbers to be passed as a parameter for the Modulo calculation
                numArray = new int[numPasswords];
                for (int i = 0; i < numArray.length; i++) {
                    numArray[i] = (int) Math.floor(Math.random() * (19 - 11 + 1) + 11);
                }
                passCheck.generatePassword(numPasswords, numArray);
            }
            else{
                System.out.println("Insufficient number of passwords");
            }
                
        }
    }
