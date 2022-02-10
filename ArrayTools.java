/**
 * Name            : Fikrath Hassan
 * Student Number  : A00254511
 * Program         : Mobile Application Development (MAPD)
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayTools {

    public static void main(String[] args) {

        Scanner usrInput = new Scanner(System.in);

        String usrString;
        int encryptionValue;
        String encryptedString = "";
        String decryptedString = "";

        int lengthOfArray;
        float arrayAvg = 0;
        int[] usrArray;
        
        int usrValue;
        boolean arrayHasValue = false;

        int[] reversedArray;

        // Collect a string and value for encryption the string and decryption
        System.out.println();
        System.out.print("Enter a string to encrypt: ");
        usrString = usrInput.nextLine();
        usrString = usrString.toLowerCase();

        System.out.print("Enter a value to encrypt with: ");
        try {
            encryptionValue = usrInput.nextInt();
        } catch (InputMismatchException e) {
            usrInput.close();
            System.out.println("Please input a integer number!");
            System.out.println();
            return;
        }

        encryptedString = encrypt(usrString, encryptionValue);
        System.out.println("The encrypted string is " + encryptedString);

        decryptedString = decrypt(encryptedString, encryptionValue);
        System.out.println("Decrypting " + encryptedString + " with -" + encryptionValue + "...");
        System.out.println(decryptedString);
        System.out.println();

        // Collect array length and elements from user
        System.out.print("Enter the length of array: ");
        try {
            lengthOfArray = usrInput.nextInt();
        } catch (InputMismatchException e) {
            usrInput.close();
            System.out.println("Please input a valid number!");
            return;
        }
        usrArray = new int[lengthOfArray];

        System.out.println("Enter numerical values:");
        for (int i = 0; i < lengthOfArray; i++) {
            try {
                usrArray[i] = usrInput.nextInt();
            } catch (InputMismatchException e) {
                usrInput.close();
                System.out.println("Please input a valid number!");
                return;
            }
        }
        System.out.println();

        System.out.print("Testing methods with [ ");
        for (int i = 0; i < usrArray.length; i++) {
            System.out.print(usrArray[i] + " ");
        }
        System.out.print("]");
        System.out.println();

        // Print average of elements in an array
        arrayAvg = arrayAvg(usrArray);
        System.out.println("The average is " + String.format("%.1f", arrayAvg));
        System.out.println();

        // Check whether a value contains in the array
        System.out.print("Enter a value to search for: ");
        try {
            usrValue = usrInput.nextInt();
        } catch (InputMismatchException e) {
            usrInput.close();
            System.out.println("Please input a valid number!");
            return;
        }
        arrayHasValue = arrayContains(usrArray, usrValue);
        if (arrayHasValue) {
            System.out.println("The array contains " + usrValue);
        } else {
            System.out.println("The array does not contain " + usrValue);
        }
        System.out.println();
        
        // Reverse an array and print
        reversedArray = reverse(usrArray);
        System.out.print("The array reversed is [ ");
        for (int i = 0; i < reversedArray.length; i++) {
            System.out.print(reversedArray[i] + " ");
        }
        System.out.print("]");
        System.out.println();
        System.out.println();

        usrInput.close();
    }

    /**
     * This method accepts the string and value for encryption
     * from the user and returns a string type variable which encrypted
     */
    static String encrypt(String usrString, int encryptionValue) {

        String result = "";
        char index;

        for (int i = 0; i < usrString.length(); i++) {
            index = usrString.charAt(i);
            index = (char)(index + encryptionValue);
            result = result + index;
        }

        return result;

    }

    /**
     * This method accepts encrypted string and value used for encryption
     * and returns a string type variable which contains an original
     * string user input for encryption. 
     */
    static String decrypt(String encryptedValue, int encryptionValue) {

        String result = "";
        char index;

        for (int i = 0; i < encryptedValue.length(); i++) {
            index = encryptedValue.charAt(i);
            index = (char)(index - encryptionValue);
            result = result + index;
        }

        return result;

    }

    /**
     * This method returns a float type variable which contains average
     * value of the total values in an array that user input.
     */
    static float arrayAvg(int[] usrArray) {

        float arrayAvg, arraySum = 0;

        for (int i = 0; i < usrArray.length; i++) {
            arraySum += usrArray[i];
        }

        arrayAvg = arraySum/usrArray.length;

        return arrayAvg;
    }

    /**
     * This method returns a boolean type variable which 
     * returns true, if the array contains user input value. 
     */
    static boolean arrayContains(int[] usrArray, int usrValue) {

        boolean arrayHasValue = false;

        for (int i = 0; i < usrArray.length; i++) {
            if (usrArray[i] == usrValue) {
                arrayHasValue = true;
                break;
            }
        }

        return arrayHasValue;

    }

    /**
     * This method returns an array which is a reversed array
     * of user input array.
     */
    static int[] reverse(int[] usrArray) {

        int[] reversedArray;

        reversedArray = new int[usrArray.length];
        for (int i = 0; i < usrArray.length; i++) {
            reversedArray[i] = usrArray[usrArray.length - 1 - i];
        }

        return reversedArray;

    }
    
}