/*
* ValidPass.java
* V Murphy
* 11/05/23
* Student Number x22208984
*/
public class ValidPass {
    // data members
    private String userAlias;
    private String output;

    // Constructor
    public validPass(){
        userAlias = "";
        output ="";
    }

    // Setters
    public void setUserAlias(String userAlias) {
        this.userAlias = userAlias;
    }

    // compute methods

    // this compute method will validate the user's alias per the Bank of Irleand
    // Criteria per approach AR2
    public void checkAlias() {
        // boolean used for checking input
        boolean check1;
        // ints used later during for loop execution
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;

        // ensure given alias is the correct length
        if (userAlias.length() == 24) {
            // Check whether first eight characters are correct format
            if (userAlias.substring(0, 8).equalsIgnoreCase("54326740")) {
                // if first eight characters are correct, check subsequent 4 characters
                if (userAlias.substring(8, 12).equalsIgnoreCase("bofi")) {
                    // ensure next character is a single digit from 0-9
                    if (Character.isDigit(userAlias.charAt(12))) {
                        // for loop to cycle through next eight characters to ensure they are digits
                        for (int i = 14; i <= 21; i++) {
                            if (Character.isDigit(userAlias.charAt(i))) {
                                // count will increment anytime one of the characters from index 14-21 is a
                                // digit
                                // if count doesn't end up at eight, one of the characters wasn't a digit and
                                // the test fails
                                count1++;
                            }
                        }
                        // If count1 is 8, all digits from characters 14-21 were digits
                        if (count1 == 8) {
                            // put CVN in a subsctring
                            String cvn = userAlias.substring(21, 24);
                            // ensure all characters of CVN are digits
                            for (int i = 0; i < cvn.length(); i++) {
                                if (Character.isDigit(cvn.charAt(i))) {
                                    count2++;
                                }
                            }
                            // if count2 is 3, all characters of CVN are digits
                            if (count2 == 3) {
                                // ensure each digit of CVN is the same value
                                for (int i = 0; i < cvn.length(); i++) {
                                    if (cvn.charAt(i) == cvn.charAt(0)) {
                                        count3++;
                                    }
                                }
                                // we have ensured every digit of cvn matches
                                if (count3 == 3) {
                                    check1 = true;
                                }
                                // false because CVN digits aren't all the same
                                else {
                                    check1 = false;
                                }
                            }
                            // false because the CVN did not consist entirely of digits
                            else {
                                check1 = false;
                            }
                            // ensure all digits are the same value

                        }
                        // false because one of the relavent characters was not a digit
                        else {
                            check1 = false;
                        }
                    }
                    // false because the character was not a digit
                    else {
                        check1 = false;
                    }

                }
                // false because the BOFI characters were incorrect
                else {
                    check1 = false;
                }
            }
            // false because first eight digits are incorrect
            else {
                check1 = false;
            }
        }
        // False because Alias length is invalid
        else {
            check1 = false;
        }

        // give output dependant on whether conditions were met
        if (check1 == true) {
            output = "Alias Valid";
        }

        else {
            output = "Alias Not Valid";
        }

    }

    // Question 2 A PWD2
    // Mehtod to generate and return array of passwords
    public String[] generatePassword(int numPasswords, int[] numArray) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String[] pwArray = new String[numPasswords];

        // for loop extracts a random char from the alphabet and concatenates them onto
        // a string
        for (int i = 0; i < numPasswords; i++) {
            String pw = "";
            for (int j = 0; j < 6; j++) {
                int randomIndex = (int) Math.floor(Math.random() * (0 - 26 + 1) + 26);
                pw += alphabet.charAt(randomIndex);
            }
            // Append # to PW
            pw += "#";
            // append remdainder calculation based on 49556891
            pw += 49556891 % numArray[i];
            //populate the password array with the newly generated passwords
            pwArray[i] = pw;
        }
        //cycle through the array of newly created passwords and display them to the suer
        for (int i = 0; i < pwArray.length; i++) {
            System.out.println("Password " + (i + 1) + ": " + pwArray[i]);
        }

        return pwArray;
    }

    // getters
    public String getOutput() {
        return output;
    }

}
